
package walking.game.player;

import walking.game.util.Direction;

public class Player {
    private int score;
    private Direction direction = Direction.UP;

    public Player() {
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public void turn() {
        // Implementation of turn method
    }

    public int getScore() {
        return score;
    }

    public Direction getDirection() {
        return direction;
    }
}
