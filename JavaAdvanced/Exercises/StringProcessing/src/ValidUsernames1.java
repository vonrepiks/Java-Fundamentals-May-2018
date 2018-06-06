import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        String data = reader.readLine();

        Matcher matcher = Pattern.compile("[^/()\\\\\\s]\\w{2,24}").matcher(data);

        List<String> usernames = new ArrayList<>();
        while (matcher.find()) {
            if (Character.isLetter(matcher.group().charAt(0))) {
                usernames.add(matcher.group());
            }
        }

        int longestSum = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < usernames.size() - 1; i++) {
            String current = usernames.get(i);
            String next = usernames.get(i + 1);
            int sum = current.length() + next.length();
            if (sum > longestSum) {
                longestSum = sum;
                index = i;
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(usernames.get(index + i));
        }
    }
}