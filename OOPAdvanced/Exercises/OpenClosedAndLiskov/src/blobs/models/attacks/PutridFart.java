package blobs.models.attacks;

import blobs.interfaces.Attack;
import blobs.models.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob source, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= source.getDamage();
        target.setHealth(currentHealth);
    }
}
