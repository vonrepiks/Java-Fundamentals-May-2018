import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMethods {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        Collections.addAll(numbers, 2, 4, 1, 3, 0, 8, 5);

         numbers.sort(Integer::compareTo);
         numbers.sort(Comparator.reverseOrder());
         numbers.sort((a, b) -> Integer.compare(a, b));
         numbers.sort((a, b) -> b - a);

        System.out.println(numbers);
    }
}
