import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    private char[][] grid; //https://ioflood.com/blog/2d-array-java/#:~:text=To%20create%20a%202D%20array%20in%20Java%2C%20we%20use%20the,type%5Brows%5D%5Bcolumns%5D%3B%20.&text=This%20code%20creates%20a%202D,array%20are%20initialized%20to%20zero.

    private ArrayList<Obstacle> obstacles;
    private ArrayList<Treasure> treasures;

    public GameBoard(int rows, int cols) {
        grid = new char[rows][cols];
        obstacles = new ArrayList<>();
        treasures = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void generateObstacles(int numObstacles) {
        Random random = new Random();
        for (int i = 0; i < numObstacles; i++) {
            int row = random.nextInt(grid.length);
            int col = random.nextInt(grid[0].length);
            Obstacle obstacle = new Obstacle(row, col);
            obstacles.add(obstacle);
        }
    }

    public void generateTreasures(int numTreasures) {
        Random random = new Random();
        for (int i = 0; i < numTreasures; i++) {
            int row = random.nextInt(grid.length);
            int col = random.nextInt(grid[0].length);
            Treasure treasure = new Treasure(row, col);
            treasures.add(treasure);
        }
    }

    public void placeCharacter(Character character) {
        grid[character.getRow()][character.getCol()] = 'P';
    }




    public void movePlayer(Character player, char direction) {
        int newRow = player.getRow();
        int newCol = player.getCol();

        if (direction == 'w') { // Move up
            newRow--;
            grid[player.getRow()][player.getCol()] = ' ';
            player.move(newRow, newCol);
            grid[newRow][newCol] = 'P';
        } else if (direction == 'a') { // Move left
            newCol--;
            grid[player.getRow()][player.getCol()] = ' ';
            player.move(newRow, newCol); // Update player's position
            grid[newRow][newCol] = 'P'; // Update new position with player
        } else if (direction == 's') { // Move down
            newRow++;
            grid[player.getRow()][player.getCol()] = ' '; // Clear previous position
            player.move(newRow, newCol); // Update player's position
            grid[newRow][newCol] = 'P'; // Update new position with player
        } else if (direction == 'd') { // Move right
            newCol++;
            grid[player.getRow()][player.getCol()] = ' '; // Clear previous position
            player.move(newRow, newCol); // Update player's position
            grid[newRow][newCol] = 'P'; // Update new position with player
        }
    }





    public void display() {
        for (int i =0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "|");
            }
            System.out.println();
        }
    }

}
