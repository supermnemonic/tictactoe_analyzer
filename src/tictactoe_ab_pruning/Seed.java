/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_ab_pruning;

/**
 *
 * @author mnemonic
 */
public enum Seed {

    MAX("+",1), MIN("-",-1), EMPTY(" ", 0), CROSS("X", MAX.value), NOUGHT("O", MIN.value);
    
    private final String sign;
    private final int value;

    private Seed(String sign, int value) {
        this.sign = sign;
        this.value = value;
    }

    public String sign() {
        return sign;
    }

    public int value() {
        return value;
    }
    
}
