package rednit;

import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import static rednit.Profile.km;

public class profileEdit extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String filename;
    byte[] fileBytes, image = null;
    JLabel label;
    Login a = new Login();
    String username = a.username1;
    String name = a.name1;
    String state = a.state1; 
    String email = a.email1; 
    String phone = a.phone1;
    String gender = a.gender1; 
    String interest = a.interest1;
    String hobby = a.hobby1; 
    String friend = a.friend1;

    
    public profileEdit() {
        initComponents();
        
        //EVERY JFRAME SIZE
        setResizable(false);
        setPreferredSize(new Dimension(1000, 579));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //INSERT ABOVE CODE 
        
        
        //RETRIEVE DATABASE
        String sql = "select * from data where id_username=" + "'" + username + "'" ;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating?serverTimezone=UTC", "root", "");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //DATA INFO SAVE IN VARIABLE
                image = rs.getBytes("id_image");
                if(image!=null){
                    //Display Image
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(profilePicture.getWidth(),profilePicture.getHeight(),Image.SCALE_SMOOTH));
                    profilePicture.setIcon(imageIcon);
                }else{
                    //Display Image for null data
                    ImageIcon imageIcon =new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("default.jpg")).getScaledInstance(profilePicture.getWidth(),profilePicture.getHeight(),Image.SCALE_SMOOTH));
                    profilePicture.setIcon(imageIcon);} 
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        if(hobby==null){
            hobby = "No data recorded.";
        }
        
        lblState.setText(state);
        
        if (interest.equals("Male")){
            boxInterest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        }else{
            boxInterest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        }
        
        if (hobby.equals("Sports")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sports", "Music", "Reading", "Travelling", "Gaming", "Socializing", "Dancing", "Painting", "Gardening" }));
        }else if(hobby.equals("Music")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Music", "Sports", "Reading", "Travelling", "Gaming", "Socializing", "Dancing", "Painting", "Gardening" }));
        }else if(hobby.equals("Reading")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reading", "Sports", "Music", "Travelling", "Gaming", "Socializing", "Dancing", "Painting", "Gardening" }));
        }else if(hobby.equals("Travelling")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Travelling", "Sports", "Music", "Reading", "Gaming", "Socializing", "Dancing", "Painting", "Gardening" }));
        }else if(hobby.equals("Gaming")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gaming", "Sports", "Music", "Reading", "Travelling", "Socializing", "Dancing", "Painting", "Gardening" }));
        }else if(hobby.equals("Socializing")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Socializing", "Sports", "Music", "Reading", "Travelling", "Gaming", "Dancing", "Painting", "Gardening" }));
        }else if(hobby.equals("Dancing")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dancing", "Sports", "Music", "Reading", "Travelling", "Gaming", "Socializing", "Painting", "Gardening" }));
        }else if(hobby.equals("Painting")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Painting", "Sports", "Music", "Reading", "Travelling", "Gaming", "Socializing", "Dancing", "Gardening" }));
        }else if(hobby.equals("Gardening")){
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gardening", "Sports", "Music", "Reading", "Travelling", "Gaming", "Socializing", "Dancing", "Painting" }));
        }else{
            boxHobby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sports", "Music", "Reading", "Travelling", "Gaming", "Socializing", "Dancing", "Painting", "Gardening" }));
        }
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHeader = new javax.swing.JPanel();
        Rednit = new javax.swing.JLabel();
        welcomeNote = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnMatch = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();
        jImage = new javax.swing.JPanel();
        profilePicture = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblState1 = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        lblPhone2 = new javax.swing.JLabel();
        lblGender2 = new javax.swing.JLabel();
        lblInterest2 = new javax.swing.JLabel();
        lblHobby2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPhone = new javax.swing.JTextField();
        jGender = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        boxInterest = new javax.swing.JComboBox<>();
        boxHobby = new javax.swing.JComboBox<>();
        jName = new javax.swing.JTextField();
        lblFullName = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 46, 60));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1000, 579));
        setResizable(false);

        jpHeader.setBackground(new java.awt.Color(58, 57, 81));
        jpHeader.setPreferredSize(new java.awt.Dimension(219, 80));

        Rednit.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        Rednit.setForeground(new java.awt.Color(196, 178, 188));
        Rednit.setText("REDNIT");

        welcomeNote.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        welcomeNote.setForeground(new java.awt.Color(204, 204, 255));
        welcomeNote.setText("Welcome, " + username + "!");

        btnLogout.setBackground(new java.awt.Color(196, 178, 188));
        btnLogout.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(51, 46, 60));
        btnLogout.setText("Logout");
        btnLogout.setAlignmentX(1.0F);
        btnLogout.setAlignmentY(3.0F);
        btnLogout.setBorder(null);
        btnLogout.setBorderPainted(false);
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnMatch.setBackground(new java.awt.Color(196, 178, 188));
        btnMatch.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnMatch.setForeground(new java.awt.Color(51, 46, 60));
        btnMatch.setText("Match");
        btnMatch.setAlignmentX(1.0F);
        btnMatch.setAlignmentY(3.0F);
        btnMatch.setBorder(null);
        btnMatch.setBorderPainted(false);
        btnMatch.setFocusPainted(false);
        btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchActionPerformed(evt);
            }
        });

        btnProfile.setBackground(new java.awt.Color(58, 57, 81));
        btnProfile.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(196, 178, 188));
        btnProfile.setText("Profile");
        btnProfile.setAlignmentX(1.0F);
        btnProfile.setAlignmentY(3.0F);
        btnProfile.setBorder(null);
        btnProfile.setBorderPainted(false);
        btnProfile.setFocusPainted(false);
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnChat.setBackground(new java.awt.Color(196, 178, 188));
        btnChat.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnChat.setForeground(new java.awt.Color(51, 46, 60));
        btnChat.setText("Chat");
        btnChat.setAlignmentX(1.0F);
        btnChat.setAlignmentY(3.0F);
        btnChat.setBorder(null);
        btnChat.setBorderPainted(false);
        btnChat.setFocusPainted(false);
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpHeaderLayout = new javax.swing.GroupLayout(jpHeader);
        jpHeader.setLayout(jpHeaderLayout);
        jpHeaderLayout.setHorizontalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Rednit)
                .addGap(188, 188, 188)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(welcomeNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpHeaderLayout.setVerticalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Rednit))
                    .addGroup(jpHeaderLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(welcomeNote)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jImage.setBackground(new java.awt.Color(99, 91, 115));
        jImage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jImage.add(profilePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 160));

        jPanel1.setBackground(new java.awt.Color(51, 46, 60));

        lblState1.setBackground(new java.awt.Color(51, 46, 60));
        lblState1.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblState1.setForeground(new java.awt.Color(216, 212, 242));
        lblState1.setText("State:");

        lblState.setBackground(new java.awt.Color(51, 46, 60));
        lblState.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblState.setForeground(new java.awt.Color(216, 212, 242));
        lblState.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblEmail2.setBackground(new java.awt.Color(51, 46, 60));
        lblEmail2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblEmail2.setForeground(new java.awt.Color(216, 212, 242));
        lblEmail2.setText("Email:");

        lblPhone2.setBackground(new java.awt.Color(51, 46, 60));
        lblPhone2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblPhone2.setForeground(new java.awt.Color(216, 212, 242));
        lblPhone2.setText("Phone:");

        lblGender2.setBackground(new java.awt.Color(51, 46, 60));
        lblGender2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblGender2.setForeground(new java.awt.Color(216, 212, 242));
        lblGender2.setText("Gender:");

        lblInterest2.setBackground(new java.awt.Color(51, 46, 60));
        lblInterest2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblInterest2.setForeground(new java.awt.Color(216, 212, 242));
        lblInterest2.setText("Interest in:");

        lblHobby2.setBackground(new java.awt.Color(51, 46, 60));
        lblHobby2.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblHobby2.setForeground(new java.awt.Color(216, 212, 242));
        lblHobby2.setText("Hobby:");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPhone.setBackground(new java.awt.Color(0, 0, 0));
        jPhone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPhone.setForeground(new java.awt.Color(222, 255, 255));
        jPhone.setText(phone);

        jGender.setEditable(false);
        jGender.setBackground(new java.awt.Color(102, 102, 102));
        jGender.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jGender.setForeground(new java.awt.Color(222, 255, 255));
        jGender.setText(gender);

        jEmail.setBackground(new java.awt.Color(0, 0, 0));
        jEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jEmail.setForeground(new java.awt.Color(222, 255, 255));
        jEmail.setText(email);

        boxInterest.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        boxHobby.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jName.setBackground(new java.awt.Color(0, 0, 0));
        jName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jName.setForeground(new java.awt.Color(222, 255, 255));
        jName.setText(name);

        lblFullName.setBackground(new java.awt.Color(51, 46, 60));
        lblFullName.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        lblFullName.setForeground(new java.awt.Color(216, 212, 242));
        lblFullName.setText("Full Name:");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGender2)
                            .addComponent(lblInterest2)
                            .addComponent(lblHobby2))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jGender)
                                .addGap(321, 321, 321))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boxInterest, 0, 138, Short.MAX_VALUE)
                                    .addComponent(boxHobby, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmail2)
                                    .addComponent(lblPhone2))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblState1)
                                    .addComponent(lblFullName))
                                .addGap(548, 548, 548)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnCancel))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFullName)
                            .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblState1)
                    .addComponent(lblState, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhone2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGender2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInterest2)
                    .addComponent(boxInterest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHobby2)
                    .addComponent(boxHobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        username = null;
        new homepage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you serious to leave?", "Leave?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                int reply1 = JOptionPane.showConfirmDialog(null, "The radius for matching is set within 100km. Do you want to change?", "Radius", JOptionPane.YES_NO_OPTION);
                if (reply1 == JOptionPane.YES_OPTION) {
                    String answer = JOptionPane.showInputDialog("Insert your radius");
                    km = Double.parseDouble(answer);
                } else {
                    km = 100;
                }
               new NearByUser().setVisible(true);
               this.dispose();
            } 
    }//GEN-LAST:event_btnMatchActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed

    }//GEN-LAST:event_btnProfileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "UPDATE data SET id_name=? , id_email=? , id_phone=? , id_interest=? , id_hobby=? WHERE id_username=" + "'" + username + "'" ;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating?serverTimezone=UTC", "root", "");
            ps = con.prepareStatement(sql);
            ps.setString(1, jName.getText());
            ps.setString(2, jEmail.getText());
            ps.setString(3, jPhone.getText());
            ps.setString(4, boxInterest.getSelectedItem().toString());
            ps.setString(5, boxHobby.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update successfully. Please log in again.");
            new homepage().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No file inserted.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Are you serious to leave?", "Leave?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
               new chatMenu().setVisible(true);
               this.dispose();
            } 
    }//GEN-LAST:event_btnChatActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(profileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profileEdit().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rednit;
    private javax.swing.JComboBox<String> boxHobby;
    private javax.swing.JComboBox<String> boxInterest;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMatch;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jGender;
    private javax.swing.JPanel jImage;
    private javax.swing.JTextField jName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPhone;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender2;
    private javax.swing.JLabel lblHobby2;
    private javax.swing.JLabel lblInterest2;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblState1;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JLabel welcomeNote;
    // End of variables declaration//GEN-END:variables
}
