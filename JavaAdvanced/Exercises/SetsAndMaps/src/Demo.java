import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.putIfAbsent("Tosho", 10);
        map.putIfAbsent("Miro", 5);
        map.putIfAbsent("Gosho", 10);
        map.putIfAbsent("Alex", 5);

        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted((a, b) -> {
            int comp1 = a.getKey().compareTo(b.getKey());

            if (comp1 != 0) {
                return comp1;
            }

            // return Integer.compare(a.getValue(), b.getValue());
            return a.getValue() - b.getValue();
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));


    }
}
