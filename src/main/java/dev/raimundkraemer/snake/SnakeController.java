package dev.raimundkraemer.snake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class SnakeController {

    @FXML
    Canvas canvas;

    public void initialize() {
        final var graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(100, 100, 80, 40);
    }
}
