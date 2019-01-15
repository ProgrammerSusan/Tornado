
/*
 * Susan Hatem
 * https://github.com/ProgrammerSusan/Tornado
 */

import javax.swing.*;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;

public class CountAlive extends javax.swing.JFrame {
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    
    public CountAlive(int c) {
        super("Tornado Simuation");
        super.frameInit();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); 
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("End of Simulation");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); 
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText(String.valueOf(c));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36));
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("People remaining:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(350, 350, 350))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(220, 220, 220)
                .addComponent(jLabel2)
                .addContainerGap(0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(550, 550, 550))
        );

        jLabel2.getAccessibleContext().setAccessibleName("remaining");
        pack();
        
        setVisible(true);
        setResizable(false);
        setSize(1000, 1000);
    }
}
