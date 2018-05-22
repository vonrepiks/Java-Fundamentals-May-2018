import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        int defaultHealth = 250;
        int defaultDamage = 45;
        int defaultArmor = 10;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfDragons = Integer.parseInt(reader.readLine());

        Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<>();

        String line;
        while (countOfDragons-- > 0) {
            String[] dragonTokens = reader.readLine().split("\\s+");

            String type = dragonTokens[0];
            String name = dragonTokens[1];

            int damage = defaultDamage;
            int health = defaultHealth;
            int armor = defaultArmor;
            if (!"null".equals(dragonTokens[2])) {
                damage = Integer.parseInt(dragonTokens[2]);
            }
            if (!"null".equals(dragonTokens[3])) {
                health = Integer.parseInt(dragonTokens[3]);
            }
            if (!"null".equals(dragonTokens[4])) {
                armor = Integer.parseInt(dragonTokens[4]);
            }

            Dragon dragon = new Dragon(name, damage, health, armor);

            Map<String, Dragon> dragonSkills = new LinkedHashMap<>();
            if (dragons.containsKey(type)) {
                dragonSkills = dragons.get(type);
            }
            dragonSkills.put(name, dragon);
            dragons.put(type, dragonSkills);
        }

        for (Map.Entry<String, Map<String, Dragon>> dragonEntry : dragons.entrySet()) {
            List<Dragon> sortedDragons = dragonEntry
                    .getValue()
                    .values()
                    .stream()
                    .sorted(Comparator.comparing(Dragon::getName))
                    .collect(Collectors.toList());
            double averageDamage = sortedDragons.stream().mapToInt(Dragon::getDamage).average().getAsDouble();
            double averageHealth = sortedDragons.stream().mapToInt(Dragon::getHealth).average().getAsDouble();
            double averageArmor = sortedDragons.stream().mapToInt(Dragon::getArmor).average().getAsDouble();
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", dragonEntry.getKey(), averageDamage, averageHealth, averageArmor));
            for (Dragon dragon : sortedDragons) {
                System.out.println(dragon);
            }
        }
    }
}

class Dragon {
    private String name;
    private int damage;
    private int health;
    private int armor;

    Dragon(String name, int damage, int health, int armor) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHealth() {
        return this.health;
    }

    public int getArmor() {
        return this.armor;
    }

    @Override
    public String toString() {
        return String.format("-%s -> damage: %d, health: %d, armor: %d", this.name, this.damage, this.health, this.armor);
    }
}