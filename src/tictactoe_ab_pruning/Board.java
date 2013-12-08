/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_ab_pruning;

/**
 *
 * @author mnemonic
 */
public class Board {

    public Cell[][] cells;
    
    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        this.cells = new Cell[Game.ROWS][Game.COLS];
        for (int i = 0; i < Game.ROWS; i++) {
            for (int j = 0; j < Game.COLS; j++) {
                this.cells[i][j] = new Cell();
            }
        }
    }
    
    public void resetBoard() {
        for (int i = 0; i < Game.ROWS; i++) {
            for (int j = 0; j < Game.COLS; j++) {
                this.cells[i][j].content = Seed.EMPTY;
            }
        }
    }
        
    public static String cellsData(Cell[][] c) {
        String s = " === === === ";
        for (int i = 0; i < Game.ROWS; i++) {
            s += "\n| "+c[i][0].content.sign()+" | "+c[i][1].content.sign()+" | "+c[i][2].content.sign()+" |";
            s += "\n === === === ";
        }
        return s;
    }
    
    public static void printCells(Cell[][] c) {
        System.out.println(cellsData(c));
    }
    
}
