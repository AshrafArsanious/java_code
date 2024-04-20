
package walking.game;

import walking.game.util;
import walking.game.util.*;
import walking.game.util.Direction;
import java.util.Arrays;


public class WalkingBoard {
    private int[][] tiles;
    private int x;
    private int y;
    public static final int BASE_TILE_SCORE = 3;

    public WalkingBoard(int size) {
        this.tiles = new int[size][size];
    }

    public WalkingBoard(int[][] tiles) {
        this.tiles = tiles;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
    }

    public int getTile(int x, int y) {
        if (isValidPosition(x, y)) {
            return tiles[x][y];
        } else {
            throw new IllegalArgumentException("Invalid position");
        }
    }

    public int getXStep(Direction direction) {
        return direction == Direction.RIGHT ? 1 : direction == Direction.LEFT ? -1 : 0;
    }

    public int getYStep(Direction direction) {
        return direction == Direction.DOWN ? 1 : direction == Direction.UP ? -1 : 0;
    }

    public int moveAndSet(Direction direction, int value) {
        int newX = x + getXStep(direction);
        int newY = y + getYStep(direction);

        if (isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
            tiles[x][y] = value;
            return tiles[x][y];
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }
}
