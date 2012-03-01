// Copyright (c) 2008-2010  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit4.class)
public class FallingBlocksTest {

    private final Board board = new Board(3, 3);


    public class A_new_board {

        @Test
        public void is_empty() {
            assertThat(board.toString()).isEqualTo("" +
                    "...\n" +
                    "...\n" +
                    "...\n");
        }

        @Test
        public void has_no_falling_blocks() {
            assertThat(board.hasFalling()).isFalse();
        }
    }

    public class When_a_block_is_dropped {

        @Before
        public void dropBlock() {
            board.drop(new Block('X'));
        }

        @Test
        public void the_block_is_falling() {
            assertThat(board.hasFalling()).isTrue();
        }

        @Test
        public void it_starts_from_the_top_middle() {
            assertThat(board.toString()).isEqualTo("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n");
        }

        @Test
        public void it_moves_down_one_row_per_tick() {
            board.tick();
            assertThat(board.toString()).isEqualTo("" +
                    "...\n" +
                    ".X.\n" +
                    "...\n");
        }

        @Test
        public void at_most_one_block_may_be_falling_at_a_time() {
            try {
                board.drop(new Block('Y'));
                fail("exception should have been thrown");
            } catch (IllegalStateException e) {
                assertThat(e.getMessage()).contains("already falling");
            }
            assertThat(board.toString()).isEqualTo("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n");
        }
    }

    public class When_a_block_reaches_the_bottom {

        @Before
        public void fallToLastRow() {
            board.drop(new Block('X'));
            board.tick();
            board.tick();
        }

        @Test
        public void it_is_still_falling_on_the_last_row() {
            assertThat(board.toString()).isEqualTo("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n");
            assertThat(board.hasFalling()).overridingErrorMessage("the player should still be able to move the block").isTrue();
        }

        @Test
        public void it_stops_when_it_hits_the_bottom() {
            board.tick();
            assertThat(board.toString()).isEqualTo("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n");
            assertThat(board.hasFalling()).overridingErrorMessage("the block should stop moving").isFalse();
        }
    }

    public class When_a_block_lands_on_another_block {

        @Before
        public void landOnAnother() {
            board.drop(new Block('X'));
            board.tick();
            board.tick();
            board.tick();
            assertThat(board.toString()).isEqualTo("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n");
            assertThat(board.hasFalling()).isFalse();

            board.drop(new Block('Y'));
            board.tick();
        }

        @Test
        public void it_is_still_falling_right_above_the_other_block() {
            assertThat(board.toString()).isEqualTo("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n");
            assertThat(board.hasFalling()).overridingErrorMessage("the player should still be able to avoid landing on the other block").isTrue();
        }

        @Test
        public void it_stops_when_it_hits_the_other_block() {
            board.tick();
            assertThat(board.toString()).isEqualTo("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n");
            assertThat(board.hasFalling()).overridingErrorMessage("the block should stop moving when it lands on the other block").isFalse();
        }
    }
}