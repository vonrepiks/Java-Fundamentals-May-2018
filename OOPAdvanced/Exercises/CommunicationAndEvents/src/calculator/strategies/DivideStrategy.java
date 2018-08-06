package calculator.strategies;

import calculator.annotations.CalculationMode;

@CalculationMode("/")
public class DivideStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand / secondOperand;
    }
}
