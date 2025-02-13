import java.util.Scanner; 

public class CalculatorTest { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean isCalculatorActive = true;

        while (isCalculatorActive) {
            System.out.print("Введите первое число: ");
            calculator.setFirstNumber(scanner.nextInt());
            
            boolean isCorrectMathOperator = false;
            while (!isCorrectMathOperator) {
                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                char mathOperator = scanner.next().charAt(0);
                if (calculator.setMathOperator(mathOperator)) {
                    isCorrectMathOperator = true;
                } else {
                    isCorrectMathOperator = false;
                }
            }

            System.out.print("Введите второе число: ");
            calculator.setSecondNumber(scanner.nextInt());

            calculator.calculate();

            scanner.nextLine();

            boolean isCorrectAnswer = false;

            while (!isCorrectAnswer) {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                String userChoose = scanner.nextLine();
                if (userChoose.equalsIgnoreCase("yes")) {
                    isCalculatorActive = true;
                    isCorrectAnswer = true;
                } else if (userChoose.equalsIgnoreCase("no")) {
                    isCalculatorActive = false;
                    isCorrectAnswer = true;
                }
            }
        }
        scanner.close();
    }
}