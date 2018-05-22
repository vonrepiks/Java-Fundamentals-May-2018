import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("report".equals(line = scanner.nextLine())) {
                break;
            }

            String[] tokens = line.split("\\|");
            String cityName = tokens[0];
            String countryName = tokens[1];
            long population = Long.parseLong(tokens[2]);

            Map<String, Long> cities = new LinkedHashMap<>();
            if (countries.containsKey(countryName)) {
                cities = countries.get(countryName);
            }
            cities.put(cityName, population);

            countries.put(countryName, cities);
        }


        Map<String, Map<String, Long>> sortedCountries =
                countries.entrySet()
                        .stream()
                        .sorted((country1, country2) -> {
                            long populationCountry1 =
                                    country1.getValue()
                                            .values()
                                            .stream()
                                            .mapToLong(Long::valueOf)
                                            .sum();
                            long populationCountry2 =
                                    country2.getValue()
                                            .values()
                                            .stream()
                                            .mapToLong(Long::valueOf)
                                            .sum();
                            int comparator = Long.compare(populationCountry2, populationCountry1);
                            // long comparator = populationCountry2 - populationCountry1;
                            return comparator;
                        })
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));


        for (Map.Entry<String, Map<String, Long>> country : sortedCountries.entrySet()) {
            String citiesResult = "";
            long totalPopulation = 0;
            Map<String, Long> cities = country.getValue();
            Map<String, Long> sortedCities = cities.entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
            for (Map.Entry<String, Long> city : sortedCities.entrySet()) {
                citiesResult += "=>" + city.getKey() + ": " + city.getValue() + "\n";
                totalPopulation += city.getValue();
            }
            System.out.printf("%s (total population: %d)\n", country.getKey(), totalPopulation);
            System.out.print(citiesResult);
        }
    }
}