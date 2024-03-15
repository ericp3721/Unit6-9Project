import java.util.ArrayList;


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


    }
}
