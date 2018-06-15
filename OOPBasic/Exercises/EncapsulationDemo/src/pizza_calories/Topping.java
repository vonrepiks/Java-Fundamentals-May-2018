package pizza_calories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topping {
    private static final List<String> TOPPING_TYPES = new ArrayList<>() {{
        add("Meat");
        add("Veggies");
        add("Cheese");
        add("Sauce");
    }};
    private static final Map<String, Double> TOPPING_MODIFIERS = new HashMap<>() {{
        put("Meat", 1.2);
        put("Veggies", 0.8);
        put("Cheese", 1.1);
        put("Sauce", 0.9);
    }};

    private static final String INVALID_TOPPING_TYPE_EXCEPTION_MESSAGE = "Cannot place %s on top of your pizza.";
    private static final String INVALID_TOPPING_WEIGHT_EXCEPTION_MESSAGE = "%s weight should be in the range [1..50].";

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!TOPPING_TYPES.contains(toppingType)) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_TYPE_EXCEPTION_MESSAGE, toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_WEIGHT_EXCEPTION_MESSAGE, this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return PizzaConstants.BASE_CALORIES *
                this.weight *
                TOPPING_MODIFIERS.get(this.toppingType);
    }
}
