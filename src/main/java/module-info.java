module dev.raimundkraemer.snakejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.raimundkraemer.snakejavafx to javafx.fxml;
    exports dev.raimundkraemer.snakejavafx;
}