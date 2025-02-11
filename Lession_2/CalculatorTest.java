import java.util.Scanner; 

public class CalculatorTest { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (calculator.getIsActive()) {
            System.out.print("Введите первое число: ");
            calculator.setFirstNumber(scanner.nextInt());

            while (!calculator.getIsCorrectMathOperator()) {
                System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
                calculator.setMathOperator(scanner.next().charAt(0));
            }

            System.out.print("Введите второе число: ");
            calculator.setSecondNumber(scanner.nextInt());

            calculator.result();

            scanner.nextLine();

            while (calculator.getIsCorrectAnswer()) {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                String userChoose = scanner.nextLine();
                if (userChoose.equalsIgnoreCase("yes")) {
                    calculator.setIsActive(true);
                    calculator.setIsCorrectMathOperator(false);
                    calculator.setIsCorrectAnswer(false);
                } else if (userChoose.equalsIgnoreCase("no")) {
                    calculator.setIsActive(false);
                    calculator.setIsCorrectAnswer(false);
                } 
            }
            calculator.setIsCorrectAnswer(true);
        } 
    }
}