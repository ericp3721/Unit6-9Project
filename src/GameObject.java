public class GameObject {
    private int row;
    private int col;

    public GameObject(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // Method to be overridden
    @Override
    public String toString() {
        return "Object at (" + row + ", " + col + ")";
    }
}
