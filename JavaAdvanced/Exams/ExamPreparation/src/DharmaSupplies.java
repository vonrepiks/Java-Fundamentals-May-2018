import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DharmaSupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfLines = 0;
        StringBuilder lines = new StringBuilder();

        String line;
        while (true) {
            if ("Collect".equals(line = reader.readLine())) {
                break;
            }
            lines.append(line).append(System.lineSeparator());
            countOfLines++;
        }

        Pattern pattern = Pattern.compile("\\[.*?]");
        Matcher matcher = pattern.matcher(lines.toString());

        List<String> crates = new ArrayList<>();

        while (matcher.find()) {
            String crate = matcher.group();

            crates.add(crate);
        }

        int n = crates.size() / countOfLines;

        String validSupplyFoodTagRegex = "#\\d{" + n + "}";
        String validSupplyDrinkTagRegex = "#[a-z]{" + n + "}";
        String validSupplyBodyRegex = "[A-Za-z0-9\\s]+";

        String validCrateFoodRegex = "\\[" + validSupplyFoodTagRegex + validSupplyBodyRegex + validSupplyFoodTagRegex + "]";
        String validCrateDrinkRegex = "\\[" + validSupplyDrinkTagRegex + validSupplyBodyRegex + validSupplyDrinkTagRegex + "]";

        int validCrates = 0;
        int amountOfFood = 0;
        int amountOfDrink = 0;
        for (String crate : crates) {
            if (crate.matches(validCrateDrinkRegex)) {
                amountOfDrink += computeDrinkAmount(validSupplyDrinkTagRegex, amountOfDrink, crate);
                validCrates++;
            } else if (crate.matches(validCrateFoodRegex)) {
                amountOfFood += computeFoodAmount(validSupplyFoodTagRegex, amountOfFood, crate);
                validCrates++;
            }
        }

        if (validCrates == 0) {
            System.out.println("No supplies found!");
        } else {
            StringBuilder result = new StringBuilder(String.format("Number of supply crates: %d", validCrates)).append(System.lineSeparator());
            result.append(String.format("Amount of food collected: %d", amountOfFood)).append(System.lineSeparator());
            result.append(String.format("Amount of drinks collected: %d", amountOfDrink)).append(System.lineSeparator());
            System.out.println(result.toString());
        }
    }

    private static String extractBody(String crate, String validSupplyFoodTagRegex) {
        String body = Arrays.stream(crate
                .replace("[", "")
                .replace("]", "")
                .split(validSupplyFoodTagRegex))
                .filter(s -> !s.equals(""))
                .findFirst()
                .orElse(null);
        return body;
    }


    private static String extractTag(String crate, String body) {
        String tags  = crate
                .replace("[", "")
                .replace("]", "")
                .replace(body, "")
                .replace("#", "");
        return tags.substring(0, tags.length() / 2);
    }

    private static int computeDrinkAmount(String validSupplyDrinkTagRegex, int amountOfDrink, String crate) {
        String body = extractBody(crate, validSupplyDrinkTagRegex);

        int sumOfLettersOfBody = Arrays.stream(body.split("")).mapToInt(s -> s.charAt(0)).sum();
        int sumOfLettersOfTag = Arrays.stream(extractTag(crate, body).split("")).mapToInt(s -> s.charAt(0)).sum();
        return sumOfLettersOfBody * sumOfLettersOfTag;
    }

    private static int computeFoodAmount(String validSupplyFoodTagRegex, int amountOfFood, String crate) {
        String body = extractBody(crate, validSupplyFoodTagRegex);

        StringBuilder distinctBody = new StringBuilder();
        int sumOfLettersCode = 0;
        for (char c : body.toCharArray()) {
            if (distinctBody.indexOf(String.valueOf(c)) != -1) {
                continue;
            }

            distinctBody.append(c);
            sumOfLettersCode += c;
        }

        int countOfFoodTagLetters = extractTag(crate, body).length();

        return sumOfLettersCode * countOfFoodTagLetters;
    }
}
