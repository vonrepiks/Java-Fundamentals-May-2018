package avatar.entities.benders;

import static avatar.utilities.Constants.EARTH;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, long power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.groundSaturation;
    }

    @Override
    public String toString() {
        return  String.format(super.toString() + "Ground Saturation: %.2f", EARTH, super.getName(), super.getPower(), this.groundSaturation);
    }
}
