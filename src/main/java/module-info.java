module com.panilya.gof {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.panilya.gof to javafx.fxml;
    exports com.panilya.gof.GraphicalGameOfLife;
}