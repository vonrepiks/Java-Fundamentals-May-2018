import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String patternUser = "(^|\\s)[\\dA-Za-z][\\w\\-.]+?[\\dA-Za-z]";
        String patternHost = "[A-Za-z][A-Za-z-.]*?(\\.[A-Za-z-.]*?[A-Za-z]+)+";

        String input = reader.readLine();

        Pattern patternEmail = Pattern.compile(patternUser + "@" + patternHost);
        Matcher matcher = patternEmail.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group(0).trim());
        }
    }
}
