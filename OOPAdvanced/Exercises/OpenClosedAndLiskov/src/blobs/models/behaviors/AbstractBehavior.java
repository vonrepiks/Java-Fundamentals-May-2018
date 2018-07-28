package blobs.models.behaviors;

import blobs.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    protected AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }


    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    protected boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    protected void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }
}
