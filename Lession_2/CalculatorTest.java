import java.util.Scanner; 

public class CalculatorTest { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String userChoose = "yes";

        while (userChoose.equalsIgnoreCase("yes")) {
            System.out.print("Введите первое число: ");
            calculator.setFirstNumber(scanner.nextInt());
            
            while (true) {
                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                char mathOperator = scanner.next().charAt(0);
                if (calculator.setMathOperator(mathOperator)) {
                    break;
                }
            }

            System.out.print("Введите второе число: ");
            calculator.setSecondNumber(scanner.nextInt());

            calculator.calculate();

            scanner.nextLine();

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                userChoose = scanner.nextLine();
            } while (!userChoose.equalsIgnoreCase("yes") && !userChoose.equalsIgnoreCase("no"));
        }
        scanner.close();
    }
}