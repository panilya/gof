package com.panilya.gof.GraphicalGameOfLife;

import com.panilya.gof.Board;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GraphicalGameOfLife extends VBox {

    private Canvas canvas = new Canvas(640,400);
    private Board board;
    private Button button;

    public GraphicalGameOfLife() {
        this.button = new Button("Step");
        this.button.setOnAction(actionEvent -> {
            board.step();
            draw();
        });
        this.board = new Board(10,10);
        board.setAlive(3,3);
        board.setAlive(2,1);
        board.setAlive(2,2);
        board.setAlive(5,5);
        board.setAlive(5,6);
        board.setAlive(5,7);

        this.getChildren().addAll(this.button, this.canvas);
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGREY);

        gc.fillRect(0, 0, 640,400);
        gc.setFill(Color.BLACK);

        for (int x = 0; x < board.getX(); x++) {
            for (int y = 0; y < board.getY(); y++) {
                if (board.alive(x,y)) {
                    gc.fillRect(x*22, y*22, 22, 22);
                }
            }
        }
    }
}
