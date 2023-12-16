package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCollection;

public class SnakeGrowthTest {

    @Test
    void segmentIsAddedOnNextTick() {
        final var snake = new Snake(new Position(5, 5));

        snake.growOnNextTick();
        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(
                        new Position(5, 6),
                        new Position(5, 5)));
    }

    @Test
    void segmentIsNotAddedOnCurrentTick() {
        final var snake = new Snake(new Position(5, 5));

        snake.growOnNextTick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(
                        new Position(5, 5)));
    }

    @Test
    void multiSegmentSnake_growsTailWhileMovingTheRestForward() {
        final var snake = new Snake(
                new Position(0, 0),
                new Position(0, -1),
                new Position(0, -2));

        snake.requestDirection(Direction.UP);
        snake.growOnNextTick();
        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(
                        new Position(0, 1),
                        new Position(0, 0),
                        new Position(0, -1),
                        new Position(0, -2)));
    }
}
