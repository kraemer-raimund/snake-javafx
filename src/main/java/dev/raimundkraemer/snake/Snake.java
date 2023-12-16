package dev.raimundkraemer.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final ArrayList<Position> positions;
    private final Bounds bounds;
    private final Runnable onCollision;

    private Direction direction = Direction.UP;
    private boolean growOnNextTick;

    public Snake(Position... initialPosition) {
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

    public void requestDirection(Direction direction) {
        if (isDirectionChangeAllowed(direction)) {
            this.direction = direction;
        }
    }

    private boolean isDirectionChangeAllowed(Direction direction) {
        if (positions().size() == 1) {
            // A single-segment snake can change to any direction.
            return true;
        }

        // A multi-segment snake can not move "backwards" where the head segment would need
        // to move to the position occupied by the second segment.
        // E.g., the snake can not move down if the second segment is below the snake's head.
        final var head = positions.get(0);
        final var secondSegment = positions.get(1);
        return switch (direction) {
            case DOWN -> head.y() <= secondSegment.y();
            default -> true;
        };
    }

    public void growOnNextTick() {
        growOnNextTick = true;
    }

    private boolean stepWouldCollide() {
        final var oldHead = positions.getFirst();
        final var newHead = oldHead.nextPosition(direction);
        return newHead.y() > bounds.top();
    }

    private void stepAndGrow() {
        final var oldHead = positions.getFirst();
        final var newHead = oldHead.nextPosition(direction);
        positions.addFirst(newHead);
    }

    private void step() {
        final var oldHead = positions.getFirst();
        final var newHead = oldHead.nextPosition(direction);
        positions.addFirst(newHead);
        positions.removeLast();
    }
}
