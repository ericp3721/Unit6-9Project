
import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    private char[][] grid; //https://ioflood.com/blog/2d-array-java/#:~:text=To%20create%20a%202D%20array%20in%20Java%2C%20we%20use%20the,type%5Brows%5D%5Bcolumns%5D%3B%20.&text=This%20code%20creates%20a%202D,array%20are%20initialized%20to%20zero.

    private ArrayList<Obstacle> obstacles;
    private ArrayList<Treasure> treasures;
    private int totalTreasures;
    public int getTotalTreasures() {
        return totalTreasures;
    }
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
    private void initializeGrid() {
        // Initialize grid with empty spaces
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }

        // Generate obstacles and place them on the grid
        generateObstacles(15); // Adjust the number of obstacles as needed
        for (Obstacle obstacle : obstacles) {
            grid[obstacle.getRow()][obstacle.getCol()] = 'X'; // Assuming 'X' represents an obstacle
        }

        // Generate treasures and place them on the grid
        generateTreasures(10); // Adjust the number of treasures as needed
        for (Treasure treasure : treasures) {
            grid[treasure.getRow()][treasure.getCol()] = 'T'; // Assuming 'T' represents a treasure
        }
    }



    public void placeCharacter(Character character) {
        grid[character.getRow()][character.getCol()] = '♔';
    }



    private boolean isValidMove(int row, int col) {
        // Check if the position is within the grid boundaries
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        // Check if the position is occupied by an obstacle
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getRow() == row && obstacle.getCol() == col) {
                return false;
            }
        }
        return true;
    }

    public void movePlayer(Character player, char direction) {
        int currentRow = player.getRow();
        int currentCol = player.getCol();
        int newRow = currentRow;
        int newCol = currentCol;

        // Determine the new position based on the direction
        if (direction == 'w') { // Move up
            newRow--;
        } else if (direction == 'a') { // Move left
            newCol--;
        } else if (direction == 's') { // Move down
            newRow++;
        } else if (direction == 'd') { // Move right
            newCol++;
        }

        // Check if the new position is valid
        if (isValidMove(newRow, newCol)) {
            // Update the player's position
            player.move(newRow, newCol);

            // Check if the new position contains a treasure
            for (Treasure treasure : treasures) {
                if (treasure.getRow() == newRow && treasure.getCol() == newCol) {
                    totalTreasures--;
                    treasures.remove(treasure);
                    System.out.println("Treasure collected! Remaining treasures: " + totalTreasures);
                    break;
                }
            }

            // Update the grid to reflect the player's new position
            grid[currentRow][currentCol] = ' '; // Clear the current position
            grid[newRow][newCol] = '♔'; // Set the player symbol at the new position

        } else {
            System.out.println("Invalid move! Cannot move there.");
        }
    }






    public void generateObstacles(int maxObstacles) {
        Random random = new Random();
        int numObstacles = random.nextInt(maxObstacles) + 1; // Generate a random number of obstacles (at least one)
        for (int i = 0; i < numObstacles; i++) {
            int row = random.nextInt(grid.length);
            int col = random.nextInt(grid[0].length);
            Obstacle obstacle = new Obstacle(row, col);
            obstacles.add(obstacle);
        }
    }

    public void generateTreasures(int maxTreasures) {
        Random random = new Random();
        int numTreasures = random.nextInt(maxTreasures) + 1; // Generate a random number of treasures (at least one)
        totalTreasures = numTreasures;
        for (int i = 0; i < numTreasures; i++) {
            int row = random.nextInt(grid.length);
            int col = random.nextInt(grid[0].length);
            Treasure treasure = new Treasure(row, col);
            treasures.add(treasure);
        }
    }




    public void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char cell = grid[i][j];
                boolean isObstacle = false;
                boolean isTreasure = false;

                // Check if the cell contains an obstacle
                for (Obstacle obstacle : obstacles) {
                    if (obstacle.getRow() == i && obstacle.getCol() == j) {
                        isObstacle = true;
                        break;
                    }
                }

                // Check if the cell contains a treasure
                for (Treasure treasure : treasures) {
                    if (treasure.getRow() == i && treasure.getCol() == j) {
                        isTreasure = true;
                        break;
                    }
                }

                // Update the cell character based on its contents
                if (isObstacle) {
                    System.out.print("👻|"); // Display obstacle
                } else if (isTreasure) {
                    System.out.print("💎|"); // Display treasure
                } else {
                    System.out.print(cell + "|"); // Display empty space or player
                }
            }
            System.out.println();
        }
    }

}
