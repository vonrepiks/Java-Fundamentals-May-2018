package avatar.factories;

import avatar.entities.monuments.*;

import static avatar.utilities.Constants.*;

public final class MonumentFactory {

    private MonumentFactory() {}

    public static Monument makeMonument(String type, String name, long affinity) {
        switch (type) {
            case AIR:
                return new AirMonument(name, affinity);
            case WATER:
                return new WaterMonument(name, affinity);
            case FIRE:
                return new FireMonument(name, affinity);
            case EARTH:
                return new EarthMonument(name, affinity);
            default:
                return null;
        }
    }
}
