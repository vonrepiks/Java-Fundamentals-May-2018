package vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public boolean drive(double distance) {
        double neededFuel = distance * this.fuelConsumptionPerKilometer;
        if (this.fuelQuantity < neededFuel) {
            return false;
        }

        this.fuelQuantity -= neededFuel;
        return true;
    }

    public void refuel(double fuelQuantity) {
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
