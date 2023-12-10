package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCollection;

public class SnakeGrowthTest {

    @Test
    void snakeGrowsOnNextTick() {
        final var snake = new Snake(new Position(5, 5));

        snake.growOnNextTick();
        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(
                        new Position(5, 6),
                        new Position(5, 5)));
    }

    @Test
    void snakeDoesNotGrowOnSameTick() {
        final var snake = new Snake(new Position(5, 5));

        snake.growOnNextTick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(
                        new Position(5, 5)));
    }
}
