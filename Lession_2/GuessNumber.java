import java.util.Scanner; 

public class GuessNumber {
    private int guessNumber;
    private Player player1;
    private Player player2;
    private boolean gameOver;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.guessNumber = (int) (Math.random() * 100) + 1;
        this.gameOver = false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while (!gameOver) {
            System.out.println(currentPlayer.getPlayerName() + ", загадайте число от 1 до 100");
            int inputNumber = scanner.nextInt();
            while (true) {
                if (currentPlayer.setPlayerNumber(inputNumber)) {
                    break;
                }
            }

            if (inputNumber > guessNumber) {
                System.out.println(inputNumber + " больше, чем загаданное число");
            } else if (inputNumber < guessNumber) {
                System.out.println(inputNumber + " меньше, чем загаданное число");
            } else {
                System.out.println("Поздравляем! Игрок " + currentPlayer.getPlayerName() + 
                        " отгадал загаданное число - " + guessNumber);
                gameOver = true;
            }
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}