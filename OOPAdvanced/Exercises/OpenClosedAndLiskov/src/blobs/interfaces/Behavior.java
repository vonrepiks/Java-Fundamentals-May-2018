package blobs.interfaces;

import blobs.models.Blob;

public interface Behavior {

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);

    boolean isTriggered();
}
