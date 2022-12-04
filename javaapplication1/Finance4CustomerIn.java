/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import CustomerManagement.AddCustomer;
import CustomerManagement.AddCustomerBean;
import UI.AddProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication1.Inventory.MySqlConnection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sathu
 */
public class Finance4CustomerIn extends javax.swing.JFrame {
    
        public Finance4CustomerIn() {
        initComponents();
        loadcustomer();
        Show_Ritems();
   // fillTable();
    
    } 

     public ArrayList<Finance3CustomerInBean> getRepair_ItemsList()
    {
            ArrayList<Finance3CustomerInBean> al = new ArrayList<Finance3CustomerInBean>();
            Connection conn=MySqlConnection();
            String query = "SELECT * FROM customerincome";
            
            Statement st;
            ResultSet rs;
            
        try{
            
            
             st = conn.createStatement();
            rs = st.executeQuery(query);
            Finance3CustomerInBean cus;
        
            while(rs.next()){
            
            cus=new Finance3CustomerInBean(rs.getString("customerid"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
             al.add(cus);
        }  
        }
        
        
        catch(Exception e){
            System.out.println(e);
            
        }
        
        return al;
        
    }
    
    public void fillTable(){
        
        ArrayList<Finance3CustomerInBean> al=getRepair_ItemsList();
        DefaultTableModel model=(DefaultTableModel)DefaultTableModel1.getModel();
        model.setRowCount(0);
        Object[]row=new Object[5];
                
                for(int i=0; i<al.size(); i++){
                    
                 
                    row[0]=al.get(i).getCustomerid();
                    row[1]=al.get(i).getWorkinghours();
                    row[2]=al.get(i).getDate();
                    row[3]=al.get(i).getCost();
                    row[4]=al.get(i).getPayment();
                    model.addRow(row);
                }
        
        
    }
    
    
     
    public ArrayList<Finance3CustomerInBean> getSearchTechItemsList(){
        
            ArrayList<Finance3CustomerInBean> searchTechItemsList = new ArrayList<Finance3CustomerInBean>();
             String sql = "SELECT * FROM customerincome WHERE  customerid=?" ;
               
        try {
           Connection conn=MySqlConnection();
                    PreparedStatement ps;
                    ResultSet rs;
             ps = conn.prepareStatement(sql);
                    //ps.setString(1, txt_srchID.getText());
                    
                    ps.setString(1, searchTech.getText());
                    rs = ps.executeQuery();
            
            Finance3CustomerInBean searchItems;
            
            while(rs.next()){
                
                searchItems = new Finance3CustomerInBean(rs.getString("customerid"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                searchTechItemsList.add(searchItems);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchTechItemsList;
    }
    
    public void SearchTechItems(){
        
        ArrayList<Finance3CustomerInBean> list = getSearchTechItemsList();
        DefaultTableModel model = (DefaultTableModel)DefaultTableModel1.getModel();
        
        //clear table content
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
     
                    row[0]=list.get(i).getCustomerid();
                    row[1]=list.get(i).getWorkinghours();
                    row[2]=list.get(i).getDate();
                    row[3]=list.get(i).getCost();
                    row[4]=list.get(i).getPayment();
                
        model.addRow(row);
        }
    }
    
    
    
    public void loadcustomer(){
    
        try {
            Connection conn=MySqlConnection();
            
            String query="SELECT * FROM addcustomer";
            PreparedStatement ps=conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String SupplierName=rs.getString("name");
                cb_supplier1.addItem(SupplierName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Finance4CustomerIn.class.getName()).log(Level.SEVERE, null,ex);
        }
    }

    
    
     public void Show_Ritems(){
        
        ArrayList<Finance3CustomerInBean> list = getRepair_ItemsList();
        DefaultTableModel model = (DefaultTableModel)DefaultTableModel1.getModel();
      
        
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
            
                    row[0]=list.get(i).getCustomerid();
                    row[1]=list.get(i).getWorkinghours();
                    row[2]=list.get(i).getDate();
                    row[3]=list.get(i).getCost();
                    row[4]=list.get(i).getPayment();
            
            
            model.addRow(row);
        }
    }
    /**
     * Creates new form Finance2
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton_Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Hours = new javax.swing.JTextField();
        jTextField_Cost = new javax.swing.JTextField();
        jTextField_Payment = new javax.swing.JTextField();
        jButton_update = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton_insert = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        btn_newSupplier1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_supplier1 = new javax.swing.JComboBox<>();
        txtsupplierid1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        searchTech = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 30, 1320, 10);

        jButton_Back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Back.setText("Back");
        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Back);
        jButton_Back.setBounds(1160, 40, 120, 40);

        DefaultTableModel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cutomer ID", "Working Hours", "Date", "Cost", "Payment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DefaultTableModel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DefaultTableModel1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DefaultTableModel1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(620, 160, 670, 450);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Date:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 340, 70, 60);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Payment :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 480, 130, 50);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Cost Per Hours :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 420, 210, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Cutomer ID:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 180, 140, 60);
        jPanel1.add(jTextField_Hours);
        jTextField_Hours.setBounds(260, 270, 230, 40);
        jPanel1.add(jTextField_Cost);
        jTextField_Cost.setBounds(260, 420, 230, 40);
        jPanel1.add(jTextField_Payment);
        jTextField_Payment.setBounds(260, 490, 230, 40);

        jButton_update.setBackground(new java.awt.Color(0, 153, 51));
        jButton_update.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton_update.setText("UPDATE");
        jButton_update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_update);
        jButton_update.setBounds(90, 580, 150, 40);

        jButton4.setText("Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(1170, 640, 120, 40);

        jButton_insert.setBackground(new java.awt.Color(0, 102, 255));
        jButton_insert.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton_insert.setText("INSERT");
        jButton_insert.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insertActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_insert);
        jButton_insert.setBounds(440, 580, 150, 40);

        jButton_Delete.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Delete.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jButton_Delete.setText("DELETE");
        jButton_Delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Delete);
        jButton_Delete.setBounds(270, 580, 140, 40);

        btn_newSupplier1.setText("AddCustomer");
        btn_newSupplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newSupplier1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_newSupplier1);
        btn_newSupplier1.setBounds(510, 100, 110, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Cutomer Name:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 90, 180, 60);

        jPanel3.setBackground(new java.awt.Color(51, 204, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Income from the customer");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1001, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1370, 30);

        cb_supplier1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_supplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_supplier1ActionPerformed(evt);
            }
        });
        jPanel1.add(cb_supplier1);
        cb_supplier1.setBounds(260, 100, 240, 40);

        txtsupplierid1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtsupplierid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsupplierid1ActionPerformed(evt);
            }
        });
        txtsupplierid1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsupplierid1KeyReleased(evt);
            }
        });
        jPanel1.add(txtsupplierid1);
        txtsupplierid1.setBounds(260, 190, 230, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Service Hours:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 260, 180, 60);

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButton5.setText("SEARCH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(1130, 110, 157, 40);

        searchTech.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTechActionPerformed(evt);
            }
        });
        jPanel1.add(searchTech);
        searchTech.setBounds(850, 110, 270, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText(" Customer ID:-");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(630, 110, 220, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        Finance1 rr= new Finance1();
        rr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_BackActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
     
                        if(!txtsupplierid1.getText().equals("")){
            try {
               Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM customerincome WHERE customerid = ?");
                String id = txtsupplierid1.getText();
                ps.setString(1, id);
                
                ps.executeUpdate();
                Show_Ritems();
                JOptionPane.showMessageDialog(null, "Item Deleted");
            
                
     
      
                    jTextField_Hours.setText("");
                    jDateChooser1.setDate(null);
                    jTextField_Cost.setText("");
                    jTextField_Payment.setText(" ");
	   
                
            } catch (SQLException ex) {
                Logger.getLogger(Finance4CustomerIn.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Item Not Deleted");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No Item TO Delete ");
        }
        
        
        
        
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insertActionPerformed
        
        
        
          if(txtsupplierid1!=null || jTextField_Hours!=null||jDateChooser1!=null || jTextField_Cost.getText()!=null || 
                  jTextField_Payment.getText()!=null ){
            
            try
                  {
                
                       Connection conn = MySqlConnection();
                       String qry="insert into customerincome  values (?,?,?,?,?)";
                
                      PreparedStatement ps=conn.prepareStatement(qry);
                     
                      
                    
                     ps.setString(1,txtsupplierid1.getText());
                     ps.setString(2,jTextField_Hours.getText());
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                String date=sdf.format(jDateChooser1.getDate());
                ps.setString(3,date);
                      ps.setString(4,jTextField_Cost.getText());
                       ps.setString(5,jTextField_Payment.getText());

                     
                     
                     int res=ps.executeUpdate();
                     
                     if(res>=1)
                     {
                    
                         JOptionPane.showMessageDialog(null,res+"number of task inserted ");
                         Show_Ritems();
                     
                     }
                    else
                         
                        JOptionPane.showMessageDialog(null,"insertion fail "); 
                    }
            
                   catch (Exception e) 
                   {
                    
                       JOptionPane.showMessageDialog(null,e);
            
                  }
          }      
    }//GEN-LAST:event_jButton_insertActionPerformed

            public void Show(int index){
   
        txtsupplierid1.setText(getRepair_ItemsList().get(index).getCustomerid());
       jTextField_Hours.setText(getRepair_ItemsList().get(index).getWorkinghours()); 
     /*          try {
            Date svcDate = null;
  
            svcDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)getal().get(index).getServiceDate());
           jDateChooser1.setDate(svcDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(Finance4CustomerIn.class.getName()).log(Level.SEVERE, null, ex);
        } */
      jTextField_Cost.setText(getRepair_ItemsList().get(index).getCost()); 
     jTextField_Payment.setText(getRepair_ItemsList().get(index).getPayment()); 
    
        }
    
    
    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
         if(txtsupplierid1!=null || jTextField_Hours.getText()!=null ||jDateChooser1!=null|| jTextField_Cost.getText()!=null || 
                  jTextField_Payment.getText()!=null){
            String UpdateQuery=null;
            PreparedStatement ps= null;

             Connection conn = MySqlConnection();
           
             
            //update without image
             
              
                try{
              
                    UpdateQuery = "UPDATE customerincome SET workinghours=?,date=?,cost=?,payment=? WHERE customerid=? ";
                    ps=conn.prepareStatement(UpdateQuery);
                    
                    
                     ps.setString(1,jTextField_Hours.getText());
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                String date=sdf.format(jDateChooser1.getDate());
                ps.setString(2,date);
                      ps.setString(3,jTextField_Cost.getText());
                       ps.setString(4,jTextField_Payment.getText());
                       ps.setString(5,txtsupplierid1.getText());
                
               
                    
                    txtsupplierid1.setText(" ");
                    jTextField_Hours.setText("");
                    jDateChooser1.setDate(null);
                    jTextField_Cost.setText("");
                    jTextField_Payment.setText(" ");
            
                    
                         ps.executeUpdate();
                         Show_Ritems();
                   
                   JOptionPane.showMessageDialog(null, "Successfully Updated");

                
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
            }
            
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void btn_newSupplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newSupplier1ActionPerformed
        AddCustomer rr= new AddCustomer();
        rr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_newSupplier1ActionPerformed

    private void cb_supplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_supplier1ActionPerformed

        try {
            String sName=cb_supplier1.getSelectedItem().toString();

            Connection conn=MySqlConnection();
            String query="SELECT * FROM addcustomer WHERE name='"+sName+"'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String sNum=rs.getString("id");
                txtsupplierid1.setText(sNum.toString());
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb_supplier1ActionPerformed

    private void txtsupplierid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsupplierid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsupplierid1ActionPerformed

    private void txtsupplierid1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsupplierid1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsupplierid1KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        MessageFormat header = new MessageFormat("report");
        MessageFormat footer =new MessageFormat("page");

        try{

            DefaultTableModel1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e){
            JOptionPane.showInternalMessageDialog(null, "unable print");

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DefaultTableModel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DefaultTableModel1MouseClicked
        // TODO add your handling code here:
        
                 int index = DefaultTableModel1.getSelectedRow();
        Show(index);
        
    }//GEN-LAST:event_DefaultTableModel1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if(searchTech.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Insert Customer ID For Search");

        }else{

            if(!searchTech.getText().isEmpty()){

                try{
                    Connection conn = MySqlConnection();
                    PreparedStatement ps;
                    ResultSet rs;

                    String sql = "SELECT * FROM customerincome WHERE customerid=?";
                    ps = conn.prepareStatement(sql);

                    ps.setString(1,searchTech.getText());
                    rs = ps.executeQuery();

                    if(rs.next()){
                        SearchTechItems();
                    }else{

                        JOptionPane.showMessageDialog(null, "No matching Data");
                    }

                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTechActionPerformed

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
            java.util.logging.Logger.getLogger(Finance4CustomerIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Finance4CustomerIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Finance4CustomerIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Finance4CustomerIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Finance4CustomerIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DefaultTableModel1;
    private javax.swing.JButton btn_newSupplier1;
    private javax.swing.JComboBox<String> cb_supplier1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_insert;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_Cost;
    private javax.swing.JTextField jTextField_Hours;
    private javax.swing.JTextField jTextField_Payment;
    private javax.swing.JTextField searchTech;
    private javax.swing.JTextField txtsupplierid1;
    // End of variables declaration//GEN-END:variables
  }
