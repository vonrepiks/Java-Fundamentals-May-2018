import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

        String[] input = reader.readLine().split("\\s+");
        char[] first = input[0].toCharArray();
        char[] second = input[1].toCharArray();

        int result = 0;

        for (int i = 0; i < Math.max(first.length, second.length); i++) {
            if (i < first.length && i < second.length) {
                result += first[i] * second[i];
            } else if (i < first.length) {
                result += first[i];
            } else if (i < second.length) {
                result += second[i];
            }
        }

        System.out.println(result);
    }
}
