import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PopulationCounterSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Country> countries = new LinkedHashMap<>();

        String line;
        while (true) {
            if ("report".equals(line = scanner.nextLine())) {
                break;
            }

            String[] tokens = line.split("\\|");
            String cityName = tokens[0];
            String countryName = tokens[1];
            long population = Long.parseLong(tokens[2]);

            City city = new City(cityName, population);

            Country country;
            if (countries.containsKey(countryName)) {
                country = countries.get(countryName);
            } else {
                country = new Country(countryName);
            }

            country.addCity(city);

            countries.putIfAbsent(countryName, country);
        }

        Map<String, Country> sortedCountries = countries
                .entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue().getTotalPopulation(), a.getValue().getTotalPopulation()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Country country : sortedCountries.values()) {
            System.out.print(country);
        }
    }
}

class Country {
    private String countryName;
    private List<City> cities;

    public Country(String countryName) {
        this.countryName = countryName;
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public long getTotalPopulation() {
        return this.cities.stream().map(City::getPopulation).mapToLong(Long::valueOf).sum();
    }

    @Override
    public String toString() {
        List<City> sortedCities = this.cities.stream().sorted(Comparator.comparingLong(City::getPopulation).reversed()).collect(Collectors.toList());

        String country = this.countryName + " (total population: " + this.getTotalPopulation() + ")\n";
        for (City city : sortedCities) {
            country += city + "\n";
        }
        return country;
    }
}

class City {
    private String cityName;
    private Long population;

    public City(String cityName, Long population) {
        this.cityName = cityName;
        this.population = population;
    }

    public Long getPopulation() {
        return this.population;
    }

    @Override
    public String toString() {
        return "=>" + this.cityName + ": " + this.population;
    }
}
