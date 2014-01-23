/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StatisticTable.java
 *
 * Created on Dec 6, 2013, 2:50:11 AM
 */
package tictactoe_ab_pruning;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mnemonic
 */
public class StatisticTable extends javax.swing.JFrame {
    
    private Game game;
            
    /** Creates new form StatisticTable */
    public StatisticTable(Game game) {
        initComponents();        
        setVisible(true);
        setTitle("TicTacToe AI Analyzer - (oleh : IF-3/10113701)");
        prograssBar.setBackground(Color.WHITE);
        
        this.game = game;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        runTimeTable = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int col) {
                if (col == 0) {
                    return this.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(this,
                        this.getValueAt(row, col), false, false, row, col);
                } else {
                    return super.prepareRenderer(renderer, row, col);
                }
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        winTable = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int col) {
                if (col == 0) {
                    return this.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(this,
                        this.getValueAt(row, col), false, false, row, col);
                } else {
                    return super.prepareRenderer(renderer, row, col);
                }
            }
        };
        jScrollPane3 = new javax.swing.JScrollPane();
        boardState = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        playerInfo = new javax.swing.JTextArea();
        startButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        minimaxRB_X = new javax.swing.JRadioButton();
        alphabetaRB_X = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        minimaxRB_O = new javax.swing.JRadioButton();
        alphabetaRB_O = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        firstplayer_X = new javax.swing.JRadioButton();
        firstplayer_O = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        prograssBar = new javax.swing.JProgressBar();
        totalRunTime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        runTimeTable.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        runTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "X\\O", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        runTimeTable.setRowHeight(20);
        runTimeTable.setRowSelectionAllowed(false);
        runTimeTable.getTableHeader().setResizingAllowed(false);
        runTimeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(runTimeTable);
        runTimeTable.getColumnModel().getColumn(0).setResizable(false);
        runTimeTable.getColumnModel().getColumn(1).setResizable(false);
        runTimeTable.getColumnModel().getColumn(2).setResizable(false);
        runTimeTable.getColumnModel().getColumn(3).setResizable(false);
        runTimeTable.getColumnModel().getColumn(3).setHeaderValue("3");
        runTimeTable.getColumnModel().getColumn(4).setResizable(false);
        runTimeTable.getColumnModel().getColumn(4).setHeaderValue("4");
        runTimeTable.getColumnModel().getColumn(5).setResizable(false);
        runTimeTable.getColumnModel().getColumn(5).setHeaderValue("5");
        runTimeTable.getColumnModel().getColumn(6).setResizable(false);
        runTimeTable.getColumnModel().getColumn(6).setHeaderValue("6");
        runTimeTable.getColumnModel().getColumn(7).setResizable(false);
        runTimeTable.getColumnModel().getColumn(7).setHeaderValue("7");
        runTimeTable.getColumnModel().getColumn(8).setResizable(false);
        runTimeTable.getColumnModel().getColumn(8).setHeaderValue("8");
        runTimeTable.getColumnModel().getColumn(9).setResizable(false);
        runTimeTable.getColumnModel().getColumn(9).setHeaderValue("9");

        winTable.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        winTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "", "", null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null},
                {"3", "", null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "X\\O", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        winTable.setRowHeight(20);
        winTable.setRowSelectionAllowed(false);
        winTable.getTableHeader().setResizingAllowed(false);
        winTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(winTable);
        winTable.getColumnModel().getColumn(0).setResizable(false);
        winTable.getColumnModel().getColumn(1).setResizable(false);
        winTable.getColumnModel().getColumn(2).setResizable(false);
        winTable.getColumnModel().getColumn(3).setResizable(false);
        winTable.getColumnModel().getColumn(4).setResizable(false);
        winTable.getColumnModel().getColumn(5).setResizable(false);
        winTable.getColumnModel().getColumn(6).setResizable(false);
        winTable.getColumnModel().getColumn(7).setResizable(false);
        winTable.getColumnModel().getColumn(8).setResizable(false);
        winTable.getColumnModel().getColumn(9).setResizable(false);

        boardState.setColumns(15);
        boardState.setEditable(false);
        boardState.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        boardState.setLineWrap(true);
        boardState.setRows(7);
        jScrollPane3.setViewportView(boardState);

        playerInfo.setColumns(25);
        playerInfo.setEditable(false);
        playerInfo.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        playerInfo.setRows(10);
        jScrollPane4.setViewportView(playerInfo);

        startButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        startButton.setText("START GAME");
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        resetButton.setText("RESET GAME");
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetButtonMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(minimaxRB_X);
        minimaxRB_X.setSelected(true);
        minimaxRB_X.setText("minimax");

        buttonGroup1.add(alphabetaRB_X);
        alphabetaRB_X.setText("alpha-beta");

        jLabel1.setText("player X : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimaxRB_X)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alphabetaRB_X)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(minimaxRB_X)
                .addComponent(alphabetaRB_X))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup2.add(minimaxRB_O);
        minimaxRB_O.setSelected(true);
        minimaxRB_O.setText("minimax");

        buttonGroup2.add(alphabetaRB_O);
        alphabetaRB_O.setText("alpha-beta");

        jLabel4.setText("player O : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimaxRB_O)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alphabetaRB_O)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(minimaxRB_O)
                .addComponent(alphabetaRB_O))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup3.add(firstplayer_X);
        firstplayer_X.setSelected(true);
        firstplayer_X.setText("X");

        buttonGroup3.add(firstplayer_O);
        firstplayer_O.setText("O");

        jLabel5.setText("First Player : ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstplayer_X)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstplayer_O)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(firstplayer_X)
                .addComponent(firstplayer_O))
        );

        jLabel2.setText("Tabel Runtime. Nomor baris: AI_Level untuk X. Nomor kolom: AI_Level untuk O");

        jLabel6.setText("Tabel WinnerCount. Menghitung jumlah kemenangan masing2 AI");

        totalRunTime.setEditable(false);
        totalRunTime.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6))
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(resetButton, 0, 0, Short.MAX_VALUE)))
                    .addComponent(jPanel3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalRunTime, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(prograssBar, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalRunTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prograssBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
        Seed firstPlayer = (firstplayer_X.isSelected())?Seed.X : Seed.O;
        String X_algo = (minimaxRB_X.isSelected())?AI.MINIMAX:AI.AB_PRUNING;
        String O_algo = (minimaxRB_O.isSelected())?AI.MINIMAX:AI.AB_PRUNING;
        
        game.startGame(firstPlayer, X_algo, O_algo);
    }//GEN-LAST:event_startButtonMouseClicked

    private void resetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonMouseClicked
        game.resetGame();
    }//GEN-LAST:event_resetButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            //THIS SETS TO OTHER JAVA LOOK AND FEEL
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatisticTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new StatisticTable().setVisible(true);
            }
        });
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alphabetaRB_O;
    private javax.swing.JRadioButton alphabetaRB_X;
    public javax.swing.JTextArea boardState;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JRadioButton firstplayer_O;
    private javax.swing.JRadioButton firstplayer_X;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton minimaxRB4;
    private javax.swing.JRadioButton minimaxRB5;
    private javax.swing.JRadioButton minimaxRB_O;
    private javax.swing.JRadioButton minimaxRB_X;
    public javax.swing.JTextArea playerInfo;
    public javax.swing.JProgressBar prograssBar;
    private javax.swing.JButton resetButton;
    public javax.swing.JTable runTimeTable;
    private javax.swing.JButton startButton;
    public javax.swing.JTextField totalRunTime;
    public javax.swing.JTable winTable;
    // End of variables declaration//GEN-END:variables

    class HeaderRenderer implements TableCellRenderer {

        TableCellRenderer renderer;

        public HeaderRenderer(JTable jTable1) {
            renderer = jTable1.getTableHeader().getDefaultRenderer();
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, col);
        }
    }
}
