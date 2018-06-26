package vehicles_extension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
    }

    @Override
    public void refuel(double fuelQuantity) {
        double realFuelQuantity = fuelQuantity - ((fuelQuantity * 5) / 100);
        super.refuel(realFuelQuantity);
    }
}
