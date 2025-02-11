public class Calculator { 
    public static void main(String[] args) {
        System.out.println("Используйте только натуральные числа: 1, 2, 3...");
        int firstNumber = 18;
        int secondNumber = 0;
        int result = 0;
        char mathOperator = '^';

        if (firstNumber <= 0 && secondNumber <= 0) {
            System.out.println("Введено неверное значение чисел А и В");
        } else if (firstNumber <= 0) {
            System.out.println("Введено неверное значение числа А");
        } else if (secondNumber <= 0) {
            System.out.println("Введено неверное значение числа В");
        } else {
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
                    if (secondNumber <= 0) {
                        System.out.println("На ноль делить нельзя!");
                    } else {
                        result = firstNumber / secondNumber;
                    }
                    break;
                case '^':
                    result = firstNumber;
                    for (int i = 1; i < secondNumber; i++) {
                        result *= firstNumber;
                    }
                    break;
                case '%':
                    result = firstNumber % secondNumber;
                    break;
                default:
                    System.out.println("Введен неверный математический оператор!");
                    return;
            }
            System.out.println(firstNumber + " " + mathOperator + " " + secondNumber + " = " + result);
        }
    }
}