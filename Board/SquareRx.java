//package sample;

class SquareRx {
    private final int row;
    private final int col;
    private boolean occupied = false;

    public SquareRx(int r, int c) {
        row = r;
        col = c;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }
}
