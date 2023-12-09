package dev.raimundkraemer.snake;

public record Bounds(int left, int bottom, int right, int top) {
    public static Bounds max() {
        return new Bounds(
                Integer.MIN_VALUE,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE);
    }
}
