package rednit;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    AESEncryptDecrypt aes = new AESEncryptDecrypt();
    String secretKey = "friendZoned!!!";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public static String username1, name1, state1, email1, phone1, gender1, interest1, hobby1, friend1 = null;
    
    
    public Login() {
        initComponents();
        
        //EVERY JFRAME SIZE
        setResizable(false);
        setPreferredSize(new Dimension(1000, 579));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //INSERT ABOVE CODE 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomepageDatingMenu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jpLogin = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        goRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 46, 60));
        setMinimumSize(new java.awt.Dimension(1000, 579));

        HomepageDatingMenu.setBackground(new java.awt.Color(58, 57, 81));

        jLabel12.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(196, 178, 188));
        jLabel12.setText("REDNIT");

        javax.swing.GroupLayout HomepageDatingMenuLayout = new javax.swing.GroupLayout(HomepageDatingMenu);
        HomepageDatingMenu.setLayout(HomepageDatingMenuLayout);
        HomepageDatingMenuLayout.setHorizontalGroup(
            HomepageDatingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomepageDatingMenuLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomepageDatingMenuLayout.setVerticalGroup(
            HomepageDatingMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomepageDatingMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(10, 10, 10))
        );

        jpLogin.setBackground(new java.awt.Color(51, 46, 60));
        jpLogin.setPreferredSize(new java.awt.Dimension(1000, 579));

        lblUsername.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(216, 212, 242));
        lblUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(216, 212, 242));
        lblPassword.setText("Password");

        username.setBackground(new java.awt.Color(0, 0, 0));
        username.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(222, 255, 255));
        username.setToolTipText("Enter your username");
        username.setAutoscrolls(false);
        username.setSelectedTextColor(new java.awt.Color(216, 212, 242));

        password.setBackground(new java.awt.Color(18, 1, 0));
        password.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(222, 255, 255));
        password.setSelectedTextColor(new java.awt.Color(216, 212, 242));

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        goRegister.setBackground(new java.awt.Color(196, 178, 188));
        goRegister.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        goRegister.setForeground(new java.awt.Color(51, 46, 60));
        goRegister.setText("Don't have an account? Click here to start match and date!");
        goRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goRegister)
                    .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jpLoginLayout.createSequentialGroup()
                            .addComponent(lblPassword)
                            .addGap(35, 35, 35)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpLoginLayout.createSequentialGroup()
                            .addComponent(lblUsername)
                            .addGap(31, 31, 31)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(goRegister)
                .addGap(46, 46, 46)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addGap(18, 18, 18)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addComponent(login)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HomepageDatingMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HomepageDatingMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
    if(username.getText().equals("") || password.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Please insert username/password to login.");
    }else {
        String sql = "select * from data where id_username=? and id_password=?";
        try{
            con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating?serverTimezone=UTC", "root","");
            ps = con.prepareStatement(sql);
            ps.setString(1, username.getText());
            ps.setString(2, aes.encrypt(password.getText(), secretKey));
            username1 = username.getText();
            rs = ps.executeQuery();
            if(rs.next()){
                name1 = rs.getString("id_name");
                state1 = rs.getString("id_state");
                email1 = rs.getString("id_email");
                phone1 = rs.getString("id_phone");
                gender1 = rs.getString("id_gender");
                interest1 =  rs.getString("id_interest");
                hobby1 = rs.getString("id_hobby");
                friend1 = rs.getString("id_friend");
                Profile main = new Profile();
                main.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Your username/password not matched.");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }   
    }//GEN-LAST:event_loginActionPerformed

    private void goRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goRegisterActionPerformed
        Register reg = new Register();
        reg.setVisible(true);
        dispose();
    }//GEN-LAST:event_goRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomepageDatingMenu;
    private javax.swing.JButton goRegister;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
