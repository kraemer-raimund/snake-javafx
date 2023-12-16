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

    @Test
    void multiSegmentSnake_followsTheHeadsPath() {
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

        snake.setDirection(Direction.LEFT);
        snake.tick();
        snake.setDirection(Direction.UP);
        snake.tick();
        snake.setDirection(Direction.LEFT);
        snake.tick();
        snake.setDirection(Direction.UP);
        snake.tick();
        snake.setDirection(Direction.LEFT);
        snake.tick();
        snake.setDirection(Direction.UP);
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
}
