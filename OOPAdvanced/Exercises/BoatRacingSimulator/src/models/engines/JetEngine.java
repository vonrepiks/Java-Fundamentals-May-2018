package models.engines;

public class JetEngine extends BaseBoatEngine {

    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    protected int calculateOutput(int horsepower, int displacement) {
        return (horsepower * MULTIPLIER) + displacement;
    }
}
