import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            sb.append(line).append(System.lineSeparator());
        }

        String result = sb.toString();
        Pattern pattern = Pattern.compile("(<a)\\s+href[^>]+(>)\\s*.*?(</a>)");
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()) {
            String entireGroups = matcher.group(0);
            String openATag = matcher.group(1);
            String closeOpenATag = matcher.group(2);
            String closeATag = matcher.group(3);
            String replacement = entireGroups.replaceFirst(openATag, "[URL");
            replacement = replacement.replaceFirst(closeOpenATag, "]");
            replacement = replacement.replaceFirst(closeATag, "[/URL]");
            result = result.replace(entireGroups, replacement);
        }

        System.out.println(result);
    }
}
