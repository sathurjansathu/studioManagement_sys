/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import CustomerManagement.AddCustomerBean;
import Interface.Home;
import UI.Dashboard;

import java.awt.Color;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javaapplication1.Inventory.MySqlConnection;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.Inventory;
import static javaapplication1.Inventory.MySqlConnection;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sathu
 */
public class Supplieradd extends javax.swing.JFrame {

    /**
     * Creates new form Supplier add
     */
    public Supplieradd() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setVisible(true);
        loadProducts();
        loadSupplier();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       fillTable();
       Show_Ritems();
        
        
    }
    
    public ArrayList<UpdateSupplierBean> getRepair_ItemsList()
    {
            ArrayList<UpdateSupplierBean> al = new ArrayList<UpdateSupplierBean>();
            Connection conn=MySqlConnection();
            String query = "SELECT * FROM supplierinventory";
            
            Statement st;
            ResultSet rs;
            
        try{
            
            
             st = conn.createStatement();
            rs = st.executeQuery(query);
           UpdateSupplierBean cus;
        
            while(rs.next()){
            
            cus=new UpdateSupplierBean(rs.getString("id"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
             al.add(cus);
        }  
        }
        
        
        catch(Exception e){
            System.out.println(e);
            
        }
        
        return al;
        
    }
    
    public void fillTable(){
        
        ArrayList<UpdateSupplierBean> al=getRepair_ItemsList();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        Object[]row=new Object[6];
                
                for(int i=0; i<al.size(); i++){
                    
                     row[0]=al.get(i).getId();
                    row[1]=al.get(i).getProductcategory();
                    row[2]=al.get(i).getSupplierid();
                    row[3]=al.get(i).getPrice();
                    row[4]=al.get(i).getWarranty();
                    row[5]=al.get(i).getMinimumqty();
             
                    model.addRow(row);
                }
        
        
    }
    
    
    
    
    public ArrayList<UpdateSupplierBean> getSearchTechItemsList(){
        
            ArrayList<UpdateSupplierBean> searchTechItemsList = new ArrayList<UpdateSupplierBean>();
             String sql = "SELECT * FROM supplierinventory WHERE  productcategory=?" ;
               
        try {
           Connection conn=MySqlConnection();
                    PreparedStatement ps;
                    ResultSet rs;
             ps = conn.prepareStatement(sql);
                    //ps.setString(1, txt_srchID.getText());
                    
                    ps.setString(1, searchTech.getText());
                    rs = ps.executeQuery();
            
            UpdateSupplierBean searchItems;
            
            while(rs.next()){
                
                searchItems = new  UpdateSupplierBean(rs.getString("id"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                searchTechItemsList.add(searchItems);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchTechItemsList;
    }
    
    public void SearchTechItems(){
        
        ArrayList<UpdateSupplierBean> list = getSearchTechItemsList();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        //clear table content
        model.setRowCount(0);
        Object[] row = new Object[6];
        for(int i = 0; i < list.size(); i++){
     
                     row[0]=list.get(i).getId();
                    row[1]=list.get(i).getProductcategory();
                    row[2]=list.get(i).getSupplierid();
                    row[3]=list.get(i).getPrice();
                    row[4]=list.get(i).getWarranty();
                    row[5]=list.get(i).getMinimumqty();
             
        model.addRow(row);
        }
    }
    
    
    
    
    

        public void loadProducts(){
    
        try {
           Connection conn=MySqlConnection();
            String query="SELECT * FROM product";
            PreparedStatement ps=conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String ProductName=rs.getString("productname");
                cb_products.addItem(ProductName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadSupplier(){
    
        try {
            Connection conn=MySqlConnection();
            
            String query="SELECT * FROM newsupplier";
            PreparedStatement ps=conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String SupplierName=rs.getString("companyname");
                cb_supplier.addItem(SupplierName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Newsupplier.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    
    
     public void Show_Ritems(){
        
        ArrayList<UpdateSupplierBean> al = getRepair_ItemsList();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
      
        
        model.setRowCount(0);
        Object[] row = new Object[6];
        for(int i = 0; i < al.size(); i++){
            
                    row[0]=al.get(i).getId();
                    row[1]=al.get(i).getProductcategory();
                    row[2]=al.get(i).getSupplierid();
                    row[3]=al.get(i).getPrice();
                    row[4]=al.get(i).getWarranty();
                    row[5]=al.get(i).getMinimumqty();
             
            
            
            model.addRow(row);
        }
    }    
    
    
    
    //Check input Fields
    public boolean checkInputs(){
    
        if(!jTextField_id.getText().isEmpty()){
            
            if(!txtsupplierid.getText().isEmpty()){
                
                if(!txt_price.getText().isEmpty()){
                    
                    if(!txt_warranty.getText().isEmpty()){
                        
                        if(!txt_qty.getText().isEmpty()){
                            
                            try{
                                Double.parseDouble(txt_price.getText());
                        
                                try{
                                    Integer.parseInt(txt_qty.getText());
                                    return true;
                            
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null, "Invalid Quantity Input!!!");
                                    return false;
                                }
                        
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Invalid Price Input!!!");
                                return false;
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Quantity Field cannot be Empty");
                            return false;
                        }
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Warranty Field cannot be Empty");
                        return false;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Price Field cannot be Empty");
                    return false;
                }
            }    
            else{
                 JOptionPane.showMessageDialog(null, "Supplier Field cannot be Empty");   
                 return false;
            }  
        }    
        else{
                 JOptionPane.showMessageDialog(null, "Product Field cannot be Empty");  
                 return false;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cb_products = new javax.swing.JComboBox<>();
        cb_supplier = new javax.swing.JComboBox<>();
        txt_price = new javax.swing.JTextField();
        txt_warranty = new javax.swing.JTextField();
        txt_qty = new javax.swing.JTextField();
        btn_insert = new javax.swing.JButton();
        jTextField_id = new javax.swing.JTextField();
        txtsupplierid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_validate = new javax.swing.JLabel();
        txt_validate2 = new javax.swing.JLabel();
        txt_validate1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_newProduct = new javax.swing.JButton();
        btn_newSupplier1 = new javax.swing.JButton();
        cbbasedon = new javax.swing.JComboBox<>();
        txt_validate4 = new javax.swing.JLabel();
        txt_validate5 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_Delete = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        searchTech = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("Product ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 150, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setText("Product Category");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 210, 80));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel3.setText("Supplier Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 170, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel4.setText("Supplier ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 190, 80));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel5.setText("Price / Unit");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 150, 80));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setText("Warranty Period");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 190, 80));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel7.setText("Minimum Qty/Order");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 250, 80));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, -1));

        cb_products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_productsActionPerformed(evt);
            }
        });
        jPanel1.add(cb_products, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 220, 30));

        cb_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_supplierActionPerformed(evt);
            }
        });
        jPanel1.add(cb_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 220, 30));

        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        txt_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priceKeyReleased(evt);
            }
        });
        jPanel1.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 280, 30));

        txt_warranty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_warrantyActionPerformed(evt);
            }
        });
        txt_warranty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_warrantyKeyReleased(evt);
            }
        });
        jPanel1.add(txt_warranty, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 280, 30));

        txt_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qtyActionPerformed(evt);
            }
        });
        txt_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_qtyKeyReleased(evt);
            }
        });
        jPanel1.add(txt_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 280, 30));

        btn_insert.setBackground(new java.awt.Color(0, 153, 255));
        btn_insert.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btn_insert.setForeground(new java.awt.Color(255, 255, 255));
        btn_insert.setText("ADD");
        btn_insert.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });
        jPanel1.add(btn_insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 190, -1));

        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });
        jTextField_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_idKeyReleased(evt);
            }
        });
        jPanel1.add(jTextField_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 230, 30));

        txtsupplierid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsupplieridActionPerformed(evt);
            }
        });
        txtsupplierid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsupplieridKeyReleased(evt);
            }
        });
        jPanel1.add(txtsupplierid, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 280, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel9.setText("Product Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 190, 80));

        txt_validate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_validateKeyReleased(evt);
            }
        });
        jPanel1.add(txt_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 260, 30));

        txt_validate2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_validate2KeyReleased(evt);
            }
        });
        jPanel1.add(txt_validate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 100, 20));

        txt_validate1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_validate1KeyReleased(evt);
            }
        });
        jPanel1.add(txt_validate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 20));

        jLabel8.setBackground(new java.awt.Color(102, 153, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 102));
        jLabel8.setText("ADD Supplier");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 293, 40));

        btn_newProduct.setText("New Product");
        btn_newProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newProductActionPerformed(evt);
            }
        });
        jPanel1.add(btn_newProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, 30));

        btn_newSupplier1.setText("New Supplier");
        btn_newSupplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newSupplier1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_newSupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 100, 30));

        cbbasedon.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbasedon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Please Choose--", "Tripod", "Camara", "Lighting Instruments", "Lense", "Prop", "Editing Software", "Computer", "Backdrop" }));
        cbbasedon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbasedonActionPerformed(evt);
            }
        });
        jPanel1.add(cbbasedon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 270, 30));

        txt_validate4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_validate4KeyReleased(evt);
            }
        });
        jPanel1.add(txt_validate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 260, 30));

        txt_validate5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_validate5KeyReleased(evt);
            }
        });
        jPanel1.add(txt_validate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 270, 30));

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, 190, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Category", "Suppiler ID", "Price", "Warranty", "No of quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 790, 500));

        jButton_Delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton_Delete.setForeground(new java.awt.Color(0, 0, 204));
        jButton_Delete.setText("DELETE");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, -1, -1));

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButton5.setText("SEARCH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, -1, -1));

        searchTech.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTechActionPerformed(evt);
            }
        });
        jPanel1.add(searchTech, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 16, 260, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Product Category");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        jButton4.setText("Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 620, -1, 30));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 153));
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 620, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 153));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 620, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priceKeyReleased
        String priceMin = txt_price.getText();
        String PATTERN = "^[0-9.]+$";
        Pattern pat = Pattern.compile(PATTERN);
        Matcher match = pat.matcher(priceMin);

        int i,count=0;
        for(i=0;i<priceMin.length();i++){
            if(priceMin.charAt(i)=='.')
            count++;
        }

        if(!priceMin.isEmpty()){

            if (!match.matches()) {
                txt_validate.setForeground(Color.red);
                txt_validate.setText("Price should be Numeric!!!");

            } else {
                txt_validate.setText("");

            }
            if(count>1){
                txt_validate.setForeground(Color.red);
                txt_validate.setText("Price should be Numeric!!!");
            }

        }

        if(priceMin.isEmpty()){
            txt_validate.setText("");
        }
    }//GEN-LAST:event_txt_priceKeyReleased

    private void txt_warrantyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_warrantyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_warrantyActionPerformed

    private void txt_warrantyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_warrantyKeyReleased
        String warranty = txt_warranty.getText();
        String PATTERN = "^[0-9]+$";
        Pattern pat = Pattern.compile(PATTERN);
        Matcher match = pat.matcher(warranty);

        if (!match.matches()) {
            txt_validate4.setForeground(Color.red);
            txt_validate4.setText("Warranty should be Numeric!!!");

        } else {
            txt_validate4.setText("");

        }

        if(warranty.isEmpty()){
            txt_validate4.setText("");
        }
    }//GEN-LAST:event_txt_warrantyKeyReleased

    private void txt_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtyKeyReleased
        String qty = txt_qty.getText();
        String PATTERN = "^[0-9.]+$";
        Pattern pat = Pattern.compile(PATTERN);
        Matcher match = pat.matcher(qty);

        if (!match.matches()) {
            txt_validate5.setForeground(Color.red);
            txt_validate5.setText("Quantity should be Numeric!!!");

        } else {
            txt_validate5.setText("");

        }

        if(qty.isEmpty()){
            txt_validate5.setText("");
        }
    }//GEN-LAST:event_txt_qtyKeyReleased

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
           
        
        if((jTextField_id !=null || cbbasedon!= null|| txtsupplierid !=null || txt_price!=null || txt_warranty !=null || 
                  txt_qty !=null  )){
            
            try
                  {
                
                       Connection conn = MySqlConnection();
                       String qry="insert into supplierinventory  values (?,?,?,?,?,?)";
                                               
                      PreparedStatement ps=conn.prepareStatement(qry);
                     
                      
                      ps.setString(1,jTextField_id.getText());
                     ps.setString(2,cbbasedon.getSelectedItem().toString());
                     ps.setString(3,txtsupplierid.getText());
                      ps.setInt(4, Integer.parseInt(txt_price.getText()));
                     ps.setInt(5, Integer.parseInt(txt_warranty.getText()));
                     ps.setInt(6, Integer.parseInt( txt_qty.getText()));
                     
                     
                     int res=ps.executeUpdate();
                            
                     if(res>=1)
                     {
                    
                         JOptionPane.showMessageDialog(null,res+"number of task inserted ");
                         fillTable();
                      
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
    }//GEN-LAST:event_btn_insertActionPerformed
  
    
    
    
    public void Show(int index){
   
            
          
        
        jTextField_id.setText(getRepair_ItemsList().get(index).getId());
         cbbasedon.setSelectedItem(getRepair_ItemsList().get(index).getProductcategory());  
              txtsupplierid.setText(getRepair_ItemsList().get(index).getSupplierid());
              txt_price.setText(getRepair_ItemsList().get(index).getPrice());
              txt_warranty.setText(getRepair_ItemsList().get(index).getWarranty());  
              txt_qty.setText(getRepair_ItemsList().get(index).getMinimumqty());
               
    
    
    }
    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qtyActionPerformed

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTextField_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_idKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idKeyReleased

    private void txtsupplieridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsupplieridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsupplieridActionPerformed

    private void txtsupplieridKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsupplieridKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsupplieridKeyReleased

    private void txt_validate1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_validate1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_validate1KeyReleased

    private void txt_validate2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_validate2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_validate2KeyReleased

    private void btn_newProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newProductActionPerformed
        
        new Inventory().setVisible(true);
        Inventory obj= new Inventory();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_newProductActionPerformed

    private void cb_productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_productsActionPerformed

        try {
            String pName=cb_products.getSelectedItem().toString();

            Connection conn=MySqlConnection();
            String query="SELECT * FROM product WHERE productname='"+pName+"'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String pNum=rs.getString("id");
                jTextField_id.setText(pNum.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Supplieradd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb_productsActionPerformed

    private void cb_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_supplierActionPerformed
        try {
            String sName=cb_supplier.getSelectedItem().toString();

            Connection conn=MySqlConnection();
            String query="SELECT * FROM newsupplier WHERE companyname='"+sName+"'";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String sNum=rs.getString("supplierid");
                txtsupplierid.setText(sNum.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Supplieradd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb_supplierActionPerformed

    private void btn_newSupplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newSupplier1ActionPerformed
    
         new Newsupplier().setVisible(true);
        Newsupplier obj= new Newsupplier();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_newSupplier1ActionPerformed

    private void cbbasedonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbasedonActionPerformed
            

// TODO add your handling code here:
    }//GEN-LAST:event_cbbasedonActionPerformed

    private void txt_validateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_validateKeyReleased

    }//GEN-LAST:event_txt_validateKeyReleased

    private void txt_validate4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_validate4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_validate4KeyReleased

    private void txt_validate5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_validate5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_validate5KeyReleased

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
            if(checkInputs()){
            String UpdateQuery=null;
            PreparedStatement ps= null;

             Connection conn = MySqlConnection();
           
             
            //update without image
             
              
                try{
              
                    UpdateQuery = "UPDATE supplierinventory SET Productcategory=?,supplierid=?,Price=?,Warranty=?,Minquantity=? WHERE id=?";
                    ps=conn.prepareStatement(UpdateQuery);
                    
                  //  ps.setDouble(1, Double.parseDouble(jTextField_id.getText()));
                    ps.setString(1,cbbasedon.getSelectedItem().toString());
                    ps.setString(2, txtsupplierid.getText());
                    ps.setInt(3, Integer.parseInt(txt_price.getText()));
                    ps.setInt(4, Integer.parseInt(txt_warranty.getText()));
                    ps.setInt(5, Integer.parseInt(txt_warranty.getText()));
                    ps.setString(6, jTextField_id.getText());
                    
                  
               
         
                    txt_price.setText("");
                    txt_warranty.setText(" ");
                    txt_qty.setText(" ");
                    
                         ps.executeUpdate();
                         fillTable();
                         Show_Ritems();
                   JOptionPane.showMessageDialog(null, "Successfully Updated");

                
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
            }
            
              
                     

                  
                  
               
            

        
    }//GEN-LAST:event_btnupdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
           int index = jTable1.getSelectedRow();
        Show(index);
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed

        if(!jTextField_id.getText().equals("")){
            try {
                Connection conn = MySqlConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM supplierinventory WHERE id = ?");
                String id = jTextField_id.getText();
                ps.setString(1, id);

                ps.executeUpdate();
                Show_Ritems();
                JOptionPane.showMessageDialog(null, "Item Deleted");

                        
                    //jTextField_id.setText(" ");
                    cbbasedon.setSelectedItem("");
                    txtsupplierid.setText("");
                    txt_price.setText("");
                    txt_warranty.setText(" ");
                    txt_qty.setText(" ");
                    
                //  jComboProject.setSelectedItem("");

            } catch (SQLException ex) {
                Logger.getLogger(Supplieradd.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Item Not Deleted");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No Item TO Delete ");
        }

    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if(searchTech.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Insert Product Category For Search");

        }else{

            if(!searchTech.getText().isEmpty()){

                try{
                    Connection conn = MySqlConnection();
                    PreparedStatement ps;
                    ResultSet rs;

                    String sql = "SELECT * FROM supplierinventory WHERE productcategory=?";
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        MessageFormat header = new MessageFormat("report");
        MessageFormat footer =new MessageFormat("page");

        try{

            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        }catch(Exception e){
            JOptionPane.showInternalMessageDialog(null, "unable print");

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Dashboard m1 = new Dashboard();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                Home m1 = new Home();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Supplieradd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplieradd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplieradd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplieradd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplieradd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_newProduct;
    private javax.swing.JButton btn_newSupplier1;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cb_products;
    private javax.swing.JComboBox<String> cb_supplier;
    private javax.swing.JComboBox<String> cbbasedon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField searchTech;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JLabel txt_validate;
    private javax.swing.JLabel txt_validate1;
    private javax.swing.JLabel txt_validate2;
    private javax.swing.JLabel txt_validate4;
    private javax.swing.JLabel txt_validate5;
    private javax.swing.JTextField txt_warranty;
    private javax.swing.JTextField txtsupplierid;
    // End of variables declaration//GEN-END:variables

    

   
}
