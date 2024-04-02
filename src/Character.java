class Character {
    private int row;
    private int col;

    public Character(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int newRow, int newCol) {
        this.row = row;
        this.col = col;
    }
}
