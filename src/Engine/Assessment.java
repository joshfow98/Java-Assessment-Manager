/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.sql.Date;

/**
 *
 * @author joshf
 */
public class Assessment {
    
    public int assessmentID;
    public String assessmentTitle;
    public String assessmentModule;
    public String assessmentDescription;
    public Date dateDue;
    public Date reminderDate;
    
    /*public Assessment(String assessmentTitle, String assessmentModule, String assessmentDescription, Date dateDue, Date reminderDate){
        
        this.assessmentTitle = assessmentTitle;
        this.assessmentModule = assessmentModule;
        this.assessmentDescription = assessmentDescription;
        this.dateDue = dateDue;
        
        
    }*/
    
}
