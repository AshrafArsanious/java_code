package walking.game.tests;

import java.util.Arrays;

public class WalkingBoard {
    public static final int BASE_TILE_SCORE = 3;
    private static final int SCORE_EACH_STEP = 2;

    private final int size;
    private final int[][] board;
    private int x;
    private int y;

    public WalkingBoard(int size) {
        this.size = size;
        this.board = new int[size][size];
        initializeBoard(BASE_TILE_SCORE);
        this.x = 0;
        this.y = 0;
    }

    public WalkingBoard(int[][] initialBoard) {
        this.size = initialBoard.length;
        this.board = new int[size][];
        for (int i = 0; i < size; i++) {
            this.board[i] = Arrays.copyOf(initialBoard[i], initialBoard[i].length);
        }
        initializeBoard(BASE_TILE_SCORE);
    }

    private void initializeBoard(int initialValue) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Math.max(initialValue, BASE_TILE_SCORE);
            }
        }
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public int getTile(int x, int y) {
        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Invalid position");
        }
        return board[x][y];
    }

    public int[][] getTiles() {
        int[][] copy = new int[size][];
        for (int i = 0; i < size; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < board[x].length;
    }

    private int getXStep(Direction direction) {
        switch (direction) {
            case LEFT:
                return -1;
            case RIGHT:
                return 1;
            default:
                return 0;
        }
    }

    private int getYStep(Direction direction) {
        switch (direction) {
            case UP:
                return -1;
            case DOWN:
                return 1;
            default:
                return 0;
        }
    }

    public int moveAndSet(Direction direction, int value) {
        int oldX = x;
        int oldY = y;
        int newX = x + getXStep(direction);
        int newY = y + getYStep(direction);
        if (!isValidPosition(newX, newY)) {
            return 0;
        }
        int oldValue = board[newX][newY];
        board[oldX][oldY] = value;
        x = newX;
        y = newY;
        return oldValue;
    }

    public int setAndMove(Direction direction, int value) {
        int oldValue = board[x][y];
        board[x][y] = value;
        return moveAndSet(direction, oldValue);
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static void main(String[] args) {
        WalkingBoard board = new WalkingBoard(3);
        System.out.println("Position: " + Arrays.toString(board.getPosition()));
        System.out.println("Tile value at (0, 0): " + board.getTile(0, 0));
        System.out.println("Tiles:");
        int[][] tiles = board.getTiles();
        for (int[] row : tiles) {
            System.out.println(Arrays.toString(row));
        }
    }
}
