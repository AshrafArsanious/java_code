
package walking.game.util;

public class Direction {

  // Define possible directions (enum is a good choice)
  public enum CardinalDirection {
    UP,
    DOWN,
    RIGHT,
    LEFT
  }

  // You can also add other methods as needed
  // For example, a method to get the opposite direction
  // public static CardinalDirection getOppositeDirection(CardinalDirection direction) {
  //   switch (direction) {
  //     case UP:
  //       return CardinalDirection.DOWN;
  //     case DOWN:
  //       return CardinalDirection.UP;
  //     case RIGHT:
  //       return CardinalDirection.LEFT;
  //     case LEFT:
  //       return CardinalDirection.RIGHT;
  //     default:
  //       throw new IllegalArgumentException("Invalid Direction");
  //   }
  // }
}
