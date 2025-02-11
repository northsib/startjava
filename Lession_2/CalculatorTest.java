import java.util.Scanner; 

public class CalculatorTest { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (calculator.getIsActive()) {
            System.out.print("Введите первое число: ");
            int a = scanner.nextInt();
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            final char ch = scanner.next().charAt(0);
            System.out.print("Введите второе число: ");
            int b = scanner.nextInt();

            calculator.setFirstNumber(a);
            calculator.setSecondNumber(b);
            calculator.setMathOperator(ch);
            calculator.getResult();
            boolean isCorrect = true;
            while (isCorrect) {
            
            System.out.println("Хотите продолжить вычисления? [yes/no]:");

            String userChoose = scanner.nextLine();

            
            
            if (userChoose.equalsIgnoreCase("yes")) {
                calculator.setIsActive(true);
                isCorrect = false;

            } else if (userChoose.equalsIgnoreCase("no")) {
                calculator.setIsActive(false);
                isCorrect = false;
            } else {
                isCorrect = true;
            }
        }
        } 
    }
}