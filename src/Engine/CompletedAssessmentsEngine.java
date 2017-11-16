/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import static Engine.CurrentAssessmentsEngine.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author joshf
 */
public class CompletedAssessmentsEngine {
    
    static Connection con;
    static Statement stmnt;
    static String SQL;
    static ResultSet rs;
    
    public static String[] addIDs(){
       
        //con = getConnection();
        int currentRecordNumber = 0, i = 0;
        String[] assessmentID = new String[0];
        
        try{
            
            String host = "jdbc:derby://localhost:1527/assessments", uName = "assessments", uPass = "assessments";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQL = "SELECT assessment_id FROM ASSESSMENTS.COMPLETED_ASSESSMENTS";
            rs = stmnt.executeQuery(SQL);
            
            while(rs.next()){
                
                assessmentID = Arrays.copyOf(assessmentID, assessmentID.length + 1);
                assessmentID[i] = rs.getString("assessment_id");
                //System.out.println(rs.getString("assessment_id"));
                i ++;
                
            }
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
           
        return assessmentID;
        
    }
    
    public static Engine.Assessment getRecord(String assessmentID){
       
        //con = getConnection();
        Engine.Assessment a = new Engine.Assessment();
        
        try{
            
            String host = "jdbc:derby://localhost:1527/assessments", uName = "assessments", uPass = "assessments";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM ASSESSMENTS.COMPLETED_ASSESSMENTS WHERE assessment_id='" + assessmentID + "'";
            rs = stmnt.executeQuery(SQL);
            
            rs.next();
           
            a.setID(rs.getString("assessment_id"));
            a.setTitle(rs.getString("assessment_title"));
            a.setModule(rs.getString("assessment_module"));
            a.setDescription(rs.getString("assessment_description"));
            a.setDue(rs.getDate("date_due"));
            a.setDate(rs.getDate("reminder_date"));
            
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
       return  a;
       
    }
    
    public static void assessmentUncompleted(String assessmentID){
        
        try{
            String host = "jdbc:derby://localhost:1527/assessments", uName = "assessments", uPass = "assessments";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement();
            SQL = "INSERT INTO ASSESSMENTS.ASSESSMENTS SELECT * FROM ASSESSMENTS.COMPLETED_ASSESSMENTS WHERE assessment_id='" 
                    + assessmentID + "'";
            stmnt.executeUpdate(SQL);
            SQL = "DELETE FROM ASSESSMENTS.COMPLETED_ASSESSMENTS WHERE assessment_id ='" + assessmentID + "'";
            stmnt.executeUpdate(SQL);
            
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
}
