package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCollection;

class SnakeTest {

    @Test
    void initializedSnake_providesCorrectPosition() {
        final var snake = new Snake(new Position(0, 0));

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(new Position(0, 0)));
    }
}
