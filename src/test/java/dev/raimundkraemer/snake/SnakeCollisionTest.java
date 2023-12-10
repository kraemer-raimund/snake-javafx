package dev.raimundkraemer.snake;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class SnakeCollisionTest {

    @Test
    void snakePlacedNextToWall_collidesWithWallOnTick() {
        final var initialPositions = List.of(new Position(2, 5));
        final var bounds = new Bounds(-5, -5, 5, 5);
        final var onCollision = mock(Runnable.class);
        final var snake = new Snake(initialPositions, bounds, onCollision);

        snake.tick();

        verify(onCollision, times(1)).run();
    }

    @Test
    void snakePlacedDistantFromWall_doesNotCollideWithWallOnTick() {
        final var initialPositions = List.of(new Position(13, 37));
        final var bounds = new Bounds(-1000, -1000, 1000, 1000);
        final var onCollision = mock(Runnable.class);
        final var snake = new Snake(initialPositions, bounds, onCollision);

        snake.tick();

        verify(onCollision, never()).run();
    }
}
