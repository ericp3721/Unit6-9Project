public class Treasure extends GameObject {
    public Treasure(int row, int col) {
        super(row, col);
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Treasure at (" + getRow() + ", " + getCol() + ")";
    }
}
