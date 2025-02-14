public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private char mathOperator = '1';

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public boolean setMathOperator(char mathOperator) {
        switch (mathOperator) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                this.mathOperator = mathOperator;
                return true;
            default:
                System.out.println("Ошибка: операция '" + mathOperator + "' не поддерживается");
                return false;
        }
    }

    public void calculate() {
        int result = 0;
        float floatResult = 0;
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
                    return;
                } else if (firstNumber < secondNumber || (firstNumber % secondNumber) > 0) {
                    floatResult = (float) firstNumber / secondNumber;
                } else {
                    result = firstNumber / secondNumber;
                }
                break; 
            case '^':
                int absoluteSecondNumber;
                if (secondNumber < 0) {
                    absoluteSecondNumber = -secondNumber;
                } else {
                    absoluteSecondNumber = secondNumber;
                }
                result = 1;
                for (int i = 1; i <= secondNumber; i++) {
                    result *= firstNumber;
                }
                if (secondNumber < 0) {
                    floatResult = 1 / (float) result;
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
        }
        if (floatResult != 0) {
            System.out.println("Ответ: " + floatResult);
        } else {
            System.out.println("Ответ: " + result);
        }
    }
}

