package avatar.factories;

import avatar.entities.benders.*;

import static avatar.utilities.Constants.*;

public final class BenderFactory {

    private BenderFactory() {}

    public static Bender makeBender(String type, String name, long power, double secondaryParameter) {
        switch (type) {
            case AIR:
                return new AirBender(name, power, secondaryParameter);
            case WATER:
                return new WaterBender(name, power, secondaryParameter);
            case FIRE:
                return new FireBender(name, power, secondaryParameter);
            case EARTH:
                return new EarthBender(name, power, secondaryParameter);
            default:
                return null;
        }
    }
}
