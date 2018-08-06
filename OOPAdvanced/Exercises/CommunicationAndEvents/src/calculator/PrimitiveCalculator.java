package calculator;

import calculator.strategies.Strategy;

public class PrimitiveCalculator {

    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy){
        this.strategy = strategy;
    }

    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int performCalculation(int firstOperand,int secondOperand){
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
