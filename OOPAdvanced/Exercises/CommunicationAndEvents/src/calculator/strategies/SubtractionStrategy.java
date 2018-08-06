package calculator.strategies;

import calculator.annotations.CalculationMode;

@CalculationMode("-")
public class SubtractionStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
}
