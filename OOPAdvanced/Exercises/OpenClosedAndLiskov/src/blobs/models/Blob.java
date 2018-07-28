package blobs.models;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.notifiers.BlobNotifier;
import blobs.observers.AbstractObserver;
import blobs.observers.Subject;

public class Blob extends AbstractObserver {

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;

    private boolean hasReportEvent;

    private int initialHealth;

    public Blob(String name, int health, int damage, Behavior behavior, Attack attack, Subject subject, boolean hasReportEvent) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
        subject.attach(this);

        this.initialHealth = health;

        this.hasReportEvent = hasReportEvent;
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            if (this.hasReportEvent) {
                BlobNotifier.showMessage(String.format("Blob %s was killed", this.name));
            }
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2 &&
                !this.behavior.isTriggered()) {
            if (this.hasReportEvent) {
                BlobNotifier.showMessage(String.format("Blob %s toggled %sBehavior",
                        this.name,
                        this.behavior.getClass().getSimpleName()));
            }
            this.behavior.trigger(this);
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public String getName() {
        return this.name;
    }

    public void attack(Blob target) {
        if (this.getHealth() == 0 || target.getHealth() == 0) {
            return;
        }
        this.attack.execute(this, target);
    }

    public void update() {
        if (this.behavior.isTriggered()) {
            this.behavior.applyRecurrentEffect(this);
        }
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage",
                this.getName(),
                this.getHealth(),
                this.getDamage());
    }
}
