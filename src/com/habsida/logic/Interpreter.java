class Interpreter {
    private final String expression;
    private int index;

    public Interpreter(String expression) {
        this.expression = expression;
    }

    public int interpret() {
        int value = 0;
        int current = 0;
        char operator = '+';

        while (index < expression.length()) {
            char c = expression.charAt(index);

            if (c == ' ') {
                index++;
                continue;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (current != 0) {
                    value = applyOperator(value, current, operator);
                    current = 0;
                }
                operator = c;
                index++;
                continue;
            }

            if (Character.isDigit(c)) {
                current *= 10;
                current += Integer.parseInt(String.valueOf(c));
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }

            index++;
        }

        if (current != 0) {
            value = applyOperator(value, current, operator);
        }

        return value;
    }

    private int applyOperator(int value, int current, char operator) {
        switch (operator) {
            case '+':
                return value + current;
            case '-':
                return value - current;
            case '*':
                return value * current;
            case '/':
                return value / current;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}