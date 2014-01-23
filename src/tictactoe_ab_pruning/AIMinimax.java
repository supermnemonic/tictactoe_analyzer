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
/** AI using Minimax algorithm */
public class AIMinimax extends AI {

    private int level;
 
    public AIMinimax(Board board, int level) {
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
                result = minimax(level, selfseed);
                break;
            case AB_PRUNING:
                result = minimax(level, selfseed, Integer.MIN_VALUE, Integer.MAX_VALUE);
                break;
            default:
                // default algorithm is using minimax.
                result = minimax(level, selfseed);
        }

        return new int[]{result[1], result[2]};   // row, col
    }

    // normal minimax algorithm.
    private int[] minimax(int depth, Seed player) {
        List<int[]> nextMoves = generateValidMoves();

        int bestScore = (player.value() == Seed.MAX.value()) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0) {
            bestScore = evaluateScoroe();
        } else {
            for (int[] move : nextMoves) {
                cells[move[0]][move[1]].content = player;

                if (player == selfseed) {
                    currentScore = minimax(depth - 1, enemyseed)[0];
                } else {
                    currentScore = minimax(depth - 1, selfseed)[0];
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

    private List<int[]> generateValidMoves() {
        List<int[]> nextMoves = new ArrayList<>(); // allocate List

        if (Game.hasWon(cells, selfseed) != null || Game.hasWon(cells, enemyseed) != null) {
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

    private int evaluateScoroe() {
        int score = 0;

        // menghitung skor baris 1 - 3.
        score += evaluateLine(0, 0, 0, 1, 0, 2); 
        score += evaluateLine(1, 0, 1, 1, 1, 2); 
        score += evaluateLine(2, 0, 2, 1, 2, 2); 
        
        // menghitung skor kolom 1 - 3.
        score += evaluateLine(0, 0, 1, 0, 2, 0); 
        score += evaluateLine(0, 1, 1, 1, 2, 1); 
        score += evaluateLine(0, 2, 1, 2, 2, 2); 
        
        // menghitung skor diagonal kanan dan kiri.
        score += evaluateLine(0, 0, 1, 1, 2, 2); 
        score += evaluateLine(0, 2, 1, 1, 2, 0); 
        return score;
    }

    private int evaluateLine(int r1, int c1, int r2, int c2, int r3, int c3) {
        int score = 0;

        // First cell
        if (cells[r1][c1].content.value() == Seed.MAX.value()) {
            score = 1;
        } else if (cells[r1][c1].content.value() == Seed.MIN.value()) {
            score = -1;
        }

        // Second cell
        if (cells[r2][c2].content.value() == Seed.MAX.value()) {
            if (score == 1) {
                score = 10;
            } else if (score == -1) { 
                return 0;
            } else { 
                score = 1;
            }
        } else if (cells[r2][c2].content.value() == Seed.MIN.value()) {
            if (score == -1) { 
                score = -10;
            } else if (score == 1) { 
                return 0;
            } else { 
                score = -1;
            }
        }

        // Third cell
        if (cells[r3][c3].content.value() == Seed.MAX.value()) {
            if (score > 0) { 
                score *= 10;
            } else if (score < 0) { 
                return 0;
            } else { 
                score = 1;
            }
        } else if (cells[r3][c3].content.value() == Seed.MIN.value()) {
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
        List<int[]> nextMoves = generateValidMoves();
        
        int score;
        int bestRow = -1;
        int bestCol = -1;

        if (nextMoves.isEmpty() || depth == 0) {
            score = evaluateScoroe();
            return new int[]{score, bestRow, bestCol};
        } else {
            for (int[] move : nextMoves) { 
                cells[move[0]][move[1]].content = player;
                if (player == selfseed) { 
                    score = minimax(depth - 1, enemyseed, alpha, beta)[0];
                } else { 
                    score = minimax(depth - 1, selfseed, alpha, beta)[0];
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