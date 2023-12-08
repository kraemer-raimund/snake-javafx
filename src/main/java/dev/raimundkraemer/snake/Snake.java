package dev.raimundkraemer.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private final ArrayList<Position> positions;

    public Snake(Position initialPosition) {
        this.positions = new ArrayList<>(List.of(initialPosition));
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
    }
}
