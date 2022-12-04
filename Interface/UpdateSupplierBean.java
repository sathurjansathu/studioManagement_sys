/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author sathu
 */
public class UpdateSupplierBean {
    private String id;
    private String productcategory;
    private String supplierid;
    private String price; 
    private String warranty;
    private String minimumqty;



            
    public UpdateSupplierBean( String id,String productcategory,String supplierid,String price, 
                               String warranty, String minimumqty){
        
       this.id=id;
    this.productcategory=productcategory;
    this.supplierid=supplierid;
    this.price=price; 
    this.warranty=warranty;
      this.minimumqty=minimumqty;
               
                                        
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
     * @return the productcategory
     */
    public String getProductcategory() {
        return productcategory;
    }

    /**
     * @param productcategory the productcategory to set
     */
    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }

    /**
     * @return the supplierid
     */
    public String getSupplierid() {
        return supplierid;
    }

    /**
     * @param supplierid the supplierid to set
     */
    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the warranty
     */
    public String getWarranty() {
        return warranty;
    }

    /**
     * @param warranty the warranty to set
     */
    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    /**
     * @return the minimumqty
     */
    public String getMinimumqty() {
        return minimumqty;
    }

    /**
     * @param minimumqty the minimumqty to set
     */
    public void setMinimumqty(String minimumqty) {
        this.minimumqty = minimumqty;
    }

  
}
