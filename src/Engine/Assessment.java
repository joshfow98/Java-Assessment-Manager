/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.sql.Date;

/**
 *This stores data about an assessment.
 * @author joshf
 */
public class Assessment {
    
    private int assessmentID;
    private String assessmentTitle;
    private String assessmentModule;
    private String assessmentDescription;
    private Date dateDue;
    private Date reminderDate;
    
   /* public Assessment(int assessmentID, String assessmentTitle, String assessmentModule, String assessmentDescription, Date dateDue, Date reminderDate){
        
        this.assessmentID = assessmentID;
        this.assessmentTitle = assessmentTitle;
        this.assessmentModule = assessmentModule;
        this.assessmentDescription = assessmentDescription;
        this.dateDue = dateDue;
        this.reminderDate = reminderDate;
        
    }*/
    /**
     * This sets the assessment ID.
     * @param ID 
     */
    public void setID(int ID){
        
        assessmentID =ID;
        
    }
    /**
     * This sets the title of the assessment.
     * @param title 
     */
    public void setTitle(String title){
        
        assessmentTitle = title;
        
    }
    /**
     * This sets the module the assessment is for.
     * @param module 
     */
    public void setModule(String module){
        
        assessmentModule = module;
        
    }
    /**
     * This sets the description of the assessment.
     * @param description 
     */
    public void setDescription(String description){
        
        assessmentDescription = description;
        
    }
    /**
     * This sets the date the assessment is due.
     * @param due 
     */
    public void setDue(Date due){
        
        dateDue = due;
        
    }
    /**
     * This sets the date that the user is to be reminded.
     * @param date 
     */
    public void setDate(Date date){
        
        reminderDate = date;
        
    }
    /**
     * This returns the assessment ID.
     * @return 
     */
    public int getID(){
        
        return assessmentID;
        
    }
    /**
     * This returns the title of the assessment.
     * @return 
     */
    public String getTitle(){
        
        return assessmentTitle;
        
    }
    /**
     * This returns the module the assessment is for.
     * @return 
     */
    public String getModule(){
        
        return assessmentModule;
        
    }
    /**
     * This returns a description of the assessment.
     * @return 
     */
    public String getDescription(){
        
        return assessmentDescription;
        
    }
    /**
     * This returns the date that the assessment is due.
     * @return 
     */
    public Date getDue(){
        
        return dateDue;
        
    }
    /**
     * This returns the date that the user is to be reminded.
     * @return 
     */
    public Date getDate(){
        
        return reminderDate;
        
    }
    
    
}
