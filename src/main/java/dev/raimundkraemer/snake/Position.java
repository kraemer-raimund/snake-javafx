package dev.raimundkraemer.snake;

public record Position(int x, int y) {

    public Position nextPosition(Direction direction) {
        return switch (direction) {
            case LEFT -> new Position(x() - 1, y());
            case DOWN -> new Position(x(), y() - 1);
            case UP -> new Position(x(), y() + 1);
        };
    }
}
