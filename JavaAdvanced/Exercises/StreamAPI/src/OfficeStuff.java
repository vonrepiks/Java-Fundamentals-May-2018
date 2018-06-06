import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Map<String, Integer>> companies = new HashMap<>();

        while (n-- > 0) {

            String[] tokens = Arrays.stream(reader.readLine().split("[\\s\\-|]+"))
                    .filter(e -> !e.equals(""))
                    .toArray(String[]::new);

            String companyName = tokens[0];
            int productAmount = Integer.parseInt(tokens[1]);
            String productName = tokens[2];

            Map<String, Integer> products = new LinkedHashMap<>();
            if (companies.containsKey(companyName)) {
                products = companies.get(companyName);
            }

            int totalAmount = productAmount;
            if (products.containsKey(productName)) {
                totalAmount += products.get(productName);
            }

            products.put(productName, totalAmount);
            companies.put(companyName, products);
        }

        final int[] number = {1};
        companies.entrySet().stream()
                .sorted(Comparator.comparing(c -> c.getKey()))
                .forEach(c -> {
                    number[0] += 1;
                    StringBuilder company = new StringBuilder(String.format("%s: ", c.getKey()));
                    String products = c.getValue().entrySet().stream()
                            .map(p -> String.format("%s-%s", p.getKey(), p.getValue()))
                            .collect(Collectors.joining());
                    company.append(products).append(System.lineSeparator());

                    System.out.print(company);
                });
    }
}
