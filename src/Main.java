import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(10, 10); // Creating a 10x10 game board
        gameBoard.generateObstacles(15); // Generating 15 obstacles randomly
        gameBoard.generateTreasures(5); // Generating 5 treasures randomly
        Character player = new Character(0, 1); // Placing the player at the starting position
        gameBoard.placeCharacter(player); // Placing the player on the game board
        gameBoard.display(); // Displaying the initial state of the game board
        Scanner scan = new Scanner(System.in);
    }
}

