package rednit;

import java.awt.*;
import java.util.logging.*;
import java.sql.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static rednit.Profile.km;

public class NearByUser extends javax.swing.JFrame {
    public static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<String> currentUser = new ArrayList<>();
    public static ArrayList<String> sortedUser = new ArrayList<>();
    Profile b = new Profile();
    public final double RADIUS = b.km;
    Login a = new Login();
    String username = a.username1;
    public static String receiver;
    

    public NearByUser() {
        initComponents();
        getDataFromSql();
        showUser(count);
        
        //EVERY JFRAME SIZE
        setResizable(false);
        setPreferredSize(new Dimension(1000, 579));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //INSERT ABOVE CODE 
        
        previous.setVisible(false);
        first.setVisible(false);
        
    }
    int count=0;
     public Connection getConnection() {
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2/dating", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(NearByUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public void getDataFromSql() {
        double myXCoordinate = 0;
        double myYCoordinate = 0;
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Double> XCoordinate = new ArrayList<>();
        ArrayList<Double> YCoordinate = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<String> interest = new ArrayList<>();
        ArrayList<String> hobby = new ArrayList<>();
        
        try {
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            
            ResultSet mainUser = st.executeQuery("SELECT * FROM data WHERE id_username = '" + username + "'");

            while (mainUser.next()) {
                myXCoordinate = mainUser.getDouble("id_x");
                myYCoordinate = mainUser.getDouble("id_y"); 
                currentUser.add(mainUser.getString("id_gender")); 
                currentUser.add(mainUser.getString("id_interest"));
                currentUser.add(mainUser.getString("id_hobby")); 
                              
            }

            ResultSet User = st.executeQuery("SELECT * FROM data WHERE id_username != '" + username + "'");
            while (User.next()) {
                name.add(User.getString("id_username"));
                XCoordinate.add(User.getDouble("id_x"));
                YCoordinate.add(User.getDouble("id_y"));
                gender.add(User.getString("id_gender"));
                interest.add(User.getString("id_interest"));
                hobby.add(User.getString("id_hobby"));
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(NearByUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getDistance(myXCoordinate , myYCoordinate , XCoordinate, YCoordinate, name, gender, interest, hobby);
        
        
    }

    public void getDistance(double myX, double myY, ArrayList<Double> XCoordinate, ArrayList<Double> YCoordinate, ArrayList<String> name,
            ArrayList<String> gender,ArrayList<String> interest,ArrayList<String> hobby) {

        for (int i = 0; i < XCoordinate.size() && i < YCoordinate.size(); i++) {
            double userX = XCoordinate.get(i);
            double userY = YCoordinate.get(i);
            double differLon = Math.toRadians(userX - myX);
            double differLat = Math.toRadians(userY - myY);

            double a = Math.pow(Math.sin(differLat / 2), 2) + Math.cos(myY) * Math.cos(userY) * Math.pow(Math.sin(differLon / 2), 2);
            double distance = 2 * Math.asin(Math.sqrt(a)) * 6371;
            String dis = Double.toString(Math.round(distance*km)/km);
            if (distance <= RADIUS) {
                list.add(name.get(i));
                list.add(gender.get(i));
                list.add(interest.get(i));
                list.add(hobby.get(i));
                list.add(dis);
            }
            
             
        }
        if(list.size()==0)
            JOptionPane.showMessageDialog(null, "Sorry no user in your area. :(");
        else
            sameInterest();
    }
    
    public static ArrayList getList(){
        return list;
    }
    
    public ArrayList getInfoCurrentUser(){
        return currentUser;
    }
    
    public void sameInterest(){
        ArrayList<Integer> score= new ArrayList<>();      
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> distance = new ArrayList<>();

        int temp=4;
        for(int i=0;i<list.size();i++){ //simpan score untuk setiap user
         //to get distance
         if(i==4 ){
          distance.add(list.get(i));
         }
         else if(i>4 && i-temp==5){
             distance.add(list.get(i));
             temp+=5;
         }
         //to get name
         if(i==0 || i%5==0){
         int mark=0;
         
         if(i==0)
          name.add(list.get(i));
         else if(i>0 && ((i+5)%5)==0){
             name.add(list.get(i));
         }
         if(currentUser.get(0).equals(list.get(i+2))){ //gender current compare dgn user lain interest
             mark+=1;
         }
         if(currentUser.get(1).equals(list.get(i+1))){ //interest current compare dgn user lain gender
             mark+=2;
         }
         if(currentUser.get(2).equals(list.get(i+3))){ //hobby
             mark++;
         }
         score.add(mark);
         }
     }
        
        bubbleSort(name,copyList(score));
        bubbleSort(distance,copyList(score));
        for(int i=0;i<name.size();i++){
           sortedUser.add(name.get(i));
           sortedUser.add(distance.get(i));          
        }              
    }
    
    public ArrayList<Sorted> getUserList(){
        try{
            Connection connection = getConnection();
            Statement st = connection.createStatement();
            
            ArrayList<Sorted> list = new ArrayList<Sorted>();
            Sorted hasSorted;

                for(int i=0;i<sortedUser.size();i++){
                    if(i%2==0){
                        ResultSet result = st.executeQuery("SELECT * FROM data");
                        while(result.next()){
                        if(result.getString("id_username").equals(sortedUser.get(i))){
                           hasSorted = new Sorted(result.getString("id_username"),result.getString("id_gender"),result.getString("id_interest"),
                           result.getString("id_hobby"), sortedUser.get(i+1),result.getBytes("id_image"));
                           list.add(hasSorted);
                        }
                        }
                    }
                        
                }
            
            st.close();
            return list;
            
        } catch(SQLException ex) {
            Logger.getLogger(NearByUser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
    }
       
    }
    
    public void showUser(int index){
        name.setText(getUserList().get(index).getName());
        gender.setText(getUserList().get(index).getGender());
        hobby.setText(getUserList().get(index).getHobby());
        distance.setText(getUserList().get(index).getLocation()+"km");
        interest.setText(getUserList().get(index).getInterest());
           
         
           Image a;
           if(getUserList().get(index).getImg() == null){ 
           ImageIcon icon =new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("default.jpg")).getScaledInstance(image.getWidth(),image.getHeight(),Image.SCALE_SMOOTH));
           Image def = icon.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);           
           image.setIcon(new ImageIcon(def));
            }
            else {
                ImageIcon gambar = new ImageIcon(getUserList().get(index).getImg());
                Image img = gambar.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
                image.setIcon(new ImageIcon(img));
            }
        
    }
    
     public static void bubbleSort(ArrayList<String> a,ArrayList score){
      int l = score.size();
     for(int i=0;i<l-1;i++){
         for(int j=0;j<l-i-1;j++){
             if((int)score.get(j)<(int)score.get(j+1)){ //compare score dalam arraylist
                 int tempo = (int)score.get(j);               
                 int c=(int)score.get(j+1);
                 
                 score.set(j,c);
                 score.set(j+1,tempo);
                 
                 //sort String
                 String temp = a.get(j);
                 String temp2 = a.get(j+1);
                 a.set(j, temp2);
                 a.set(j+1, temp);               
             }
         }
     }     
}
    
   public static ArrayList copyList(ArrayList score){
        ArrayList<Integer> cloneList = (ArrayList<Integer>) score.clone();
    return cloneList;
    }
    
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
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        interest = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        hobby = new javax.swing.JLabel();
        distance = new javax.swing.JLabel();
        first = new javax.swing.JButton();
        last = new javax.swing.JButton();
        message = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        previous = new javax.swing.JLabel();
        next = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REDNIT");
        setBackground(new java.awt.Color(51, 46, 60));
        setPreferredSize(new java.awt.Dimension(1000, 579));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnMatch.setBackground(new java.awt.Color(58, 57, 81));
        btnMatch.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnMatch.setForeground(new java.awt.Color(196, 178, 188));
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

        btnProfile.setBackground(new java.awt.Color(196, 178, 188));
        btnProfile.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(58, 57, 81));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
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

