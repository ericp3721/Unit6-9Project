public class Treasure extends GameObject {
    private boolean collected;

    public Treasure(int row, int col) {
        super(row, col);
        this.collected = false;
    }

    // Method to mark the treasure as collected


    @Override
    public String toString() {
        if (collected) {
            return "Collected treasure at (" + getRow() + ", " + getCol() + "). You found a valuable item!";
        } else {
            return "Treasure at (" + getRow() + ", " + getCol() + ")";
        }
    }
}
