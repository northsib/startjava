public class Calculator{
    private int firstNumber = 0;
    private int secondNumber = 0;
    private char mathOperator = '+';
    private float result = 0;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public char getMathOperator() {
        return mathOperator;
    }

    public void setMathOperator(char mathOperator) {
        this.mathOperator = mathOperator;

        switch (mathOperator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Ошибка: делить на ноль нельзя");
                } else if (secondNumber > firstNumber) {
                    float floatFirstNumber = (float) firstNumber;
                    float floatSecondNumber = (float) secondNumber;
                    result = floatFirstNumber / floatSecondNumber;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            case '^':
                if (secondNumber >= 0) {
                    result = 1;
                    for (int i = 1; i <= secondNumber; i++) {
                        result *= firstNumber;
                    }
                } else {
                    float denominator = 1;
                    for (int i = -1; i >= secondNumber; i--){
                        denominator *= firstNumber;
                    }
                    result = 1 / denominator;
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            default:
                System.out.println("Ошибка: операция '" + mathOperator + "' не поддерживается");
                return;
        }
    }

    public void getResult() {
        if (mathOperator == '+' || mathOperator == '-' || mathOperator == '*' || 
            mathOperator == '/' || mathOperator == '^' || mathOperator == '%') {
            System.out.println(result);
        } else {

        }
    }
}