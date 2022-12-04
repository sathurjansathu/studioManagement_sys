/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anu;

/**
 *
 * @author sajeesan
 */
public class salaryBean {
    
    private int eid;
    private String name;
    private String BasicSalary;
    private String OverTime;
    private String WorkingDays;
    private String RatePerHours;
    private String Bonus;
    
    
    public salaryBean(int eid, String name,  String BasicSalary, String OverTime,String WorkingDays, String RatePerHours,  String Bonus )
    {
        this.eid=eid;
        this.name=name;
        this.BasicSalary=BasicSalary;
        this.OverTime=OverTime;
        this.WorkingDays=WorkingDays;
        this.RatePerHours=RatePerHours;
        this.Bonus=Bonus;
        
      
    
    }   

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





}
