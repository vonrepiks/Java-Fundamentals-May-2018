package blobs.interfaces;

import blobs.models.Blob;

public interface Attack {

    void execute(Blob attacker, Blob target);
}
