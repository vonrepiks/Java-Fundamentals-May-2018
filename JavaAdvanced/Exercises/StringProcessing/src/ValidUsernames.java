import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        String data = reader.readLine();

        String[] usernames = data.split("[\\s/\\\\()]+");

        List<String> validUsernames = new ArrayList<>();
        for (String username : usernames) {
            if (username.matches("^[A-Za-z]\\w{2,24}$")) {
                validUsernames.add(username);
            }
        }

        int longestSum = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < validUsernames.size() - 1; i++) {
            String current = validUsernames.get(i);
            String next = validUsernames.get(i + 1);
            int sum = current.length() + next.length();
            if (sum > longestSum) {
                longestSum = sum;
                index = i;
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(validUsernames.get(index + i));
        }
    }
}
