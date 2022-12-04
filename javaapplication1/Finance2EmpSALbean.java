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
public class Finance2EmpSALbean {
     
    private String Name;
    private int Eid;
    private String BasicSalary;
    private String OverTime;
    private String WorkingDays;
    private String RatePerHours;
    private String Bonus;
    private String Total;

     
    
    
    public Finance2EmpSALbean( String Name,int Eid,  String BasicSalary, String OverTime,String WorkingDays, String RatePerHours,  String Bonus,String Total )
{
        this.Name=Name;
        this.Eid=Eid;
        this.BasicSalary=BasicSalary;
        this.OverTime=OverTime;
        this.WorkingDays=WorkingDays;
        this.RatePerHours=RatePerHours;
        this.Bonus=Bonus;
        this.Total=Total;
        
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Eid
     */
    public int getEid() {
        return Eid;
    }

    /**
     * @param Eid the Eid to set
     */
    public void setEid(int Eid) {
        this.Eid = Eid;
    }

    /**
     * @return the BasicSalary
     */
    public String getBasicSalary() {
        return BasicSalary;
    }

    /**
     * @param BasicSalary the BasicSalary to set
     */
    public void setBasicSalary(String BasicSalary) {
        this.BasicSalary = BasicSalary;
    }

    /**
     * @return the OverTime
     */
    public String getOverTime() {
        return OverTime;
    }

    /**
     * @param OverTime the OverTime to set
     */
    public void setOverTime(String OverTime) {
        this.OverTime = OverTime;
    }

    /**
     * @return the WorkingDays
     */
    public String getWorkingDays() {
        return WorkingDays;
    }

    /**
     * @param WorkingDays the WorkingDays to set
     */
    public void setWorkingDays(String WorkingDays) {
        this.WorkingDays = WorkingDays;
    }

    /**
     * @return the RatePerHours
     */
    public String getRatePerHours() {
        return RatePerHours;
    }

    /**
     * @param RatePerHours the RatePerHours to set
     */
    public void setRatePerHours(String RatePerHours) {
        this.RatePerHours = RatePerHours;
    }

    /**
     * @return the Bonus
     */
    public String getBonus() {
        return Bonus;
    }

    /**
     * @param Bonus the Bonus to set
     */
    public void setBonus(String Bonus) {
        this.Bonus = Bonus;
    }

    /**
     * @return the Total
     */
    public String getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(String Total) {
        this.Total = Total;
    }

    
    
}
