package CalculatorOperator;

public interface Operator {
    double apply(double a, double b);

    int getPriority();
}