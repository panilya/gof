package com.panilya.gof;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    /*
     * Any live cell with fewer than two live neighbours
     * dies, as if by underpopulation.
     */
    @Test
    public void testLiveCellWithFewer2LiveNeighboursDies() {
        Board board = new Board(4,4);
        board.setAlive(0,1);
        board.setAlive(1,1);
        board.step();
        assertFalse(board.alive(1,1));
    }

    /*
     * Any live cell with three live neighbours
     * lives on to the next generation.
     */
    @Test
    public void testLiveCellWith3LiveNeighboursLives() {
        Board board = new Board(4,4);
        board.setAlive(1,2);
        board.setAlive(2,1);
        board.setAlive(2,2);
        board.setAlive(3,2);
        board.step();
        assertTrue(board.alive(2,2));
    }

    /*
     * Any live cell with two live neighbours
     * lives on to the next generation.
     */
    @Test
    public void testLiveCellWith2LiveNeighboursLives() {
        Board board = new Board(4,4);
        board.setAlive(1,1);
        board.setAlive(2,1);
        board.setAlive(3,1);
        board.step();
        assertTrue(board.alive(2,1));
    }

    /*
     *  Any live cell with more than three live neighbours
     *  dies, as if by overpopulation.
     */
    @Test
    public void testLiveCellWithMore3LiveNeighboursDies() {
        Board board = new Board(4,4);
        board.setAlive(1,3);
        board.setAlive(2,3);
        board.setAlive(3,2);
        board.setAlive(3,3);
        board.setAlive(2,2);
        board.step();
        assertFalse(board.alive(2,2));
    }

    /*
     * Any dead cell with exactly three live neighbours
     * becomes a live cell, as if by reproduction.
     */
    @Test
    public void testDeadCellWith3Neighbours() {
        Board board = new Board(3,3);
        board.setAlive(0,2);
        board.setAlive(1,1);
        board.setAlive(1,2);
        board.step();
        assertTrue(board.alive(0,1));
        assertTrue(board.alive(0,2));
        assertTrue(board.alive(1,1));
        assertTrue(board.alive(1,2));
    }
}