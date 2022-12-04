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
public class Finance5SupplierpayBean {
    
    private String Suppliername;
    private String Supplierid;
    private String Price;
    private String Warranty;
    private String noOfQuantity;
    private String TotalAmount;
    
    
    public Finance5SupplierpayBean (String Suppliername,String Supplierid,String Price,String Warranty,String noOfQuantity,String TotalAmount){
            
        this.Suppliername=Suppliername;
        this.Supplierid=Supplierid;
        this.Price=Price;
        this.Warranty=Warranty;
        this.noOfQuantity=noOfQuantity;
        this.TotalAmount=TotalAmount;
    }

    /**
     * @return the Suppliername
     */
    public String getSuppliername() {
        return Suppliername;
    }

    /**
     * @param Suppliername the Suppliername to set
     */
    public void setSuppliername(String Suppliername) {
        this.Suppliername = Suppliername;
    }

    /**
     * @return the Supplierid
     */
    public String getSupplierid() {
        return Supplierid;
    }

    /**
     * @param Supplierid the Supplierid to set
     */
    public void setSupplierid(String Supplierid) {
        this.Supplierid = Supplierid;
    }

    /**
     * @return the Price
     */
    public String getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(String Price) {
        this.Price = Price;
    }

    /**
     * @return the Warranty
     */
    public String getWarranty() {
        return Warranty;
    }

    /**
     * @param Warranty the Warranty to set
     */
    public void setWarranty(String Warranty) {
        this.Warranty = Warranty;
    }

    /**
     * @return the noOfQuantity
     */
    public String getNoOfQuantity() {
        return noOfQuantity;
    }

    /**
     * @param noOfQuantity the noOfQuantity to set
     */
    public void setNoOfQuantity(String noOfQuantity) {
        this.noOfQuantity = noOfQuantity;
    }

    /**
     * @return the TotalAmount
     */
    public String getTotalAmount() {
        return TotalAmount;
    }

    /**
     * @param TotalAmount the TotalAmount to set
     */
    public void setTotalAmount(String TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

   
    
}
