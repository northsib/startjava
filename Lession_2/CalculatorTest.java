import java.util.Scanner; 

public class CalculatorTest { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();

        System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
        char ch = scanner.next().charAt(0);

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();


        Calculator calculator = new Calculator();

        calculator.setFirstNumber(a);

        calculator.setSecondNumber(b);

        calculator.setMathOperator(ch);
        calculator.getResult();

        System.out.println("Хотите продолжить вычисления? [да/нет]:");
        scanner.nextLine();
        String userChoose = scanner.nextLine();






    }
}