/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anu;

import java.util.Date;

/**
 *
 * @author sajeesan
 */
public class employeebean {
    
  
    private int eid;
    private String ename;
    private Date Dob;
    private String nic;
    private String address;
    
    
     public employeebean(int eid, String ename,Date Dob,String nic,String address ){
       
       this.eid=eid;
       this.ename=ename;
       this.Dob=Dob;
       this.nic=nic;
       this.address=address;
      
   }

    /**
     * @return the photo
     */
  

    /**
     * @param photo the photo to set
  

    /**
     * @return the eid
     */
    public int getEid() {
        return eid;
    }

    /**
     * @param eid the eid to set
     */
    public void setEid(int eid) {
        this.eid = eid;
    }

    /**
     * @return the ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * @param ename the ename to set
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * @return the Dob
     */
    public Date getDob() {
        return Dob;
    }

    /**
     * @param Dob the Dob to set
     */
    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

 
    
    
    
    
    
    
    
}
