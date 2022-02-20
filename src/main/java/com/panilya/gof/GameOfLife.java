package com.panilya.gof;

public class GameOfLife {
    public static void main(String[] args) {
        Board board = new Board(5,5);
        board.initBoard();
        board.renderBoard();
    }
}