public class Calculator {
    private int firstNumber = 0;
    private int secondNumber = 0;
    private char mathOperator = '+';
    private int result = 0;
    private float floatResult = 0;
    private boolean isCorrectMathOperator = false;
    private boolean isActive = true;
    private boolean isCorrectAnswer = true;

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
        switch (mathOperator) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                this.mathOperator = mathOperator;
                isCorrectMathOperator = true;
                break;
            default:
                System.out.println("Ошибка: операция '" + mathOperator + "' не поддерживается");
        }
    }

    public void result() {
        switch (mathOperator) {
            case '+':
                result = firstNumber + secondNumber;
                System.out.println("Ответ: " + result);
                break;
            case '-':
                result = firstNumber - secondNumber;
                System.out.println("Ответ: " + result);
                break;
            case '*':
                result = firstNumber * secondNumber;
                System.out.println("Ответ: " + result);
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("Ошибка: делить на ноль нельзя");
                } else if (firstNumber < secondNumber || (firstNumber % secondNumber) > 0) {
                    floatResult = (float) firstNumber / (float) secondNumber;
                    System.out.println("Ответ: " + floatResult);
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println("Ответ: " + result);
                }
                break; 
            case '^':
                if (secondNumber == 0) {
                    result = 1;
                    System.out.println("Ответ: " + result);
                } else if (secondNumber < 0) {
                    int denominator = firstNumber;
                    for (int i = -1; i > secondNumber; i--) {
                        denominator *= firstNumber;
                    }
                    floatResult = 1 / (float) denominator;
                    System.out.println("Ответ: " + floatResult);
                } else {
                    result = 1;
                    for (int i = 1; i <= secondNumber; i++) {
                        result *= firstNumber;
                    }
                    System.out.println("Ответ: " + result);
                }
                break;
            case '%':
                result = firstNumber % secondNumber;
                System.out.println("Ответ: " + result);
                break;
            default:
        }
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsCorrectMathOperator() {
        return isCorrectMathOperator;
    }

    public void setIsCorrectMathOperator(boolean isCorrectMathOperator) {
        this.isCorrectMathOperator = isCorrectMathOperator;
    }

    public boolean getIsCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setIsCorrectAnswer(boolean isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
    }
}