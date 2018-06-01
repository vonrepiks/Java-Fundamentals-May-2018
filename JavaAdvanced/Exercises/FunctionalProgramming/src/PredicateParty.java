import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] namesArray = reader.readLine().split("\\s+");
        List<String> guests = new ArrayList<>();
        Collections.addAll(guests, namesArray);

        String line;
        while (true) {
            if ("Party!".equals(line = reader.readLine())) {
                break;
            }

            String[] commandTokens = line.split("\\s+");
            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String parameter = commandTokens[2];

            switch (command) {
                case "Double":
                    List<String> additionalGuests = new ArrayList<>();
                    for (String guest : guests) {
                        if (getPredicate(predicateType, parameter).test(guest)) {
                            additionalGuests.add(guest);
                        }
                        additionalGuests.add(guest);
                    }
                    guests = additionalGuests;
                    break;
                case "Remove":
                    guests.removeIf(getPredicate(predicateType, parameter));
                    break;
            }
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.format("%s are going to the party!", String.join(", ", guests)));
        }
    }

    private static Predicate<String> getPredicate(String predicateType, String parameter) {

        switch (predicateType) {
            case "StartsWith":
                return (quest) -> quest.startsWith(parameter);
            case "EndsWith":
                return (quest) -> quest.endsWith(parameter);
            default:
                return (quest) -> quest.length() == Integer.parseInt(parameter);
        }
    }
}
