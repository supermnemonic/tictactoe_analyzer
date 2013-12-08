/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_ab_pruning;

/**
 *
 * @author mnemonic
 */
public class GameStatistic {

    public StatisticData[][] records;
    public String[][] runtimeInfo;
    public String[][] boardEndState;    
        
    public GameStatistic(int player1_level_max, int player2_level_max) {
        this.records = new StatisticData[player1_level_max][player2_level_max];
        this.runtimeInfo = new String[player1_level_max][player2_level_max];
        this.boardEndState = new String[player1_level_max][player2_level_max];        
        
        // init records
        for (int i = 0; i < player1_level_max; i++) {
            for (int j = 0; j < player2_level_max; j++) {
                records[i][j] = new StatisticData();
            }
        }
    }
    
}
