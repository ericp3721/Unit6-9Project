import java.util.Scanner;
public class Game {
    private GameBoard gameBoard;
    private Character player;

    public Game() {
        gameBoard = new GameBoard(10, 10); // Creating a 10x10 game board
        gameBoard.generateObstacles(15); // Generating 15 obstacles randomly
        gameBoard.generateTreasures(5); // Generating 5 treasures randomly
        player = new Character(0, 0); // Placing the player at the starting position
        gameBoard.placeCharacter(player);
    }

    public void start() {
        gameBoard.display();
        Scanner scanner = new Scanner(System.in);
        char direction;
        while (true) {
            System.out.print("Enter direction (w/a/s/d): ");
            direction = scanner.next().charAt(0);
            gameBoard.movePlayer(player, direction);
            gameBoard.display();
            if (gameBoard.getTotalTreasures() == 0) {
                System.out.println("Congratulations! You have collected all treasures. You win!");
                break;
            }
        }
    }
}