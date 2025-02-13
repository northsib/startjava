public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private char mathOperator = '1';
    // private boolean isCorrectMathOperator = false;
    // private boolean isActive = true;
    // private boolean isCorrectAnswer = true;

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
                    floatResult = (float) firstNumber / (float) secondNumber;
                } else {
                    result = firstNumber / secondNumber;
                }
                break; 
            case '^':
                if (secondNumber > 0) {
                    result = 1;
                    for (int i = 1; i <= secondNumber; i++) {
                        result *= firstNumber;
                    }
                } else if (secondNumber < 0) {
                    floatResult = 1;
                    for (int i = -1; i >= secondNumber; i--) {
                        floatResult /= firstNumber;
                    }
                } else if (secondNumber == 0) {
                    result = 1;
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            default:
        }
        if (floatResult != 0) {
            System.out.println("Ответ: " + floatResult);
        } else {
            System.out.println("Ответ: " + result);
        }
    }
}

