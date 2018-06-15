package pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            String[] pizzaTokens = reader.readLine().split("\\s+");
            String pizzaName = pizzaTokens[1];
            int countOfToppings = Integer.parseInt(pizzaTokens[2]);

            Pizza pizza = new Pizza(pizzaName, countOfToppings);

            String[] doughTokens = reader.readLine().split("\\s+");
            String flourType = doughTokens[1];
            String backingTechnique = doughTokens[2];
            double doughWeight = Double.parseDouble(doughTokens[3]);

            Dough dough = new Dough(flourType, backingTechnique, doughWeight);

            pizza.setDough(dough);

            while (countOfToppings-- > 0) {
                String[] toppingTokens = reader.readLine().split("\\s+");

                String toppingType = toppingTokens[1];
                double toppingWeight = Double.parseDouble(toppingTokens[2]);

                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);
            }

            System.out.println(pizza.toString());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
