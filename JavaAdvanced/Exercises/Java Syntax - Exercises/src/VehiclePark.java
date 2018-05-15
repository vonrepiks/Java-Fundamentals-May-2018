import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehiclePark {
    private static final String TERMINATE_COMMAND = "End of customers!";
    static int sellVehicles = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] vehicles = reader.readLine().split("\\s+");

        List<String> listOfVehicles = new ArrayList<>();

        Collections.addAll(listOfVehicles, vehicles);

        String line;
        while (true) {
            if (TERMINATE_COMMAND.equals(line = reader.readLine())) {
                break;
            }
            String[] vehicleForSell = line.split("\\s+");
            String vehicleType = vehicleForSell[0];
            int countOfSeats = Integer.parseInt(vehicleForSell[2]);

            switch (vehicleType) {
                case "Car":
                    sellCar(listOfVehicles, 'c', countOfSeats);
                    break;
                case "Bus":
                    sellCar(listOfVehicles, 'b', countOfSeats);
                    break;
                case "Van":
                    sellCar(listOfVehicles, 'v', countOfSeats);
                    break;
                default:
                    break;
            }
        }

        System.out.println(String.format("Vehicles left: %s", String.join(", ", listOfVehicles)));
        System.out.println(String.format("Vehicles sold: %s", sellVehicles));
    }

    private static void sellCar(List<String> listOfVehicles, char vehicleTypeSymbol, int countOfSeats) {
        boolean cell = false;
        for (int i = 0; i < listOfVehicles.size(); i++) {
            if (listOfVehicles.get(i).equals(String.valueOf(vehicleTypeSymbol) + countOfSeats)) {
                cell = true;
                listOfVehicles.remove(i);
                int price = vehicleTypeSymbol * countOfSeats;
                System.out.println(String.format("Yes, sold for %s$", price));
                sellVehicles++;
                break;
            }
        }
        if (!cell) {
            System.out.println("No");
        }
    }
}
