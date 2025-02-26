public class Player {
    private String playerName;
    private int playerNumber;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public boolean setPlayerNumber(int playerNumber) {
        if (playerNumber < 1 || playerNumber > 100) {
            System.out.println("Ошибка: загаданное число должно быть от 1 до 100");
            return false;
        } else {
            this.playerNumber = playerNumber;
            return true;
        }
    }

    public void getPlayerInfo() {
        System.out.println("Имя игрока - " + playerName + ", введенное число - " + playerNumber);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}