package com.panilya.gof;

public class GameOfLife {
    public static void main(String[] args) {
        Board board = new Board(6,4);
        board.setAlive(2,2);
        board.setAlive(3,2);
        board.setAlive(4,2);


        // board.initBoard();

        for (int i = 0; i < 5; i++) {
            board.renderBoard();
            board.step();
        }
//
//        board.renderBoard();
//        board.step();
//        board.renderBoard();
//        board.step();
//        board.renderBoard();
    }
}