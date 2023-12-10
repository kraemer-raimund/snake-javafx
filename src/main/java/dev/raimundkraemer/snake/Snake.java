package dev.raimundkraemer.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final ArrayList<Position> positions;
    private final Bounds bounds;
    private final Runnable onCollision;

    private boolean growOnNextTick;

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
        if (stepWouldCollide()) {
            onCollision.run();
        } else if (growOnNextTick) {
            stepAndGrow();
        } else {
            step();
        }
    }

    public void growOnNextTick() {
        growOnNextTick = true;
    }

    private boolean stepWouldCollide() {
        final var oldHead = positions.getFirst();
        final var newHead = new Position(oldHead.x(), oldHead.y() + 1);
        return newHead.y() > bounds.top();
    }

    private void stepAndGrow() {
        final var oldHead = positions.getFirst();
        final var newHead = new Position(oldHead.x(), oldHead.y() + 1);
        positions.set(0, newHead);
        positions.add(oldHead);
    }

    private void step() {
        final var oldHead = positions.getFirst();
        final var newHead = new Position(oldHead.x(), oldHead.y() + 1);
        positions.set(0, newHead);
    }
}
