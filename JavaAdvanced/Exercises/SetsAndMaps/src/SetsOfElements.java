import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lengths = scanner.nextLine().split("\\s+");
        int firstLength = Integer.parseInt(lengths[0]);
        int secondLength = Integer.parseInt(lengths[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        fillSet(scanner, firstLength, firstSet);
        fillSet(scanner, secondLength, secondSet);

        String result = "";
        for (String element : firstSet) {
            if (secondSet.contains(element)) {
                result += element + " ";
            }
        }
        if (!"".equals(result)) {
            System.out.println(result.trim());
        }
    }

    private static void fillSet(Scanner scanner, int length, Set<String> set) {
        for (int i = 0; i < length; i++) {
            set.add(scanner.nextLine());
        }
    }
}
