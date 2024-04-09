public class Obstacle extends GameObject {
    public Obstacle(int row, int col) {
        super(row, col);
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Obstacle at (" + getRow() + ", " + getCol() + ")";
    }
}
