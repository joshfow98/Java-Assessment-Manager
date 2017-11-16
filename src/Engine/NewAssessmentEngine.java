/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 * Adds the details stored in the form to a database.
 * @author joshf
 */
public class NewAssessmentEngine {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static String assessmentTitle, assessmentModule, assessmentDescription;
    private static java.util.Date dateDue, reminderDate;
    private static java.sql.Date sqlDateDue, sqlReminderDate;
    private static Connection con;
    private static Statement stmnt;
    private static ResultSet rs;
    private static String SQL;
    
    //assigns all the assessment info when instance of class occurs
    public NewAssessmentEngine(String assessmentTitle, String assessmentModule, String assessmentDescription, String dateDue, String reminderDate){
        
        try{
            
            if(assessmentTitle.equals("") || assessmentModule.equals("") || assessmentDescription.equals("") || dateDue.equals("") ||  reminderDate.equals("")){
                
                throw new NewAssessmentExceptions("None of the fields can be empty");
                
            }
            
            NewAssessmentEngine.assessmentTitle = assessmentTitle;
            NewAssessmentEngine.assessmentModule = assessmentModule;
            NewAssessmentEngine.assessmentDescription = assessmentDescription;
            //convert string to date to store in SQL database
        
            
            NewAssessmentEngine.dateDue = sdf.parse(dateDue);
            NewAssessmentEngine.reminderDate = sdf.parse(reminderDate);
            
            sqlDateDue = new java.sql.Date(NewAssessmentEngine.dateDue.getTime());
            sqlReminderDate = new java.sql.Date(NewAssessmentEngine.reminderDate.getTime());
            
            storeAssessment();
            
        }catch (ParseException e){
            
            e.printStackTrace();
            
        }catch (NewAssessmentExceptions e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
    }
    //stores the retrieved data in the database
    /**
     * Connects to local DB and stores assessment details entered
     * as new record.
     */
    public static void storeAssessment(){
        
        int currentID = 0;
        
        try{
            
            String host = "jdbc:derby://localhost:1527/assessments", uName = "assessments", uPass = "assessments";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stores the SQL statement to be made
            SQL = "SELECT * FROM ASSESSMENTS.ASSESSMENTS";
            //stores results of the SQL statement, in this case all records
            //from table ASSESSMENT table
            rs = stmnt.executeQuery(SQL);
            //finds last record ID to be used to create a new record ID
            while(rs.next()){
                
                //currentID = rs.getInt("assessment_id");
                
            }
            //create new row in database
            rs.moveToInsertRow();
            //add data
            rs.updateString("assessment_id", assessmentTitle + assessmentModule);
            rs.updateString("assessment_title", assessmentTitle);
            rs.updateString("assessment_module", assessmentModule);
            rs.updateString("assessment_description", assessmentDescription);
            rs.updateDate("date_due", sqlDateDue);
            rs.updateDate("reminder_date", sqlReminderDate);
            
            rs.insertRow();
            
            stmnt.close();
            rs.close();
            
        }catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
}
