/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author sathu
 */
public class Finance3CustomerInBean {
    
   
    private String customerid;
    private String workinghours;
    private String date;
    private String cost;
    private String payment;
    
    public Finance3CustomerInBean( String customerid,String date, String workinghours, String cost, String payment){
    
   
    this.customerid=customerid;
    this.workinghours=workinghours;
    this.date=date;
    this.cost=cost;
    this.payment=payment;
            }

    /**
     * @return the customerid
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * @param customerid the customerid to set
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    /**
     * @return the workinghours
     */
    public String getWorkinghours() {
        return workinghours;
    }

    /**
     * @param workinghours the workinghours to set
     */
    public void setWorkinghours(String workinghours) {
        this.workinghours = workinghours;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * @return the payment
     */
    public String getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    

    
}
