package dev.raimundkraemer.snake;

import java.util.List;

public class Snake {

    private final List<Position> positions;

    public Snake(Position initialPosition) {
        this.positions = List.of(initialPosition);
    }

    public List<Position> positions() {
        return positions;
    }
}
