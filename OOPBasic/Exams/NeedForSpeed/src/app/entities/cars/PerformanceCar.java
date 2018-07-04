package app.entities.cars;

import java.util.ArrayList;
import java.util.Collection;

public class PerformanceCar extends Car {

    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void setHorsepower(int horsepower) {
        int increasedHorsePower = horsepower + ((horsepower * 50) / 100);
        super.setHorsepower(increasedHorsePower);
    }

    @Override
    public void setSuspension(int suspension) {
        int decreasedSuspension = suspension - ((suspension * 25) / 100);
        super.setSuspension(decreasedSuspension);
    }

    @Override
    public String toString() {
        StringBuilder performanceCar = new StringBuilder(super.toString());

        String addOns = this.addOns.size() == 0 ? "None" : String.join(", ", this.addOns);

        performanceCar
                .append(String.format("Add-ons: %s", addOns));

        return performanceCar.toString();
    }

//    @Override
//    public void tune(Object... params) {
//        String addon = (String) params[0];
//        this.addOns.add(addon);
//    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        this.addOns.add(addOn);
    }
}
