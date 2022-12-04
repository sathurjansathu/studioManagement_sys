package Interface;

public class SupplierClass 
{
    private String supplierid;
    private String companyname;
    private String address;
    private String email;
    private int contactno;
    
    public SupplierClass()
    {
        
    }
    
    public SupplierClass(String supplierid, String companyname, String address, String email, int contactno)
    {
        this.supplierid = supplierid;
        this.companyname = companyname;
        this.address = address;
        this.email = email;
        this.contactno = contactno;
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
     * @return the companyname
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * @param companyname the companyname to set
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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
     * @return the contactno
     */
    public int getContactno() {
        return contactno;
    }

    /**
     * @param contactno the contactno to set
     */
    public void setContactno(int contactno) {
        this.contactno = contactno;
    }
    

}
