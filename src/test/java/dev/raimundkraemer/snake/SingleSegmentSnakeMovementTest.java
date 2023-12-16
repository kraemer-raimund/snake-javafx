package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCollection;

public class SingleSegmentSnakeMovementTest {

    @Test
    void providesCorrectInitialPosition() {
        final var snake = new Snake(new Position(0, 0));

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(new Position(0, 0)));
    }

    @Test
    void movesUpwardsInitially() {
        final var snake = new Snake(new Position(0, 0));

        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(new Position(0, 1)));
    }

    @Test
    void movesLeftIfDirectionSetToLeft() {
        final var snake = new Snake(new Position(0, 0));

        snake.requestDirection(Direction.LEFT);
        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(new Position(-1, 0)));
    }
}
