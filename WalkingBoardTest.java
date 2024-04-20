
package walking.game.tests;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;
import walking.game.util;
import walking.game.util.*;
import walking.game.util.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalkingBoardTest {
    @Test //we need to review the array dimentions before implementing this test
    public void testMoveAndSet() {
        int[][] tiles = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        WalkingBoard board = new WalkingBoard(tiles);
        assertEquals(5, board.moveAndSet(Direction.DOWN, 10)); // Move down to (1, 1) and set value to 10
    }

    @Test
    public void testGetPosition() {
        int[][] tiles = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        WalkingBoard board = new WalkingBoard(tiles);
        assertEquals(0, board.getPosition()[0]); // Check initial x position
        assertEquals(0, board.getPosition()[1]); // Check initial y position
    }

    @Test
    public void testIsValidPosition() {
        int[][] tiles = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        WalkingBoard board = new WalkingBoard(tiles);
        assertEquals(true, board.isValidPosition(0, 0)); // Check if (0, 0) is a valid position
        assertEquals(false, board.isValidPosition(-1, 0)); // Check if (-1, 0) is an invalid position
    }

    @Test
    public void testGetTile() {
        int[][] tiles = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        WalkingBoard board = new WalkingBoard(tiles);
        assertEquals(5, board.getTile(1, 1)); // Check the value at position (1, 1)
    }

    @Test
    public void testGetXStep() { //testGetXStep was testGetX
        WalkingBoard board = new WalkingBoard(3);
        assertEquals(1, board.getXStep(Direction.RIGHT)); // Check right step. getXStep was getX
        assertEquals(-1, board.getXStep(Direction.LEFT)); // Check left step
        assertEquals(0, board.getXStep(Direction.UP)); // Check up step
    }

    @Test
    public void testGetYStep() { //testGetYStep was testGetY
        WalkingBoard board = new WalkingBoard(3);
        assertEquals(1, board.getYStep(Direction.DOWN)); // Check down step -getYStep was getY
        assertEquals(-1, board.getYStep(Direction.UP)); // Check up step
        assertEquals(0, board.getYStep(Direction.RIGHT)); // Check right step
    }
}
