public class Calculator { 
    public static void main(String[] args) {
        System.out.println("Используйте только натуральные числа (1, 2, 3.... n + 1, n)");
        int a = 18;
        int b = 3;
        int result = 0;
        char mathOperator = '^';

        if (a <= 0 && b <= 0) {
            System.out.println("Введено неверное значение чисел А и В");
        } else if (a <= 0) {
            System.out.println("Введено неверное значение числа А");
        } else if (b <= 0) {
            System.out.println("Введено неверное значение числа В");
        } else {
                switch (mathOperator) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        if (b == 0) {
                            System.out.println("На ноль делить нельзя!");
                        } else {
                        result = a / b;
                        }
                        break;
                    case '^':
                        int i = 1;
                        result = a;
                        while (i < b) {
                            result *= a; 
                            i++;
                        }
                        break;
                    case '%':
                        result = a % b;
                        break;
                    default:
                        System.out.println("Введен неверный математический оператор!");
                }
            System.out.println(a + " " + mathOperator + " " + b + " = " + result);
        }
    }
}
