import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FirstOddOrEvenElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] sequence = reader.readLine().split("\\s+");
        String[] tokens = reader.readLine().split("\\s+");

        getFirstOddOrEvenElements(sequence, Integer.parseInt(tokens[1]), tokens[2]);
    }

    private static void getFirstOddOrEvenElements(String[] sequence, int maxCount, String kindOfElement) {
        int counter = 0;

        List<String> result = new ArrayList<>();
        for (String s : sequence) {
            if (counter >= maxCount) {
                break;
            }
            if (checkKind(s, kindOfElement)) {
                result.add(s);
                counter++;
            }
        }
        System.out.println(String.join(" ", result));
    }

    private static boolean checkKind(String s, String kindOdElement) {
        if ("odd".equals(kindOdElement)) {
            return Integer.parseInt(s) % 2 != 0;
        } else {
            return Integer.parseInt(s) % 2 == 0;
        }
    }
}
