import java.util.Scanner; 

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoose = "yes";
        while (userChoose.equals("yes")) {
            System.out.println("Введите имя игрока 1:");
            Player player1 = new Player(scanner.nextLine());
            System.out.println("Введите имя игрока 2:");
            Player player2 = new Player(scanner.nextLine());
            GuessNumber game = new GuessNumber(player1, player2);
            game.playGame();
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                userChoose = scanner.nextLine().toLowerCase();
            } while (!userChoose.equals("yes") && !userChoose.equals("no"));
        }
        scanner.close();
    }
}