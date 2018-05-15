import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattingNumbers {
    private static final int MAX_LENGTH = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int first = Integer.parseInt(input[0]);
        double second = Double.parseDouble(input[1]);
        double third = Double.parseDouble(input[2]);

        String hex = String.format("%x", first).toUpperCase();
        String binary = Integer.toBinaryString(first);
        String secondAfterFormat = String.format("%.2f", second);
        String thirdAfterFormat = String.format("%.3f", third);

        String result = String.format("|%s|%s|%s|%s|",
                getPadRight(hex, " "),
                getPadLeft(binary, "0"),
                getPadLeft(secondAfterFormat, " "),
                getPadRight(thirdAfterFormat, " ")
        );

        System.out.println(result);
    }

    private static String getPadRight(String string, String fill) {
        return string + new String(new char[MAX_LENGTH - string.length()]).replace("\0", fill);
    }

    private static String getPadLeft(String string, String fill) {
        return new String(new char[MAX_LENGTH - string.length()]).replace("\0", fill) + string;
    }
}