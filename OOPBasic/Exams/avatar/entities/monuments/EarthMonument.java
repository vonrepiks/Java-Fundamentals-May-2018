package avatar.entities.monuments;

import static avatar.utilities.Constants.EARTH;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class EarthMonument extends Monument {
    private long earthAffinity;

    public EarthMonument(String name, long earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public long getAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format(super.toString(), EARTH, super.getName(), EARTH, this.earthAffinity);
    }
}
