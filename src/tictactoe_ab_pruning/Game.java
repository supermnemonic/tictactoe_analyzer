/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_ab_pruning;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

/**
 *
 * @author mnemonic
 */
public class Game {

    public static int ROWS = 3;
    public static int COLS = 3;
    // game board
    public Board board;
    // pola menang
    private static int[] winningPatterns = {
        0b111000000, 0b000111000, 0b000000111,
        0b100100100, 0b010010010, 0b001001001,
        0b100010001, 0b001010100
    };
    // prepare player
    public AIMinimax firstPlayer;
    public AIMinimax currentCom;
    public AIMinimax com1;
    public AIMinimax com2;
    // game trial com vs com
    private final int GAME_ITERATION = 5;
    private final int COM1_LEVEL_MAX = 9;
    private final int COM2_LEVEL_MAX = 9;
    // game statistic
    public GameStatistic statistic = new GameStatistic(COM1_LEVEL_MAX, COM2_LEVEL_MAX);
    public StatisticTable statisticTable;

    public Game() {
        board = new Board();
        statisticTable = new StatisticTable(this);

        com1 = new AIMinimax(board, 1);
        com2 = new AIMinimax(board, 1);

        com1.setSeed(Seed.X);
        com2.setSeed(Seed.O);

        MouseListener tableMouseListener = new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getSource().equals(statisticTable.runTimeTable)) {
                    statisticTable.boardState.setText("no data");

                    int row = statisticTable.runTimeTable.rowAtPoint(e.getPoint());
                    int col = statisticTable.runTimeTable.columnAtPoint(e.getPoint()) - 1;

                    if (row >= 0 && col >= 0) {
                        statisticTable.boardState.setText(statistic.runtimeInfo[row][col]);
                    }
                } else if (e.getSource().equals(statisticTable.winTable)) {
                    statisticTable.boardState.setText("no data");

                    int row = statisticTable.winTable.rowAtPoint(e.getPoint());
                    int col = statisticTable.winTable.columnAtPoint(e.getPoint()) - 1;
                    //System.out.println(row + "," + col);

                    if (row >= 0 && col >= 0) {
                        statisticTable.boardState.setText(statistic.boardEndState[row][col]);
                    }
                }
            }
        };
        statisticTable.winTable.addMouseListener(tableMouseListener);
        statisticTable.runTimeTable.addMouseListener(tableMouseListener);

        // seting up progress bar.
        statisticTable.prograssBar.setMinimum(0);
        statisticTable.prograssBar.setMaximum(COM1_LEVEL_MAX * COM2_LEVEL_MAX);
        statisticTable.prograssBar.setStringPainted(true);

        // seting up for the first time.
        resetGame();
    }
    
    // prepare new thread to run the game.
    Thread gameThread;
    public Seed _FIRSTPLAYER;
    public String _X_ALGO;
    public String _O_ALGO;

    public void startGame(Seed _param_firstplayer, String _param_x_algo, String _param_o_algo) {
        this._FIRSTPLAYER = _param_firstplayer;
        this._X_ALGO = _param_x_algo;
        this._O_ALGO = _param_o_algo;

        resetGame();
        
        gameThread = new Thread(new Runnable() {

            @Override
            public void run() {
                statisticTable.prograssBar.setForeground(Color.RED);
                statisticTable.prograssBar.setString("Processing...");

                com1.setAlgo_type(_X_ALGO);
                com2.setAlgo_type(_O_ALGO);

                firstPlayer = (com1.selfseed == _FIRSTPLAYER) ? com1 : com2;
                currentCom = firstPlayer;

                String s1 = "(" + com1.selfseed.sign() + ") : " + (com1.selfseed.value() == 1 ? "maximizing" : "minimizing") + ".\n";
                String s2 = "(" + com2.selfseed.sign() + ") : " + (com2.selfseed.value() == 1 ? "maximizing" : "minimizing") + ".\n";
                String s3 = "First player : (" + firstPlayer.selfseed.sign() + ").\n";
                String s4 = "(" + com1.selfseed.sign() + ") Algo : " + com1.algo_type + ".\n";
                String s5 = "(" + com2.selfseed.sign() + ") Algo : " + com2.algo_type + ".\n";

                statisticTable.playerInfo.setText(s1 + s2 + s3 + s4 + s5);

                long startWholetime, endWholetime;
                double wholeTime;
                int _totalGameDraw = 0;
                startWholetime = System.nanoTime();
                for (int i_com1 = 0; i_com1 < COM1_LEVEL_MAX; i_com1++) {
                    for (int j_com2 = 0; j_com2 < COM2_LEVEL_MAX; j_com2++) {
                        com1.setLevel(i_com1 + 1);
                        com2.setLevel(j_com2 + 1);

                        int gameDraw = 0;
                        double movesRuntime = 0;

                        // start game n-times, where n is GAME_ITERATION
                        for (int k = 0; k < GAME_ITERATION; k++) {
                            AIMinimax winner = null;
                            long startTime, endTime, runTime;

                            // reset board.
                            board.resetBoard();

                            // reset the first player to begin play.
                            currentCom = firstPlayer;

                            // game-n begin. the game forever loop, but there is a BREAK inside.
                            while (true) {
                                int[] move;

                                // start count runtime
                                startTime = System.nanoTime();

                                // counting runtime while find the best move
                                {
                                    move = currentCom.move(currentCom.algo_type);
                                }

                                // end count runtime
                                endTime = System.nanoTime();

                                runTime = (endTime - startTime);
                                movesRuntime += runTime;

                                // check if game is over.
                                if (isGameOver(move)) {
                                    if (hasWon(board.cells, com1.selfseed) != null) {
                                        winner = com1;                                        
                                    } else if (hasWon(board.cells, com2.selfseed) != null) {
                                        winner = com2;
                                    }
                                    break;
                                }

                                //System.out.println("(" + currentCom.selfseed.sign() + ")" + " NOW TURN");
                                putSeed(currentCom, move);

                                //Board.printCells(board.cells);
                                //System.out.println("(" + currentCom.selfseed.sign() + ")" + " HAS MOVE TO " + move[0] + "," + move[1]);
                                //System.out.println("");

                                nextPlayer();
                            } // game-n end, gameover.

                            if (winner == null) {
                                gameDraw++;
                                _totalGameDraw++;
                            } else if (winner.selfseed == Seed.X) {                                
                                statistic.records[i_com1][j_com2].X_winCount++;
                                winner.winCount++;
                            } else if (winner.selfseed == Seed.O) {                                
                                statistic.records[i_com1][j_com2].O_winCount++;
                                winner.winCount++;
                            }
                            
                            String w = (winner != null) ? ("(" + winner.selfseed.sign() + ") WIN") : "GAME DRAW";
                            statistic.boardEndState[i_com1][j_com2] = Board.cellsData(board.cells) + "\t" + w;
                            
                        } // end game-n.

                        // find average runtime, then save it to abstract table (STATISTIC.RECORDS[][]).
                        double averageRunTime = movesRuntime / GAME_ITERATION;

                        // convert nanosecond to milisecond.
                        averageRunTime /= 1e+6;

                        // show runtime by two decimal places in RUNTIME_TABLE.
                        DecimalFormat df = new DecimalFormat("#.##");
                        String _2decimalPlace = df.format(averageRunTime);
                        statisticTable.runTimeTable.setValueAt(_2decimalPlace, i_com1, j_com2 + 1);

                        // save [runtime detail] and [average runtime of total moves].
                        statistic.runtimeInfo[i_com1][j_com2] = "     (X) ai-level:" + (i_com1 + 1) + "\n           VS" + "\n     (O) ai-level:" + (j_com2 + 1)
                                + "\n\nbermain "+GAME_ITERATION+" kali dalam waktu rata2 :\n" + _2decimalPlace + " mili-detik.";
                        statistic.records[i_com1][j_com2].runningTime = averageRunTime;

                        // show each player win-count statistic in WIN_TABLE.
                        //String s = statistic.records[i_com1][j_com2].X_winCount + "\\" + gameDraw + "\\" + statistic.records[i_com1][j_com2].O_winCount;
                        String s = "x:" + statistic.records[i_com1][j_com2].X_winCount + " vs " + statistic.records[i_com1][j_com2].O_winCount + ":o";
                        statisticTable.winTable.setValueAt(s, i_com1, j_com2 + 1);

                        // update progress bar value.
                        int v = statisticTable.prograssBar.getValue() + 1;
                        statisticTable.prograssBar.setValue(v);
                    }
                }

                endWholetime = System.nanoTime();
                wholeTime = (endWholetime - startWholetime);

                // convert nanosecond to milisecond
                wholeTime /= 1e+6;

                DecimalFormat df = new DecimalFormat("#.##");
                String _2decimalPlace = df.format(wholeTime);
                statisticTable.totalRunTime.setText("Total: " + _2decimalPlace + " mili-detik.");

                String s = statisticTable.playerInfo.getText() + "\n";
                s += (COM1_LEVEL_MAX * COM2_LEVEL_MAX * GAME_ITERATION) + " kali percobaan\ntanding:\n";
                s += "(" + com1.selfseed.sign() + "): " + com1.winCount + " menang.\n";
                s += "(" + com2.selfseed.sign() + "): " + com2.winCount + " menang.\n";
                s += "Seri: " + _totalGameDraw + "\n";
                statisticTable.playerInfo.setText(s);

                statisticTable.prograssBar.setForeground(Color.BLUE);
                statisticTable.prograssBar.setString("Done.");
            }
        });
        gameThread.start();
    }

    public void resetGame() {
        if (gameThread != null) {
            gameThread.stop();
        }

        com1.winCount = 0;
        com2.winCount = 0;
        
        statisticTable.prograssBar.setValue(0);
        statisticTable.prograssBar.setString("Waiting...");
        statisticTable.boardState.setText("klik sel pada tabel untuk melihat-\ninformasi detail.");
        statisticTable.playerInfo.setText("");
        statisticTable.totalRunTime.setText("");
        for (int i = 0; i < COM1_LEVEL_MAX; i++) {
            for (int j = 0; j < COM2_LEVEL_MAX; j++) {
                statisticTable.runTimeTable.setValueAt("", i, j + 1);
                statisticTable.winTable.setValueAt("", i, j + 1);
                statistic.records[i][j].X_winCount = 0;
                statistic.records[i][j].O_winCount = 0;
                statistic.records[i][j].runningTime = 0;                
                statistic.boardEndState[i][j] = "";
            }
        }
    }

    private void putSeed(AIMinimax player, int[] pos) {
        board.cells[pos[0]][pos[1]].content = player.selfseed;
    }

    private boolean isGameOver(int[] move) {
        return (move[0] == -1 || move[1] == -1);
    }

    private void nextPlayer() {
        currentCom = (currentCom == com1) ? com2 : com1;
    }

    public static Seed hasWon(Cell[][] c, Seed player) {
        int pattern = 0b000000000;  // 9-bit pattern for the 9 cells
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (c[row][col].content == player) {
                    pattern |= (1 << (row * COLS + col));
                }
            }
        }
        for (int winningPattern : winningPatterns) {
            if ((pattern & winningPattern) == winningPattern) {
                return player;
            }
        }
        return null;
    }
}
