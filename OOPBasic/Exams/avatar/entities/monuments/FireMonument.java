package avatar.entities.monuments;

import static avatar.utilities.Constants.FIRE;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class FireMonument extends Monument {
    private long fireAffinity;

    public FireMonument(String name, long fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public long getAffinity() {
        return this.fireAffinity;
    }


    @Override
    public String toString() {
        return String.format(super.toString(), FIRE, super.getName(), FIRE, this.fireAffinity);
    }
}
