package demo.test;

public class Car extends Vehicle {

    private String model;

    private Long travelledDistance;

    private Double price;

    private boolean isStart;

    public Car() {
    }

    public Car(String model, Double price) {
        this(model, 0L, price);
    }

    public Car(String model, Long travelledDistance, Double price) {
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.price = price;
    }

    private String makeSound(String... sound) {
        return sound.length == 0 ? "Brum Brum Brum" : sound[0];
    }

    protected void startEngine() {
        this.isStart = true;
    }

    String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private static void testStaticMethod(String test) {
        System.out.println(test);
    }
}
