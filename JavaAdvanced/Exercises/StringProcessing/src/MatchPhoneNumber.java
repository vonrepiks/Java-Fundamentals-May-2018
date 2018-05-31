import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String pattern = "\\+359(-|\\s)2(\\1)(\\d{3})(\\1)(\\d{4})$";

        String phoneNumber;
        while (true) {
            if ("end".equals(phoneNumber = reader.readLine())) {
                break;
            }

            if (phoneNumber.matches(pattern)) {
                System.out.println(phoneNumber);
            }
        }
    }
}
