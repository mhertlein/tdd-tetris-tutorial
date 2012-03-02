// Copyright (c) 2008-2010  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.fest.assertions.Assertions.assertThat;


/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit4.class)
public class RotatingPiecesOfBlocksTest {

    private Piece piece;

    public class A_piece_of_3x3_blocks {

        @Before
        public void createPiece() {
            piece = new Piece("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n");
        }

        @Test
        public void consists_of_many_blocks() {
            assertThat(piece.toString()).isEqualTo("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n");
        }

        @Test
        public void can_be_rotated_right() {
            piece = piece.rotateRight();
            assertThat(piece.toString()).isEqualTo("" +
                    "...\n" +
                    ".XX\n" +
                    "...\n");
        }

        @Test
        public void can_be_rotated_left() {
            piece = piece.rotateLeft();
            assertThat(piece.toString()).isEqualTo("" +
                    "...\n" +
                    "XX.\n" +
                    "...\n");
        }
    }

    public class A_piece_of_5x5_blocks {

        @Before
        public void createPiece() {
            piece = new Piece("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n");
        }

        @Test
        public void consists_of_many_blocks() {
            assertThat(piece.toString()).isEqualTo("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n");
        }

        @Test
        public void can_be_rotated_right() {
            piece = piece.rotateRight();
            assertThat(piece.toString()).isEqualTo("" +
                    ".....\n" +
                    ".....\n" +
                    "..XXX\n" +
                    "...XX\n" +
                    "....X\n");
        }

        @Test
        public void can_be_rotated_left() {
            piece = piece.rotateLeft();
            assertThat(piece.toString()).isEqualTo("" +
                    "X....\n" +
                    "XX...\n" +
                    "XXX..\n" +
                    ".....\n" +
                    ".....\n");
        }
    }
}
