package tetris;

import java.util.ArrayList;

public class Board {

    private final int rows;
    private final int columns;
    private BlockOnBoard fallingBlock;
    private ArrayList<BlockOnBoard> allBlocks = new ArrayList<BlockOnBoard>();

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                boolean blockDrawn = false;
                for (BlockOnBoard block : allBlocks) {
                    if (block.getRow() == row && block.getCol() == col) {
                        s += block.getBlock().getIcon();
                        blockDrawn = true;
                        break;
                    }
                }
                if (!blockDrawn)
                    s += ".";
            }
            s += "\n";
        }
        return s;
    }

    public boolean hasFalling() {
        return fallingBlock != null;
    }

    public void drop(Block block) {
        if (hasFalling()) {
            throw new IllegalStateException("already falling");
        }

        fallingBlock = new BlockOnBoard(block);
        allBlocks.add(fallingBlock);
    }

    public void tick() {
        if (hasFalling()) {
            int currentRow = fallingBlock.getRow();
            if (hasFallingBlockHitAnotherBlock() || hasFallingBlockHitTheBottom(currentRow)) {
                fallingBlock = null;
            } else {
                fallingBlock.setRow(currentRow + 1);
            }
        }
    }

    private boolean hasFallingBlockHitTheBottom(int currentRow) {
        return currentRow + 1 == rows;
    }

    private boolean hasFallingBlockHitAnotherBlock() {
        for (BlockOnBoard block : allBlocks) {
            if (block == fallingBlock)
                continue;

            if (block.getCol() == fallingBlock.getCol() && block.getRow() == fallingBlock.getRow() + 1)
                return true;
        }

        return false;
    }
}
