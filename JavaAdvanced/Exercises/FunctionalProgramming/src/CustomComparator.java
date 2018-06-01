import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersArray = reader.readLine().split("\\s+");
        Integer[] numbers = new Integer[numbersArray.length];

        for (int i = 0; i < numbersArray.length; i++) {
            numbers[i] = Integer.parseInt(numbersArray[i]);
        }

        Comparator<Integer> integerComparator = (first, second) -> {
            boolean firstIsEven = first % 2 == 0;
            boolean secondIsEven = second % 2 == 0;
            if (firstIsEven && !secondIsEven) {
                return -1;
            } else if (!firstIsEven && secondIsEven) {
                return 1;
            } else {
                return first - second;
            }
        };

        Arrays.sort(numbers, integerComparator);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
