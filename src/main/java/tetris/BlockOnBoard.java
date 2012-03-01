// Copyright (c) 2008-2012  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author mhertlein
 */
class BlockOnBoard {
    final private Block block;
    private int row;
    private int col;

    public BlockOnBoard(Block block) {
        this.block = block;
        row = 0;
        col = 1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Block getBlock() {
        return block;
    }
}
