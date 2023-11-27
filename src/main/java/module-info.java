module dev.raimundkraemer.snakejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.raimundkraemer.snake to javafx.fxml;
    exports dev.raimundkraemer.snake;
}