        getContentPane().add(jpHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        jPanel3.setBackground(new java.awt.Color(51, 46, 60));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(216, 212, 242));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Gender:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Interested in:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Distance:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Hobby:");

        interest.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        interest.setForeground(new java.awt.Color(0, 0, 0));

        gender.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        gender.setForeground(new java.awt.Color(0, 0, 0));

        name.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));

        hobby.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        hobby.setForeground(new java.awt.Color(0, 0, 0));

        distance.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        distance.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(interest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hobby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(distance, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(gender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(interest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hobby))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(distance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 327, -1));

        first.setText("FIRST");
        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });
        jPanel3.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        last.setText("LAST");
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });
        jPanel3.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, -1, -1));

        message.setText("MESSAGE");
        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });
        jPanel3.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        image.setBackground(new java.awt.Color(255, 102, 51));
        jPanel3.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 167, 132));

        previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/before.png"))); // NOI18N
        previous.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousMouseClicked(evt);
            }
        });
        jPanel3.add(previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 40, 40));

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });
        jPanel3.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed
        // message
        receiver = getUserList().get(count).getName();
        Chat obj1 = new Chat();
        obj1.setVisible(true);
    }//GEN-LAST:event_messageActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
        //last
        count=getUserList().size()-1;
        last.setVisible(false);
        next.setVisible(false);
        first.setVisible(true);
        previous.setVisible(true);
        showUser(count);
    }//GEN-LAST:event_lastActionPerformed

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
        //first 
        count = 0;
        first.setVisible(true);
        previous.setVisible(false);
        last.setVisible(true);
        next.setVisible(true);
        showUser(count);
    }//GEN-LAST:event_firstActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        username = null;
        new homepage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed

    }//GEN-LAST:event_btnMatchActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        new Profile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void previousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousMouseClicked
        // previous
        count--;
        next.setVisible(true);
        first.setVisible(true);
        last.setVisible(true);
        if(count<=0){
        previous.setVisible(false);
        first.setVisible(false);
            count=0;}
        showUser(count);
    }//GEN-LAST:event_previousMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
         // next
        count++;
        previous.setVisible(true);
        first.setVisible(true);
        if(count==(getUserList().size()-1)){
        next.setVisible(false);
        last.setVisible(false);}
        if(count>=getUserList().size()){
            count=getUserList().size()-1;
        }
        showUser(count);
    }//GEN-LAST:event_nextMouseClicked

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        new chatMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnChatActionPerformed

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
            java.util.logging.Logger.getLogger(NearByUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NearByUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NearByUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NearByUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NearByUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Rednit;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMatch;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel distance;
    private javax.swing.JButton first;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel hobby;
    private javax.swing.JLabel image;
    private javax.swing.JLabel interest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JButton last;
    private javax.swing.JButton message;
    private javax.swing.JLabel name;
    private javax.swing.JLabel next;
    private javax.swing.JLabel previous;
    private javax.swing.JLabel welcomeNote;
    // End of variables declaration//GEN-END:variables
}
