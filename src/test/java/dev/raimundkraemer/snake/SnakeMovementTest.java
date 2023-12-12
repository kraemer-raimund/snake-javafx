package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCollection;

public class SnakeMovementTest {

    @Test
    void initializedSnake_providesCorrectPosition() {
        final var snake = new Snake(new Position(0, 0));

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(new Position(0, 0)));
    }

    @Test
    void initializedSnake_movesUpwards() {
        final var snake = new Snake(new Position(0, 0));

        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(new Position(0, 1)));
    }

    @Test
    void whenSettingDirectionToLeft_snakeMovesLeft() {
        final var snake = new Snake(new Position(0, 0));
        
        snake.setDirection(Direction.LEFT);
        snake.tick();

        assertThatCollection(snake.positions())
                .isEqualTo(List.of(new Position(-1, 0)));
    }
}
