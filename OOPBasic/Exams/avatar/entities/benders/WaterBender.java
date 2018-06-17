package avatar.entities.benders;

import static avatar.utilities.Constants.WATER;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, long power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.waterClarity;
    }


    @Override
    public String toString() {
        return  String.format(super.toString() + "Water Clarity: %.2f", WATER, super.getName(), super.getPower(), this.waterClarity);
    }
}
