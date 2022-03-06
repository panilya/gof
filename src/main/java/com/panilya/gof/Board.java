package com.panilya.gof;

public class Board {
    private final int x;
    private final int y;
    private int[][] board;

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

    public void setAlive(int x, int y) {
        board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        board[x][y] = 0;
    }

    private int countNeighbours(int x, int y) {
        int count = 0;

        if (x != 0) {
            if (alive(x-1, y)) count++;
        }
        if (y != 0) {
            if (alive(x, y-1)) count++;
        }
        if (x != 0 && y != 0) {
            if (alive(x-1,y-1)) count++;
        }
        if (y != this.y-1) {
            if (alive(x, y+1)) count++;
        }
        if (x != this.x - 1) {
            if (alive(x+1, y)) count++;
        }
        if (x != this.x - 1 && y != this.y - 1) {
            if (alive(x+1, y+1)) count++;
        }
        if (x != this.x - 1 && y != 0) {
            if (alive(x+1, y-1)) count++;
        }
        if (x != 0 && y != this.y-1) {
            if (alive(x-1,y+1)) count++;
        }
        return count;
    }

    public void step() {
        int[][] newBoard = new int[this.x][this.y];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int neighbours = countNeighbours(i, j);
                if (board[i][j] == 1) {
                    if (neighbours == 0 || neighbours == 1) {
                        newBoard[i][j] = 0;
                    }
                    if (neighbours == 2 || neighbours == 3) {
                        newBoard[i][j] = 1;
                    }
                    if (neighbours > 3) {
                        newBoard[i][j] = 0;
                    }
                } else {
                    if (neighbours == 3) {
                        newBoard[i][j] = 1;
                    }
                }
            }
        }
        this.board = newBoard;
    }

    public boolean alive(int x, int y) {
        return board[x][y] == 1;
    }

    public void renderBoard() {
        System.out.println("_".repeat(x));
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(x));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}