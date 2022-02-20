package com.panilya.gof;

public class Board {
    private final int x;
    private final int y;
    private final int[][] board;

    public Board(int x, int y) {
        this.board = new int[x][y];
        this.x = x;
        this.y = y;
    }

    /*
     * initBoard is initializing board,
     * 1 stands for ALIVE, 0 stands for DEAD
     */
    public void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Math.random() < 0.3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public boolean alive(int x, int y) {
        if (board[x][y] == 1) {
            return true;
        }
        return false;
    }

    public void renderBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}