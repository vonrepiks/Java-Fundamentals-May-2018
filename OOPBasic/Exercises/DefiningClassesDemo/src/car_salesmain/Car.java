package car_salesmain;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder car = new StringBuilder();

        car.append(String.format("%s:", this.model))
                .append(System.lineSeparator())
                .append(this.engine.toString())
                .append(System.lineSeparator())
                .append(String.format("Weight: %s", this.weight == 0 ? "n/a" : this.weight))
                .append(System.lineSeparator());

        if (this.color == null) {
            car.append("Color: n/a");
        } else {
            car.append(String.format("Color: %s", this.color));
        }

        return car.toString();
    }
}
