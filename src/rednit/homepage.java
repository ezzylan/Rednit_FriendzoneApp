package rednit;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;


public class homepage extends javax.swing.JFrame {


    public homepage() {
        initComponents();
        setResizable(false);
        setPreferredSize(new Dimension(1000, 579));
        ImageIcon myimage=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("2760246.jpg")));
        Image img1=myimage.getImage();
        Image img2=img1.getScaledInstance(backgroundImage.getWidth(), backgroundImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);
        backgroundImage.setIcon(i);
        
        JPanel jPanel1 = new JPanel(new GridBagLayout());
        jPanel1.setBackground(new Color(0,0,0,4));
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomepageDatingMenu = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        Rednit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 46, 60));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("homepage"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 579));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HomepageDatingMenu.setBackground(new java.awt.Color(51, 46, 60));

        btnLogin.setBackground(new java.awt.Color(196, 178, 188));
        btnLogin.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(51, 46, 60));
        btnLogin.setText("Login");
        btnLogin.setAlignmentX(1.0F);
        btnLogin.setAlignmentY(3.0F);
        btnLogin.setBorder(BorderFactory.createEmptyBorder());
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSignUp.setBackground(new java.awt.Color(196, 178, 188));
        btnSignUp.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(51, 46, 60));
        btnSignUp.setText("Sign Up");
        btnSignUp.setAlignmentX(1.0F);
        btnSignUp.setAlignmentY(3.0F);
        btnSignUp.setBorder(null);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setFocusPainted(false);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        Rednit.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        Rednit.setForeground(new java.awt.Color(196, 178, 188));
        Rednit.setText("REDNIT");

        javax.swing.GroupLayout HomepageDatingMenuLayout = new javax.swing.GroupLayout(HomepageDatingMenu);
        HomepageDatingMenu.setLayout(HomepageDatingMenuLayout);
        HomepageDatingMenuLayout.setHorizontalGroup(
            HomepageDatingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomepageDatingMenuLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Rednit)
                .addGap(555, 555, 555)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        HomepageDatingMenuLayout.setVerticalGroup(
            HomepageDatingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomepageDatingMenuLayout.createSequentialGroup()
                .addGroup(HomepageDatingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HomepageDatingMenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Rednit))
                    .addGroup(HomepageDatingMenuLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(HomepageDatingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(HomepageDatingMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        jLabel1.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Chat Now,");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 240, 70));

        jLabel3.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date Later.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 260, 70));

        jLabel2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Match. Chat. Date.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 220, 20));

        backgroundImage.setText("Picture");
        getContentPane().add(backgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       new Login().setVisible(true);
       dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSignUpActionPerformed

    
    

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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    
                }
                new homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomepageDatingMenu;
    private javax.swing.JLabel Rednit;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
