package border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifable> identifables = new ArrayList<>();

        String line;
        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            Identifable identifable = null;
            if (tokens.length == 2) {
                identifable = new Robot(tokens[0], tokens[1]);
            } else if (tokens.length == 3) {
                identifable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            identifables.add(identifable);
        }

        String lastDigitsFakeId = reader.readLine();

        identifables
                .stream()
                .filter(identifable -> identifable.getId().endsWith(lastDigitsFakeId))
                .forEach(identifable -> System.out.println(identifable.getId()));
    }
}
