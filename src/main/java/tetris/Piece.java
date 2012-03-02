package tetris;

/**
 * @author mhertlein
 */
public class Piece {

    private int dimension;
    private char[][] grid;

    public Piece(String grid) {
        String[] rows = grid.split("\n");
        dimension = rows.length;

        this.grid = new char[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            this.grid[row] = rows[row].toCharArray();
        }
    }

    public Piece rotateRight() {
        char[][] rotatedGrid = new char[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                rotatedGrid[col][dimension - 1 - row] = grid[row][col];
            }
        }

        this.grid = rotatedGrid;

        return this;
    }

    public Piece rotateLeft() {
        char[][] rotatedGrid = new char[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                rotatedGrid[dimension - 1 - col][row] = grid[row][col];
            }
        }

        this.grid = rotatedGrid;

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                sb.append(grid[row][col]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
