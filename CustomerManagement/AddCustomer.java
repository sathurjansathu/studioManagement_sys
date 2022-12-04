/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerManagement;

import UI.Dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.Finance4CustomerIn;
import javaapplication1.Inventory;
import static javaapplication1.Inventory.MySqlConnection;
import javaapplication1.InventoryBean;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sathu
 */
public class AddCustomer extends javax.swing.JFrame {

    /**
     * Creates new form AddCustomer
     */
    public AddCustomer() {
        initComponents();
        AutoID();
       // Show_Ritems();
    fillTable();
    
    }     

    public ArrayList<AddCustomerBean> getRepair_ItemsList()
    {
            ArrayList<AddCustomerBean> al = new ArrayList<AddCustomerBean>();
            Connection conn=MySqlConnection();
            String query = "SELECT * FROM addcustomer";
            
            Statement st;
            ResultSet rs;
            
        try{
            
            
             st = conn.createStatement();
            rs = st.executeQuery(query);
            AddCustomerBean cus;
        
            while(rs.next()){
            
            cus=new AddCustomerBean(rs.getString("id"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
             al.add(cus);
        }  
        }
        
        
        catch(Exception e){
            System.out.println(e);
            
        }
        
        return al;
        
    }
    
    public void fillTable(){
        
        ArrayList<AddCustomerBean> al=getRepair_ItemsList();
        DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
        model.setRowCount(0);
        Object[]row=new Object[10];
                
                for(int i=0; i<al.size(); i++){
                    
                    row[0]=al.get(i).getId();
                    row[1]=al.get(i).getName();
                    row[2]=al.get(i).getNicnumber();
                     row[3]=al.get(i).getAddress();
                    row[4]=al.get(i).getEmail();
                    row[5]=al.get(i).getContectnumber();
                    row[6]=al.get(i).getCategory();
                
                    model.addRow(row);
                }
        
        
    }
    
    
    
    public ArrayList<AddCustomerBean> getSearchTechItemsList(){
        
            ArrayList<AddCustomerBean> searchTechItemsList = new ArrayList<AddCustomerBean>();
             String sql = "SELECT * FROM addcustomer WHERE  name=?" ;
               
        try {
           Connection conn=MySqlConnection();
                    PreparedStatement ps;
                    ResultSet rs;
             ps = conn.prepareStatement(sql);
                    //ps.setString(1, txt_srchID.getText());
                    
                    ps.setString(1, searchTech.getText());
                    rs = ps.executeQuery();
            
            AddCustomerBean searchItems;
            
            while(rs.next()){
                
                searchItems = new AddCustomerBean(rs.getString("id"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
                searchTechItemsList.add(searchItems);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchTechItemsList;
    }
    
    public void SearchTechItems(){
        
        ArrayList<AddCustomerBean> list = getSearchTechItemsList();
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        
        //clear table content
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i = 0; i < list.size(); i++){
     
                    row[0]=list.get(i).getId();
                    row[1]=list.get(i).getName();
                    row[2]=list.get(i).getNicnumber();
                    row[3]=list.get(i).getAddress();
                    row[4]=list.get(i).getEmail();
                    row[5]=list.get(i).getContectnumber();
                    row[6]=list.get(i).getCategory();
                
        model.addRow(row);
        }
    }
 
           public void AutoID(){
        
       Connection conn=MySqlConnection();
         Statement st;
         
        try {
             txt_id.setText("CU001");
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM addcustomer");
            rs.next();
            rs.getString("MAX(id)");
            
            if(rs.getString("MAX(id)") == null){
                txt_id.setText("CU001");
            }else{
                long id = Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
                id++;
                txt_id.setText("CU" + String.format("%03d", id));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error"+ex);
        }
    }
    
               public void Show_Ritems(){
        
        ArrayList<AddCustomerBean> list = getRepair_ItemsList();
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
      
        
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i = 0; i < list.size(); i++){
            
                    row[0]=list.get(i).getId();
                    row[1]=list.get(i).getName();
                    row[2]=list.get(i).getNicnumber();
                    row[3]=list.get(i).getAddress();
                    row[4]=list.get(i).getEmail();
                    row[5]=list.get(i).getContectnumber();
                    row[6]=list.get(i).getCategory();
                
            
            
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jButton1_Back = new javax.swing.JButton();
        jButton2_Cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Name = new javax.swing.JTextField();
        jTextField_NicNo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Address = new javax.swing.JTextArea();
        jTextField_Email = new javax.swing.JTextField();
        jTextField_Contect = new javax.swing.JTextField();
        jButton_Submit = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton3_Submit2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboProject = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        txt_id = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        searchTech = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jButton1_Back.setBackground(new java.awt.Color(255, 102, 0));
        jButton1_Back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1_Back.setForeground(new java.awt.Color(0, 0, 204));
        jButton1_Back.setText("BACK");
        jButton1_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_BackActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1_Back);
        jButton1_Back.setBounds(1050, 50, 120, 40);

        jButton2_Cancel.setBackground(new java.awt.Color(204, 153, 0));
        jButton2_Cancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2_Cancel.setForeground(new java.awt.Color(0, 0, 204));
        jButton2_Cancel.setText("CANCEL");
        jButton2_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_CancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2_Cancel);
        jButton2_Cancel.setBounds(1200, 50, 110, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Name :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 160, 100, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText(" Customer Name:-");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(620, 100, 230, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("NicNO :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 240, 110, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Address :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 320, 120, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("E-mail :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 400, 100, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Contect No :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 460, 150, 50);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Project Category :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 520, 230, 60);
        jPanel1.add(jTextField_Name);
        jTextField_Name.setBounds(200, 170, 290, 40);
        jPanel1.add(jTextField_NicNo);
        jTextField_NicNo.setBounds(200, 240, 290, 50);

        jTextArea_Address.setColumns(20);
        jTextArea_Address.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Address);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(200, 310, 290, 70);
        jPanel1.add(jTextField_Email);
        jTextField_Email.setBounds(200, 400, 290, 50);

        jTextField_Contect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ContectActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_Contect);
        jTextField_Contect.setBounds(200, 470, 290, 40);

        jButton_Submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Submit.setForeground(new java.awt.Color(0, 0, 204));
        jButton_Submit.setText("SUBMIT");
        jButton_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Submit);
        jButton_Submit.setBounds(190, 640, 110, 50);

        jButton_Delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Delete.setForeground(new java.awt.Color(0, 0, 204));
        jButton_Delete.setText("DELETE");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Delete);
        jButton_Delete.setBounds(610, 640, 110, 50);

        jButton3_Submit2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3_Submit2.setForeground(new java.awt.Color(0, 0, 204));
        jButton3_Submit2.setText("UPDATE");
        jButton3_Submit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_Submit2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3_Submit2);
        jButton3_Submit2.setBounds(400, 640, 110, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Add payment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(810, 640, 150, 50);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "NIC No", "Address", "Email", "Contact No", "ProjectCategory"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setRowHeight(20);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(540, 170, 770, 410);

        jPanel2.setBackground(new java.awt.Color(102, 204, 0));

        jLabel9.setBackground(new java.awt.Color(255, 51, 102));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Customer Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(750, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1370, 40);

        jComboProject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboProject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Birthday", "Baby Photoshoot", "Wedding", "Passport" }));
        jComboProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProjectActionPerformed(evt);
            }
        });
        jPanel1.add(jComboProject);
        jComboProject.setBounds(240, 530, 250, 50);

        jButton3.setText("Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1120, 640, 120, 50);

        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        txt_id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_id.setForeground(new java.awt.Color(51, 0, 102));
        txt_id.setOpaque(true);
        jPanel1.add(txt_id);
        txt_id.setBounds(200, 110, 290, 40);

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
        jButton5.setBounds(1150, 110, 157, 40);

        searchTech.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTechActionPerformed(evt);
            }
        });
        jPanel1.add(searchTech);
        searchTech.setBounds(850, 110, 270, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("ID :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(130, 100, 60, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_ContectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ContectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ContectActionPerformed

    private void jButton_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SubmitActionPerformed
                                   
       
        
          if((txt_id !=null||jTextField_Name!=null  || jTextField_NicNo.getText()!=null || 
                  jTextArea_Address !=null ||jTextField_Email.getText()!=null ||
                  jTextField_Contect.getText()!=null || jComboProject!=null ) ){
            
            try
                  {
                
                       Connection conn = MySqlConnection();
                       String qry="insert into addcustomer  values (?,?,?,?,?,?,?)";
                
                      PreparedStatement ps=conn.prepareStatement(qry);
                     
                      ps.setString(1,txt_id.getText());
                      ps.setString(2,jTextField_Name.getText());
                     ps.setString(3,jTextField_NicNo.getText());
                      ps.setString(4,jTextArea_Address.getText());
                      ps.setString(5,jTextField_Email.getText());
                     ps.setInt(6, Integer.parseInt(jTextField_Contect.getText()));
                     ps.setString(7,jComboProject.getSelectedItem().toString());
                   
                     int res=ps.executeUpdate();
                
                     if(res>=1)
                     {
                    
                         JOptionPane.showMessageDialog(null,res+"number of task inserted ");
                         AutoID();
                         fillTable();
                         
                                               
                   jTextField_Name.setText("");
                  
                   jTextField_NicNo.setText("");
                 jTextArea_Address.setText("");
		   jTextField_Email.setText("");
		   jTextField_Contect.setText("");
                   
                   
                     }
                    else
                         
                        JOptionPane.showMessageDialog(null,"insertion fail "); 
                    }
            
                   catch (Exception e) 
                   {
                    
                       JOptionPane.showMessageDialog(null,e);
            
                  }
          }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SubmitActionPerformed

    
        
        public void Show(int index){
   
            
        txt_id.setText(getRepair_ItemsList().get(index).getId());
       jTextField_Name.setText(getRepair_ItemsList().get(index).getName()); 
       jTextField_NicNo.setText(getRepair_ItemsList().get(index).getNicnumber());  
        jTextArea_Address.setText(getRepair_ItemsList().get(index).getAddress());
       jTextField_Email.setText(getRepair_ItemsList().get(index).getEmail());
       jTextField_Contect.setText(Integer.toString(getRepair_ItemsList().get(index).getContectnumber()));
             jComboProject.setSelectedItem(getRepair_ItemsList().get(index).getCategory()); 
        }
    
    
    private void jButton1_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_BackActionPerformed
        // TODO add your handling code here:
        Main m1 = new Main();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1_BackActionPerformed

    private void jButton2_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_CancelActionPerformed
        // TODO add your handling code here:
        Dashboard m1 = new Dashboard();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2_CancelActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
    
                        if(!txt_id.getText().equals("")){
            try {
               Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM addcustomer WHERE id = ?");
                String id = txt_id.getText();
                ps.setString(1, id);
                
                ps.executeUpdate();
                Show_Ritems();
                JOptionPane.showMessageDialog(null, "Item Deleted");
            
                
     
                   jTextField_Name.setText("");
                    jTextField_NicNo.setText("");
                   jTextArea_Address.setText("");
		   jTextField_Email.setText("");
		   jTextField_Contect.setText("");
                //  jComboProject.setSelectedItem("");
	   
                
            } catch (SQLException ex) {
                Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Item Not Deleted");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No Item TO Delete ");
        }
        
        
        
        
        
                                          

    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton3_Submit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_Submit2ActionPerformed
        // TODO add your handling code here:

           if(  txt_id!=null||
                jTextField_Name!=null ||
               jTextField_NicNo!=null ||
	      jTextArea_Address!=null ||
              jTextField_Email!=null ||
              jTextField_Contect!=null || jComboProject!=null)
           {
           
            String qry=null;
            PreparedStatement ps=null;
            Connection conn = MySqlConnection();

            try

            {

                qry="UPDATE addcustomer SET  name=?, nicnumber=?, address=?, email=? ,contactnumber=?,category=? WHERE id=?";
                ps=conn.prepareStatement(qry);
       		
	             ps.setString(1,jTextField_Name.getText());
                     ps.setString(2,jTextField_NicNo.getText());
		     ps.setString(3,jTextArea_Address.getText());
		     ps.setString(4,jTextField_Email.getText());
		     ps.setInt(5, Integer.parseInt(jTextField_Contect.getText()));
                     ps.setString(6,jComboProject.getSelectedItem().toString());
                      ps.setString(7,txt_id.getText());
                   
            
                int res=ps.executeUpdate();
		 AutoID();
                Show_Ritems();

                if(res>=1)

                {
                    JOptionPane.showMessageDialog(null,"employee updated ");
                }
                else
                JOptionPane.showMessageDialog(null,"update fail ");
            }
            catch (Exception e)
            {

                JOptionPane.showMessageDialog(null,e);
            }
                      
                      
                 jTextField_Name.setText("");
                  jTextField_NicNo.setText("");
                 jTextArea_Address.setText("");
		   jTextField_Email.setText("");
		   jTextField_Contect.setText("");
                   
                 

        }

        else

        {
            JOptionPane.showMessageDialog(null,"employee update fail ");
        }
            
        
    }//GEN-LAST:event_jButton3_Submit2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Finance4CustomerIn m1 = new Finance4CustomerIn();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
              MessageFormat header = new MessageFormat("report");
        MessageFormat footer =new MessageFormat("page");
        
     
        
        try{
       
              jTable2.print(JTable.PrintMode.FIT_WIDTH, header, footer); 
        
        
        }catch(Exception e){
            JOptionPane.showInternalMessageDialog(null, "unable print");
            
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProjectActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
         int index = jTable2.getSelectedRow();
        Show(index);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if(searchTech.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Insert Product Name For Search");

        }else{

            if(!searchTech.getText().isEmpty()){

                try{
                    Connection conn = MySqlConnection();
                    PreparedStatement ps;
                    ResultSet rs;

                    String sql = "SELECT * FROM addcustomer WHERE name=?";
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
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_Back;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2_Cancel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton3_Submit2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Submit;
    private javax.swing.JComboBox<String> jComboProject;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea_Address;
    private javax.swing.JTextField jTextField_Contect;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextField jTextField_NicNo;
    private javax.swing.JTextField searchTech;
    private javax.swing.JLabel txt_id;
    // End of variables declaration//GEN-END:variables
}
