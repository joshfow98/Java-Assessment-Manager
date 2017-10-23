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
/**
 *
 * @author joshf
 */
public class NewAssesmentEngine {
    
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static String assesmentTitle, assesmentModule, assesmentDescription;
    static java.util.Date dateDue, reminderDate;
    static java.sql.Date sqlDateDue, sqlReminderDate;
    static Connection con;
    static Statement stmnt;
    static ResultSet rs;
    static String SQL;
    //assigns all the assesment info when instance of class occurs
    public NewAssesmentEngine(String assesmentTitle, String assesmentModule, String assesmentDescription, String dateDue, String reminderDate){
        
        NewAssesmentEngine.assesmentTitle = assesmentTitle;
        NewAssesmentEngine.assesmentModule = assesmentModule;
        NewAssesmentEngine.assesmentDescription = assesmentDescription;
        //convert string to date to store in SQL database
        try{
            
            NewAssesmentEngine.dateDue = sdf.parse(dateDue);
            NewAssesmentEngine.reminderDate = sdf.parse(reminderDate);
            
            sqlDateDue = new java.sql.Date(NewAssesmentEngine.dateDue.getTime());
            sqlReminderDate = new java.sql.Date(NewAssesmentEngine.reminderDate.getTime());
            
        }catch (ParseException e){
            
            e.printStackTrace();
            
        }
    }
    //stores the retrieved data in the database
    public static void storeAssesment(){
        
        int currentID = 0;
        
        try{
            
            String host = "jdbc:derby://localhost:1527/assesments", uName = "assesments", uPass = "assesments";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stores the SQL statement to be made
            SQL = "SELECT * FROM ASSESMENTS.ASSESMENT";
            //stores results of the SQL statement, in this case all records
            //from table ASSESMENT table
            rs = stmnt.executeQuery(SQL);
            //finds last record ID to be used to create a new record ID
            while(rs.next()){
                
                currentID += 1;
                
            }
            //create new row in database
            rs.moveToInsertRow();
            //add data
            rs.updateInt("assesment_id", currentID + 1);
            rs.updateString("assesment_title", assesmentTitle);
            rs.updateString("assesment_module", assesmentModule);
            rs.updateString("assesment_description", assesmentDescription);
            rs.updateDate("date_due", sqlDateDue);
            rs.updateDate("reminder_date", sqlReminderDate);
            
            rs.insertRow();
            
            stmnt.close();
            rs.close();
            //Reloads the Statement and ResultSet
            stmnt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM ASSESMENTS.ASSESMENT";
            rs = stmnt.executeQuery(SQL);
            
        }catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
}
