/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerManagement;

/**
 *
 * @author sathu
 */
public class AddCustomerBean {
    private String id;
    private String name;
    private String nicnumber;
    private String address;
    private String email;
    private int contectnumber;
    private String category;


    
    public AddCustomerBean(String id,String name,String nicnumber,String address,String email,int contectnumber,String category){
    
        this.name=name;
        this.id=id;
        this.nicnumber=nicnumber;
        this.address=address;
        this.email=email;
        this.contectnumber=contectnumber;
        this.category=category;
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nicnumber
     */
    public String getNicnumber() {
        return nicnumber;
    }

    /**
     * @param nicnumber the nicnumber to set
     */
    public void setNicnumber(String nicnumber) {
        this.nicnumber = nicnumber;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contectnumber
     */
    public int getContectnumber() {
        return contectnumber;
    }

    /**
     * @param contectnumber the contectnumber to set
     */
    public void setContectnumber(int contectnumber) {
        this.contectnumber = contectnumber;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }



}
