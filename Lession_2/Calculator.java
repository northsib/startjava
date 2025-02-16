public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private char mathOperator;
    private int result;
    private float floatResult;

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
                }
                result = firstNumber / secondNumber;
                floatResult = (firstNumber < secondNumber || (firstNumber % secondNumber) > 0) ? 
                        (float) firstNumber / secondNumber : 0;
                break;
            case '^':
                int absoluteSecondNumber = Math.abs(secondNumber);
                result = 1;
                for (int i = 1; i <= absoluteSecondNumber; i++) {
                    result = result * firstNumber;
                }
                floatResult = secondNumber < 0 ? 1 / (float) result : 0;
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