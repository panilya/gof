package com.panilya.gof.GraphicalGameOfLife;

import com.panilya.gof.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        GraphicalGameOfLife gameOfLife = new GraphicalGameOfLife();
        Scene scene = new Scene(gameOfLife, 640,400);
        stage.setScene(scene);
        stage.setTitle("Game of Life");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
