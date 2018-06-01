import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] numbersStringArray = reader.readLine().split("\\s+");
        Set<Integer> divisors = new HashSet<>();

        for (String string : numbersStringArray) {
            divisors.add(Integer.parseInt(string));
        }

        Predicate<Integer> predicate = (number) -> {
            for (Integer divisor : divisors) {
                if (number % divisor != 0) {
                    return false;
                }
            }
            return true;
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (predicate.test(i)) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
