package blobs.factories;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.models.Blob;
import blobs.observers.Subject;

public final class BlobFactory {

    private BlobFactory() {
    }

    public static Blob create(String name, int health, int damage, Behavior behavior, Attack attack, Subject subject, boolean flag) {
        return new Blob(
                name,
                health,
                damage,
                behavior,
                attack,
                subject,
                flag);
    }
}
