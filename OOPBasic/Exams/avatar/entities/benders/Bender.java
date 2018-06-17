package avatar.entities.benders;

import static avatar.utilities.Constants.STRING_FORMAT_PARENT_BENDER;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public abstract class Bender {
    private String name;
    private long power;

    protected Bender(String name, long power) {
        this.name = name;
        this.power = power;
    }

    public abstract double getTotalPower();

    @Override
    public String toString() {
        return STRING_FORMAT_PARENT_BENDER;
    }

    protected String getName() {
        return this.name;
    }

    protected long getPower() {
        return this.power;
    }
}
