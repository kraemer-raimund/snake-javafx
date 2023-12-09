package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCollection;
import static org.mockito.Mockito.*;

class SnakeTest {

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
    void snakePlacedNextToWall_collidesWithWallOnTick() {
        final var initialPositions = List.of(new Position(2, 5));
        final var bounds = new Bounds(-5, -5, 5, 5);
        final var onCollision = mock(Runnable.class);
        final var snake = new Snake(initialPositions, bounds, onCollision);

        snake.tick();

        verify(onCollision, times(1)).run();
    }
}