package vehicles_extension;

public abstract class Vehicle {
    private static final String INVALID_FUEL_QUANTITY_EXCEPTION_MESSAGE = "Fuel must be a positive number";
    private static final String INVALID_REFUEL_QUANTITY_EXCEPTION_MESSAGE = "Cannot fit fuel in tank";

    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
    }

    private void setFuelQuantity(double fuelQuantity) {
         this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public boolean drive(double distance, double summer_mode_on) {
        double neededFuel = distance * (this.fuelConsumptionPerKilometer + summer_mode_on);
        if (this.fuelQuantity < neededFuel) {
            return false;
        }

        this.fuelQuantity -= neededFuel;
        return true;
    }

    public boolean drive(double distance) {
        return this.drive(distance, 0);
    }

    public void refuel(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException(INVALID_FUEL_QUANTITY_EXCEPTION_MESSAGE);
        }
        if (fuelQuantity + this.fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException(INVALID_REFUEL_QUANTITY_EXCEPTION_MESSAGE);
        }
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
