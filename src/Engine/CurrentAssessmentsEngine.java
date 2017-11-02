/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import assesment.manager.UI.CurrentAssessments;
/**
 *
 * @author joshf
 */
public class CurrentAssessmentsEngine {
    
    static ResultSet rs;
    static Connection con;
    static Statement stmnt;
    static String SQL;
    /**
     * retrieve the ID's for each assessment to put output to be output 
     * to the 
     * */
    public static Connection getConnection(){
        
       try{
           
           String host = "jdbc:derby://localhost:1527/assessments", uName = "assessments", uPass = "assessments";
           con = DriverManager.getConnection(host, uName, uPass); 
      
       }catch (SQLException err){
           
           System.out.println(err.getMessage());
           
       }
       
       return con;
       
    }
    
    public static int[] addIDs(){
       
        con = getConnection();
        int currentRecordNumber = 0, i = 0;
        int[] assessmentID = new int[0];
        
        try{
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQL = "SELECT assessment_id FROM ASSESSMENTS.ASSESSMENTS";
            rs = stmnt.executeQuery(SQL);
            
            while(rs.next()){
                
                assessmentID = Arrays.copyOf(assessmentID, assessmentID.length + 1);
                assessmentID[i] = rs.getInt("assessment_id");

                i += 1;
                
            }
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
           
        return assessmentID;
        
    }
    
    public static int arraySize(){
        
        con = getConnection();
        int currentRecordNumber = 0;
        
        try{
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQL = "SELECT COUNT(*) FROM ASSESSMENTS.ASSESSMENTS";
            rs = stmnt.executeQuery(SQL);
            
            rs.next();
            
            currentRecordNumber = rs.getInt(1);
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return currentRecordNumber;
        
    }
    
    public static Engine.Assessment getRecord(int assessmentID){
       
        con = getConnection();
        Engine.Assessment a = new Engine.Assessment();
        
        try{
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM ASSESSMENTS.ASSESSMENTS WHERE assessment_id=" + assessmentID;
            rs = stmnt.executeQuery(SQL);
            
            rs.next();
           
            a.setID(rs.getInt("assessment_id"));
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
    
    public static void updateRecord(Engine.Assessment a){
        
        con = getConnection();
        
        try{
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            SQL = "SELECT * FROM ASSESSMENTS.ASSESSMENTS WHERE assessment_id=" + a.getID();
            rs = stmnt.executeQuery(SQL);
            
            rs.next();
            
            rs.updateInt("assessment_id", a.getID());
            rs.updateString("assessment_title", a.getTitle());
            rs.updateString("assessment_module", a.getModule());
            rs.updateString("assessment_description", a.getDescription());
            rs.updateDate("date_due", a.getDue());
            rs.updateDate("reminder_date", a.getDate());
            rs.updateRow();
            
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
    public static void assessmentCompleted(int assessmentID){
        
        con = getConnection();
        Engine.Assessment record = new Engine.Assessment();
        
        try{
            
            stmnt = con.createStatement();
           /* SQL = "INSERT INTO ASSESSMENTS.COMPLETED_ASSESSMENTS(assessment_id,assessment_title,"
                    + "assessment_module,assessment_description,date_due,reminder_date)"
                    + " SELECT (assessment_id,assessment_title,"
                    + "assessment_module,assessment_description,date_due,reminder_date) "
                    + "FROM ASSESSMENTS.ASSESSMENTS WHERE assessment_id=" + assessmentID;*/
            SQL = "INSERT INTO ASSESSMENTS.COMPLETED_ASSESSMENTS SELECT * FROM ASSESSMENTS.ASSESSMENTS WHERE assessment_id=" + assessmentID;
            stmnt.executeUpdate(SQL);
            
            SQL = "DELETE FROM ASSESSMENTS.ASSESSMENTS WHERE assessment_id =" + assessmentID;
            stmnt.executeUpdate(SQL);
           
            rs.close();
            stmnt.close();
            con.close();
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
    }
    
}
