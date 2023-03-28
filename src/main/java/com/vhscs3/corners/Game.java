/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.vhscs3.corners;

/**
 *
 * @author mattanpaluy
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    private Board game;
    private type turn;
    private boolean state;
    public Game() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newGame_button = new javax.swing.JButton();
        Board_panel = new com.vhscs3.corners.BoardGraphicPanel();
        endGame_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 950));
        setResizable(false);

        newGame_button.setText("draw board");
        newGame_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGame_buttonActionPerformed(evt);
            }
        });

        Board_panel.setLocation(new java.awt.Point(-32767, -32767));
        Board_panel.setPreferredSize(new java.awt.Dimension(750, 750));
        Board_panel.setSize(new java.awt.Dimension(750, 750));
        Board_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Board_panelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Board_panelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout Board_panelLayout = new javax.swing.GroupLayout(Board_panel);
        Board_panel.setLayout(Board_panelLayout);
        Board_panelLayout.setHorizontalGroup(
            Board_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        Board_panelLayout.setVerticalGroup(
            Board_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        endGame_button.setText("erase board");
        endGame_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endGame_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(newGame_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Board_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endGame_button))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newGame_button)
                    .addComponent(endGame_button))
                .addGap(35, 35, 35)
                .addComponent(Board_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGame_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGame_buttonActionPerformed
        Board game = new Board();
        this.game = game;
        turn = type.white;
        state = true;
        ((BoardGraphicPanel) Board_panel).processData(this.game, state);
        
    }//GEN-LAST:event_newGame_buttonActionPerformed

    private void endGame_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endGame_buttonActionPerformed
        state = false;
        ((BoardGraphicPanel) Board_panel).processData(game, state);
    }//GEN-LAST:event_endGame_buttonActionPerformed

    private void Board_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Board_panelMousePressed
        int mouseStartX = locationCalc(evt.getX());
        int mouseStartY = locationCalc(evt.getY());
        
        Square currentSquare = game.getSquare(mouseStartX, mouseStartY);
        currentSquare.setPiece(null);
        game.setSquare(currentSquare, mouseStartX, mouseStartY);
       
        //System.out.println(mouseStartX + "," + mouseStartY);//these co-ords are relative to the component
    }//GEN-LAST:event_Board_panelMousePressed

    private void Board_panelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Board_panelMouseReleased
        int mouseEndX = locationCalc(evt.getX());
        int mouseEndY = locationCalc(evt.getY());
        
        Square currentSquare = game.getSquare(mouseEndX, mouseEndY);
        if(turn == type.white) { 
            currentSquare.setPiece(new Piece(true));
            turn = type.black;
        }
        else {
            currentSquare.setPiece(new Piece(false));
            turn = type.white;
        }
        game.setSquare(currentSquare, mouseEndX, mouseEndY);
        ((BoardGraphicPanel) Board_panel).processData(this.game, state);
        //System.out.println(mouseEndX + "," + mouseEndY);
    }//GEN-LAST:event_Board_panelMouseReleased

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Board_panel;
    private javax.swing.JButton endGame_button;
    private javax.swing.JButton newGame_button;
    // End of variables declaration//GEN-END:variables
    private int locationCalc(int cordinate){
        if(cordinate > 55 || cordinate <  695){
            
            if(cordinate > 615)
                return 7;
            else if (cordinate > 535)
                return 6;
            else if (cordinate > 455)
                return 5;
            else if (cordinate > 375)
                return 4;
            else if (cordinate > 295)
                return 3;
            else if (cordinate > 215)
                return 2;
            else if (cordinate > 135)
                return 1;
            else if (cordinate > 55)
                return 0;
        }
        return -1;
    }
}
