package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCollection;

public class MultiSegmentSnakeMovementTest {

    @Test
    void followsTheHeadsPath() {
        final var snake = new Snake(
                new Position(0, 0),
                new Position(0, -1),
                new Position(0, -2),
                new Position(0, -3),
                new Position(0, -4),
                new Position(0, -5),
                new Position(0, -6),
                new Position(0, -7),
                new Position(0, -8),
                new Position(0, -9));

        snake.requestDirection(Direction.LEFT);
        snake.tick();
        snake.requestDirection(Direction.UP);
        snake.tick();
        snake.requestDirection(Direction.LEFT);
        snake.tick();
        snake.requestDirection(Direction.UP);
        snake.tick();
        snake.requestDirection(Direction.LEFT);
        snake.tick();
        snake.requestDirection(Direction.UP);
        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(
                        new Position(-3, 3),
                        new Position(-3, 2),
                        new Position(-2, 2),
                        new Position(-2, 1),
                        new Position(-1, 1),
                        new Position(-1, 0),
                        new Position(0, 0),
                        new Position(0, -1),
                        new Position(0, -2),
                        new Position(0, -3)));
    }

    @Test
    void ignores180DegreeDirectionChange() {
        final var snake = new Snake(
                new Position(0, 0),
                new Position(0, -1));

        snake.requestDirection(Direction.UP);
        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(
                        new Position(0, 1),
                        new Position(0, 0)));

        snake.requestDirection(Direction.DOWN);
        snake.tick();

        assertThatCollection(snake.positions())
                .as("The snake is expected to keep moving upwards, because changing the direction to down is not " +
                        "allowed if the snake's head would need to move to the position occupied by the snake's " +
                        "second segment.")
                .isEqualTo(List.of(
                        new Position(0, 2),
                        new Position(0, 1)));
    }
}
