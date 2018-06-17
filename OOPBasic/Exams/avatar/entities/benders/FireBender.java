package avatar.entities.benders;

import static avatar.utilities.Constants.FIRE;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, long power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.heatAggression;
    }

    @Override
    public String toString() {
        return  String.format(super.toString() + "Heat Aggression: %.2f", FIRE, super.getName(), super.getPower(), this.heatAggression);
    }
}
