/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anu;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static cssssss.taskform.MySqlConnection;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sajeesan
 */
public class addEmployee extends javax.swing.JFrame {

    private String address;
    private String nic;
    private Date date;
    private byte[] photo;

    /**
     * Creates new form addEmployee
     */
    public addEmployee() {
        initComponents();
    }

    public static Connection MySqlConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_inventory","root","Sathu@0096");

            return conn;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Mysql Connection Failed...");

            return null;

        }

    }

    String Photopath = "";

    public ImageIcon resetImageSize(String photopath, byte[] photo) {

        ImageIcon myPhoto = null;

        if (photopath != null) {

            myPhoto = new ImageIcon(photopath);

        } else {
            myPhoto = new ImageIcon(photo);
        }
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(Label_photo.getWidth(), Label_photo.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon ph = new ImageIcon(img1);
        return ph;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton6_dashboard = new javax.swing.JButton();
        jButton7_back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Label_photo = new javax.swing.JLabel();
        jButton1_choose = new javax.swing.JButton();
        jTextField_eid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_ename = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_nic = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3_insert = new javax.swing.JButton();
        jButton4_update = new javax.swing.JButton();
        jButton5_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_validate = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        labe = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 97, 97));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6_dashboard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6_dashboard.setForeground(new java.awt.Color(255, 0, 0));
        jButton6_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anu/dashboard1.png"))); // NOI18N
        jButton6_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6_dashboard.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton6_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6_dashboardActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, 40));

        jButton7_back.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7_back.setForeground(new java.awt.Color(255, 0, 0));
        jButton7_back.setText("Data");
        jButton7_back.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton7_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7_backActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 140, -1));

        jPanel2.setBackground(new java.awt.Color(97, 97, 97));

        Label_photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_photo.setOpaque(true);

        jButton1_choose.setText("PHOTO");
        jButton1_choose.setToolTipText("");
        jButton1_choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_chooseActionPerformed(evt);
            }
        });

        jTextField_eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_eidActionPerformed(evt);
            }
        });
        jTextField_eid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_eidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_eidKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("ID");

        jTextField_ename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_enameActionPerformed(evt);
            }
        });
        jTextField_ename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_enameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("DOB");

        jTextField_nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nicActionPerformed(evt);
            }
        });
        jTextField_nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_nicKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("NIC NO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Address");

        jButton3_insert.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3_insert.setForeground(new java.awt.Color(255, 0, 0));
        jButton3_insert.setText("Insert");
        jButton3_insert.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton3_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_insertActionPerformed(evt);
            }
        });

        jButton4_update.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4_update.setForeground(new java.awt.Color(255, 0, 0));
        jButton4_update.setText("Update");
        jButton4_update.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton4_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_updateActionPerformed(evt);
            }
        });

        jButton5_delete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5_delete.setForeground(new java.awt.Color(255, 0, 0));
        jButton5_delete.setText("Delete");
        jButton5_delete.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton5_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5_deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel1.setText("PROFILE PHOTO");

        txt_validate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_validate.setForeground(new java.awt.Color(255, 0, 0));

        name_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name_label.setForeground(new java.awt.Color(255, 0, 0));
        name_label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                name_labelKeyReleased(evt);
            }
        });

        label.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cssssss/aa.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jButton4_update, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton5_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(261, 261, 261)
                                        .addComponent(jTextField_address, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(337, 337, 337)
                                                .addComponent(txt_validate, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(297, 297, 297)
                                                .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1_choose)))
                                .addGap(120, 120, 120)))
                        .addComponent(labe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(216, 216, 216)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_ename, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1_choose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addComponent(txt_validate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_ename, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(labe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4_update, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 60, 1370, 700));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("HOME");
        jButton3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 130, 40));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 220, 40));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel9.setText("SEARCH");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 110, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6_dashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6_dashboardActionPerformed

    private void jButton7_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7_backActionPerformed

        employee emp = new employee();
        emp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7_backActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        employeedashboard emps = new employeedashboard();
        emps.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_inventory","root","Sathu@0096");
            String qry = "select * from employee where ename=?";
            PreparedStatement ps = conn.prepareStatement(qry);

            ps.setString(1, search.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String setid = rs.getString("eid");
                jTextField_eid.setText(setid);

                String setname = rs.getString("ename");
                jTextField_ename.setText(setname);

                jDateChooser1.setDate(rs.getDate("Dob"));

                String setnic = rs.getString("nic");
                jTextField_nic.setText(setnic);

                String setaddress = rs.getString("address");
                jTextField_address.setText(setaddress);

                byte[] img = rs.getBytes("photo");

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(Label_photo.getWidth(), Label_photo.getHeight(), Image.SCALE_SMOOTH));

                Label_photo.setIcon(imageIcon);
                photo = img;

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }


    }//GEN-LAST:event_searchKeyReleased

    private void name_labelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_name_labelKeyReleased

    }//GEN-LAST:event_name_labelKeyReleased

    private void jButton5_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5_deleteActionPerformed

        if (jTextField_eid.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "please enter employee Id");
        } else {

            try {

                String qry = "delete from employee where eid=?";

                Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement(qry);
                ps.setInt(1, Integer.parseInt(jTextField_eid.getText().toString()));

                int res = ps.executeUpdate();

                if (res >= 1) {

                    JOptionPane.showMessageDialog(null, "employee deleted successful");

                } else {
                    JOptionPane.showMessageDialog(null, "employee deletion fail");
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);

            }

        }
    }//GEN-LAST:event_jButton5_deleteActionPerformed

    private void jButton4_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_updateActionPerformed

        if (jTextField_eid != null
            || jTextField_ename != null
            || jTextField_nic != null
            || jDateChooser1 != null && jTextField_address != null) {
            String qry = null;
            PreparedStatement ps = null;
            Connection conn = MySqlConnection();

            try {

                qry = "update employee set ename=?, nic=?, Dob=?, address=?  where eid=?";
                ps = conn.prepareStatement(qry);

                ps.setString(1, jTextField_ename.getText());
                ps.setString(2, jTextField_nic.getText());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(jDateChooser1.getDate());
                ps.setString(3, date);

                ps.setString(4, jTextField_address.getText());
                ps.setInt(5, Integer.parseInt(jTextField_eid.getText()));

                int res = ps.executeUpdate();

                if (res >= 1) {
                    JOptionPane.showMessageDialog(null, "employee updated ");
                } else {
                    JOptionPane.showMessageDialog(null, "update fail ");
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }

            jTextField_eid.setText("");
            jTextField_ename.setText("");
            jTextField_nic.setText("");
            jTextField_address.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "employee update fail ");
        }
    }//GEN-LAST:event_jButton4_updateActionPerformed

    private void jButton3_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_insertActionPerformed

        String id = jTextField_eid.getText();
        String name = jTextField_ename.getText();
        Date dates = jDateChooser1.getDate();
        String nic = jTextField_nic.getText();
        String address = jTextField_address.getText();

        if (id.equals("")) {

            JOptionPane.showMessageDialog(null, "id cannot be empty");
        }

        if (name.equals("")) {

            JOptionPane.showMessageDialog(null, "name cannot be empty");
        }

        if (dates.equals("")) {

            JOptionPane.showMessageDialog(null, "dates cannot be empty");
        }

        if (nic.equals("")) {

            JOptionPane.showMessageDialog(null, "nic cannot be empty");
        }

        if (address.equals("")) {

            JOptionPane.showMessageDialog(null, "address cannot be empty");
        } else if (jTextField_eid.getText() != null || jTextField_ename.getText() != null || jDateChooser1 != null || jTextField_nic != null || jTextField_address.getText() != null && Photopath != null) {

            try {

                Connection conn = MySqlConnection();
                String qry = "insert into employee values (?,?,?,?,?,?)";

                PreparedStatement ps = conn.prepareStatement(qry);

                ps.setInt(1, Integer.parseInt(jTextField_eid.getText()));
                ps.setString(2, jTextField_ename.getText());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(jDateChooser1.getDate());
                ps.setString(3, date);

                ps.setString(4, jTextField_nic.getText());

                ps.setString(5, jTextField_nic.getText());

                InputStream is = new FileInputStream(new File(Photopath));

                ps.setBlob(6, is);

                int res = ps.executeUpdate();

                if (res >= 1) {

                    JOptionPane.showMessageDialog(null, "number of employee added ");
                } else {
                    JOptionPane.showMessageDialog(null, "insertion fail ");
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);

            }

            Label_photo.setText("");
            jTextField_eid.setText("");
            jTextField_ename.setText("");
            jTextField_nic.setText("");
            jTextField_address.setText("");

        }
    }//GEN-LAST:event_jButton3_insertActionPerformed

    private void jTextField_nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nicKeyPressed

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {

            jTextField_nic.setEditable(false);

            labe.setText("Enter num only");

        } else {
            jTextField_nic.setEditable(true);

        }
    }//GEN-LAST:event_jTextField_nicKeyPressed

    private void jTextField_nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nicActionPerformed

    private void jTextField_enameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_enameKeyPressed

        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {

            jTextField_ename.setEditable(true);

        } else {
            jTextField_ename.setEditable(false);
            label11.setText("Enter Texts only");
        }
    }//GEN-LAST:event_jTextField_enameKeyPressed

    private void jTextField_enameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_enameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_enameActionPerformed

    private void jTextField_eidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_eidKeyReleased

    }//GEN-LAST:event_jTextField_eidKeyReleased

    private void jTextField_eidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_eidKeyPressed

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {

            jTextField_eid.setEditable(false);

            label.setText("Enter numbers only");

        } else {
            jTextField_eid.setEditable(true);
        }
    }//GEN-LAST:event_jTextField_eidKeyPressed

    private void jTextField_eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_eidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_eidActionPerformed

    private void jButton1_chooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_chooseActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.images", "jpg", "png");
        chooser.addChoosableFileFilter(fnef);
        int ans = chooser.showSaveDialog(null);
        if (ans == JFileChooser.APPROVE_OPTION) {

            File selectedPhoto = chooser.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();
            Label_photo.setIcon(resetImageSize(path, null));
            this.Photopath = path;
        }
    }//GEN-LAST:event_jButton1_chooseActionPerformed

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
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_photo;
    private javax.swing.JButton jButton1_choose;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton3_insert;
    private javax.swing.JButton jButton4_update;
    private javax.swing.JButton jButton5_delete;
    private javax.swing.JButton jButton6_dashboard;
    private javax.swing.JButton jButton7_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_address;
    private javax.swing.JTextField jTextField_eid;
    private javax.swing.JTextField jTextField_ename;
    private javax.swing.JTextField jTextField_nic;
    private javax.swing.JLabel labe;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel name_label;
    private javax.swing.JTextField search;
    private javax.swing.JLabel txt_validate;
    // End of variables declaration//GEN-END:variables
}
