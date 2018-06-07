import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> regionData = new LinkedHashMap<>();

        // endData before last sorting for the print
        Map<String, Map<String, Long>> endData;

        String line;
        while (!"Count em all".equals(line = reader.readLine())) {
            String[] tokens = line.split(" -> ");

            String regionName = tokens[0].trim();
            String meteorType = tokens[1].trim();
            Long amount = Long.parseLong(tokens[2].trim());

            addRegionData(regionData, regionName, meteorType, amount);
        }

        regionData.entrySet().stream()
                .sorted(Comparator
                        .comparing((Map.Entry<String, Map<String, Long>> region) -> region.getValue().get("Black"), Comparator.reverseOrder())
                        .thenComparing((Map.Entry<String, Map<String, Long>> region) -> region.getKey().length())
                        .thenComparing(Map.Entry::getKey))
                .forEach(x -> {
                    StringBuilder region = new StringBuilder(x.getKey()).append(System.lineSeparator());

                    x.getValue().entrySet().stream()
                            .sorted(Comparator
                                    .comparing((Map.Entry<String, Long> meteor) -> meteor.getValue(), Comparator.reverseOrder())
                                    .thenComparing((Map.Entry<String, Long> meteor) -> meteor.getKey())
                            )
                            .forEach(meteor -> {
                                region.append(String.format("-> %s : %d", meteor.getKey(), meteor.getValue())).append(System.lineSeparator());
                            });
                    System.out.print(region.toString());
                });
    }

    private static void addRegionData(Map<String, Map<String, Long>> regionData, String regionName,
                                      String meteorType, Long amount) {

        if (!regionData.containsKey(regionName)) {
            Map<String, Long> meteorDataDefaultValues = new HashMap<>();
            meteorDataDefaultValues.put("Green", 0L);
            meteorDataDefaultValues.put("Red", 0L);
            meteorDataDefaultValues.put("Black", 0L);

            regionData.put(regionName, meteorDataDefaultValues);
        }

        Map<String, Long> meteorData = regionData.get(regionName);
        if (meteorData.containsKey(meteorType)) {
            Long oldAmount = meteorData.get(meteorType);
            Long newAmount = oldAmount + amount;
            meteorData.put(meteorType, newAmount);

            modifyMeteorAmountData(meteorData);
        } else {
            meteorData.put(meteorType, amount);
        }
    }

    private static void modifyMeteorAmountData(Map<String, Long> meteorData) {
        long greenAmount = meteorData.get("Green");
        long redAmount = meteorData.get("Red");
        long blackAmount = meteorData.get("Black");

        while (greenAmount >= 1000000) {
            redAmount++;
            greenAmount -= 1000000;
        }

        while (redAmount >= 1000000) {
            blackAmount++;
            redAmount -= 1000000;
        }

        meteorData.put("Green", greenAmount);
        meteorData.put("Red", redAmount);
        meteorData.put("Black", blackAmount);
    }

}