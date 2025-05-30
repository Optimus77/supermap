package CalculatorOperator;

// 具体运算符实现
public enum BasicOperator implements Operator {
    ADD('+', 1) {
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT('-', 1) {
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY('*', 2) {
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE('/', 2) {
        public double apply(double a, double b) {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        }
    };

    private final char symbol;
    private final int priority;

    BasicOperator(char symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static BasicOperator fromSymbol(char symbol) {
        for (BasicOperator op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }
}