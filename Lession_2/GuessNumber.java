import java.util.Scanner; 

public class GuessNumber {
    private int guessNumber;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.guessNumber = (int) (Math.random() * 100) + 1;
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        while (true) {
            int inputNumber = inputNumber();
            if (checkGuess(inputNumber)) {
                System.out.println("Поздравляем! Игрок " + currentPlayer.getName() + 
                        " отгадал загаданное число - " + guessNumber);
                break;
            }
            switchPlayer();
        }
    }

    private int inputNumber() {
        System.out.println(currentPlayer.getName() + ", загадайте число от 1 до 100");
        int inputNumber = scanner.nextInt();
        
        while (!currentPlayer.setNumber(inputNumber)) {
            inputNumber = scanner.nextInt();
        }
        return inputNumber;
    }

    private boolean checkGuess(int inputNumber) {
        if (inputNumber == guessNumber) {
            return true;
        }
        if (inputNumber > guessNumber) {
            System.out.println(inputNumber + " больше, чем загаданное число");
        } else {
            System.out.println(inputNumber + " меньше, чем загаданное число");
        }
        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}