/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_ab_pruning;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mnemonic
 */
/** AIPlayer using Minimax algorithm */
public class AIPlayerMinimax extends AIPlayer {

    private int level;
 
    public AIPlayerMinimax(Board board, int level) {
        super(board);
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    int[] move(String algo_type) {
        int[] result;
        switch (algo_type) {
            case MINIMAX:
                result = minimax(level, mySeed);
                break;
            case AB_PRUNING:
                result = minimax(level, mySeed, Integer.MIN_VALUE, Integer.MAX_VALUE);
                break;
            default:
                // default algorithm is using minimax.
                result = minimax(level, mySeed);
        }

        return new int[]{result[1], result[2]};   // row, col
    }

    // normal minimax algorithm.
    private int[] minimax(int depth, Seed player) {
        List<int[]> nextMoves = generateMoves();

        int bestScore = (player.value() == Seed.MAX.value()) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0) {
            bestScore = evaluate();
        } else {
            for (int[] move : nextMoves) {
                cells[move[0]][move[1]].content = player;

                if (player == mySeed) {
                    currentScore = minimax(depth - 1, oppSeed)[0];
                } else {
                    currentScore = minimax(depth - 1, mySeed)[0];
                }

                if (player.value() == Seed.MAX.value() && currentScore > bestScore) {
                    bestScore = currentScore;
                    bestRow = move[0];
                    bestCol = move[1];
                } else if (player.value() == Seed.MIN.value() && currentScore < bestScore) {
                    bestScore = currentScore;
                    bestRow = move[0];
                    bestCol = move[1];
                }

                cells[move[0]][move[1]].content = Seed.EMPTY;
            }
        }
        return new int[]{bestScore, bestRow, bestCol};
    }

    private List<int[]> generateMoves() {
        List<int[]> nextMoves = new ArrayList<int[]>(); // allocate List

        if (Game.hasWon(cells, mySeed) != null || Game.hasWon(cells, oppSeed) != null) {
            return nextMoves;   // return empty list
        }

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].content == Seed.EMPTY) {
                    nextMoves.add(new int[]{row, col});
                }
            }
        }
        return nextMoves;
    }

    private int evaluate() {
        int score = 0;

        score += evaluateLine(0, 0, 0, 1, 0, 2); 
        score += evaluateLine(1, 0, 1, 1, 1, 2); 
        score += evaluateLine(2, 0, 2, 1, 2, 2); 
        score += evaluateLine(0, 0, 1, 0, 2, 0); 
        score += evaluateLine(0, 1, 1, 1, 2, 1); 
        score += evaluateLine(0, 2, 1, 2, 2, 2); 
        score += evaluateLine(0, 0, 1, 1, 2, 2); 
        score += evaluateLine(0, 2, 1, 1, 2, 0); 
        return score;
    }

    private int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
        int score = 0;

        // First cell
        if (cells[row1][col1].content.value() == Seed.MAX.value()) {
            score = 1;
        } else if (cells[row1][col1].content.value() == Seed.MIN.value()) {
            score = -1;
        }

        // Second cell
        if (cells[row2][col2].content.value() == Seed.MAX.value()) {
            if (score == 1) {
                score = 10;
            } else if (score == -1) { 
                return 0;
            } else { 
                score = 1;
            }
        } else if (cells[row2][col2].content.value() == Seed.MIN.value()) {
            if (score == -1) { 
                score = -10;
            } else if (score == 1) { 
                return 0;
            } else { 
                score = -1;
            }
        }

        // Third cell
        if (cells[row3][col3].content.value() == Seed.MAX.value()) {
            if (score > 0) { 
                score *= 10;
            } else if (score < 0) { 
                return 0;
            } else { 
                score = 1;
            }
        } else if (cells[row3][col3].content.value() == Seed.MIN.value()) {
            if (score < 0) { 
                score *= 10;
            } else if (score > 1) { 
                return 0;
            } else { 
                score = -1;
            }
        }

        return score;
    }

    // modified minimax algorithm, with alpha-beta pruning (cut-off).
    private int[] minimax(int depth, Seed player, int alpha, int beta) {
        List<int[]> nextMoves = generateMoves();
        
        int score;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0) {
            score = evaluate();
            return new int[]{score, bestRow, bestCol};
        } else {
            for (int[] move : nextMoves) { 
                cells[move[0]][move[1]].content = player;
                if (player == mySeed) { 
                    score = minimax(depth - 1, oppSeed, alpha, beta)[0];
                } else { 
                    score = minimax(depth - 1, mySeed, alpha, beta)[0];
                }

                if (player.value() == Seed.MAX.value() && score > alpha) {
                    alpha = score;
                    bestRow = move[0];
                    bestCol = move[1];
                } else if (player.value() == Seed.MIN.value() && score < beta) {
                    beta = score;
                    bestRow = move[0];
                    bestCol = move[1];
                }
 
                cells[move[0]][move[1]].content = Seed.EMPTY;
                
                // cut-off
                if (alpha >= beta) {
                    break;
                }
            }
            return new int[]{(player.value() == Seed.MAX.value()) ? alpha : beta, bestRow, bestCol};
        }
    }
}