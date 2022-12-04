/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Baga
 */
public class MyConnection  {

    static String hostName = "127.0.0.1";
  //  static String userName = "root";
   // static String passWord = "Sathu@0096";
    static String port = "3306";
    static String dataBase = "new_inventory";
    static Connection con;

    public static void getConnection() {
        try {
            String url = "jdbc:mysql://" + hostName + ":" + port + "/" + dataBase;

            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url/*, userName, passWord*/);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static int sendQuery(String query) {
        if (con == null) {
            getConnection();
        }
        try {

            Statement st1 = con.createStatement();
            st1.executeUpdate(query);
             return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;   
        }
    }

    public static ResultSet getData(String query) {
        ResultSet rs = null;

        try {
            if (con == null) {
                getConnection();
            }
            
            Statement st2 = con.createStatement();
            rs = st2.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
