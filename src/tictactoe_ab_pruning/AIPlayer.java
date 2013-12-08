/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_ab_pruning;

/**
 *
 * @author mnemonic
 */
public abstract class AIPlayer {
    
    public static final String MINIMAX = "minimax";
    public static final String AB_PRUNING = "alpha-beta";
    
    protected int ROWS = Game.ROWS;
    protected int COLS = Game.COLS;
    public Cell[][] cells;
    protected Seed mySeed;
    protected Seed oppSeed;
    protected String algo_type = MINIMAX;
    protected int winCount = 0;
    
    public AIPlayer(Board board) {
        this.cells = board.cells;
    }
    
    public void setSeed(Seed seed) {
        this.mySeed = seed;
        oppSeed = (mySeed == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
    }

    public void setAlgo_type(String algo_type) {
        this.algo_type = algo_type;
    }
    
    abstract int[] move(String algo_type);
}
