package vehicles;

public class Car extends Vehicle {
    private static final double SUMMER_MODE_PERMANENT_ON = 0.9;
    public Car(double fuelQuantity, double fuelConsumptionPerKilometer) {
        super(fuelQuantity, fuelConsumptionPerKilometer);
    }

    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + SUMMER_MODE_PERMANENT_ON);
    }
}
