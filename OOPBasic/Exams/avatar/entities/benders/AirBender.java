package avatar.entities.benders;

import static avatar.utilities.Constants.AIR;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, long power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.aerialIntegrity;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "Aerial Integrity: %.2f", AIR, super.getName(), super.getPower(), this.aerialIntegrity);
    }
}
