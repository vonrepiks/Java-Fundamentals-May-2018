package avatar.entities.monuments;

import static avatar.utilities.Constants.STRING_FORMAT_MONUMENT;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public abstract class Monument {
    private String name;

    protected Monument(String name) {
        this.name = name;
    }

    public abstract long getAffinity();

    @Override
    public String toString() {
        return STRING_FORMAT_MONUMENT;
    }

    public String getName() {
        return this.name;
    }
}
