import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        double first = Double.parseDouble(input[0]);
        double second = Double.parseDouble(input[1]);
        double third = Double.parseDouble(input[2]);


        double firstFormula = Math.pow(((Math.pow(first, 2) + Math.pow(second, 2)) / (Math.pow(first, 2) - Math.pow(second, 2))), (first + second + third) / Math.sqrt(third));
        double secondFormula = Math.pow((Math.pow(first, 2) + Math.pow(second, 2) - Math.pow(third, 3)), (first - second));

        double diff = Math.abs(((first + second + third) / 3) - ((firstFormula + secondFormula) / 2));

        System.out.println(String.format("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", firstFormula, secondFormula, diff));
    }
}
