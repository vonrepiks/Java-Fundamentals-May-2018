import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String longLengthNumber = trimLeadingZeros(reader.readLine());
        String shortLengthNumber = trimLeadingZeros(reader.readLine());

        if (longLengthNumber.length() < shortLengthNumber.length()) {
            String temp = longLengthNumber;
            longLengthNumber = shortLengthNumber;
            shortLengthNumber = temp;
        }

        int overflow = 0;
        StringBuilder sb = new StringBuilder();
        int longLengthIndex = longLengthNumber.length() - 1;
        for (int shortLengthIndex = shortLengthNumber.length() - 1; shortLengthIndex >= 0; shortLengthIndex--, longLengthIndex--) {
            int firstDigit = longLengthNumber.charAt(longLengthIndex) - '0';
            int secondDigit = shortLengthNumber.charAt(shortLengthIndex) - '0';
            int digitSum = firstDigit + secondDigit + overflow;
            overflow = 0;
            int digit = digitSum;
            if (firstDigit + secondDigit >= 10) {
                digit = digitSum % 10;
                overflow++;
            }
            sb.append(digit);
        }

        for (int i = longLengthIndex; i >= 0; i--) {
            int digit = longLengthNumber.charAt(i) - '0';
            int digitSum = digit + overflow;
            overflow = 0;
            digit = digitSum;
            if (digit >= 10) {
                digit = digitSum % 10;
                overflow++;
            }
            sb.append(digit);
        }

        if (overflow > 0) {
            sb.append(overflow);
        }

        System.out.println(sb.reverse());
    }

    private static String trimLeadingZeros(String number) {
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                break;
            }
            counter++;
        }

        return number.substring(counter);
    }
}
