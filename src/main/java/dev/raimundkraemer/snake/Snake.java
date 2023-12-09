package dev.raimundkraemer.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final ArrayList<Position> positions;
    private final Bounds bounds;
    private final Runnable onCollision;

    public Snake(Position initialPosition) {
        this(List.of(initialPosition), Bounds.max(), () -> {});
    }

    public Snake(List<Position> initialPositions, Bounds bounds, Runnable onCollision) {
        this.positions = new ArrayList<>(initialPositions);
        this.bounds = bounds;
        this.onCollision = onCollision;
    }

    public List<Position> positions() {
        return positions;
    }

    public void tick() {
        final var oldHeadPosition = positions.getFirst();
        final var newHeadPosition = new Position(
                oldHeadPosition.x(),
                oldHeadPosition.y() + 1);
        positions.set(0, newHeadPosition);
        onCollision.run();
    }
}
