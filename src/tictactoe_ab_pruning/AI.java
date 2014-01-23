/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_ab_pruning;

/**
 *
 * @author mnemonic
 */
public abstract class AI {
    
    public static final String MINIMAX = "minimax";
    public static final String AB_PRUNING = "alpha-beta";
    
    protected int ROWS = Game.ROWS;
    protected int COLS = Game.COLS;
    public Cell[][] cells;
    protected Seed selfseed;
    protected Seed enemyseed;
    protected String algo_type = MINIMAX;
    protected int winCount = 0;
    
    public AI(Board board) {
        this.cells = board.cells;
    }
    
    public void setSeed(Seed seed) {
        this.selfseed = seed;
        enemyseed = (selfseed == Seed.X) ? Seed.O : Seed.X;
    }

    public void setAlgo_type(String algo_type) {
        this.algo_type = algo_type;
    }
    
    abstract int[] move(String algo_type);
}
