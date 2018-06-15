package pizza_calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private static final String INVALID_PIZZA_NAME_EXCEPTION_MESSAGE = "Pizza name should be between 1 and 15 symbols.";
    private static final String INVALID_COUNT_OF_TOPPINGS_EXCEPTION_MESSAGE = "Number of toppings should be in range [0..10].";

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int countOfToppings) {
        this.setName(name);
        setToppings(countOfToppings);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException(INVALID_PIZZA_NAME_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    private void setToppings(int countOfToppings) {
        if (countOfToppings < 0 || countOfToppings > 10) {
            throw new IllegalArgumentException(INVALID_COUNT_OF_TOPPINGS_EXCEPTION_MESSAGE);
        }
        this.toppings = new ArrayList<>();
    }

    private double calculatePizzaCalories() {
        double doughCalories = this.dough.calculateCalories();
        double toppingsCalories = this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();

        return doughCalories + toppingsCalories;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.calculatePizzaCalories());
    }
}
