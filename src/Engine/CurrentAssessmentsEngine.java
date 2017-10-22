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
    /**
     * retrieve the ID's for each assessment to put output to be output 
     * to the 
     * */
    public static int[] addIDs(){
       
        int currentRecordNumber = 0, i = 0;
        Assessment[] a = new Assessment[0];
        int[] assessmentIDs = new int[0];
        
        try{
            
            rs.beforeFirst();
            
            while(rs.next()){
                
                assessmentIDs = Arrays.copyOf(assessmentIDs, assessmentIDs.length + 1);
                assessmentIDs[i] = rs.getInt("assessment_id");
          
                i += 1;
                
            }
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
           
        return assessmentIDs;
        
    }
    
    public static int arraySize(){
        
        Connection con;
        Statement stmnt;
        String SQL;
        int currentRecordNumber = -1;
        String host = "jdbc:derby://localhost:1527/assessments", uName = "assessments", uPass = "assessments";
        
        try{
            
            con = DriverManager.getConnection(host, uName, uPass);
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stores the SQL statement to be made
            SQL = "SELECT * FROM ASSESMENTS.ASSESMENT";
            //stores results of the SQL statement, in this case all records
            //from table ASSESSMENT table
            rs = stmnt.executeQuery(SQL);
            
            while(rs.next()){
                
                currentRecordNumber += 1;
                
            }
            
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return currentRecordNumber;
        
    }
    
    public static Engine.Assessment getRecord(int assessmentID){
        
        //Engine.Assessment record = new Engine.Assessment();
        boolean foundRecord = false;
        int i = -1;
        
        while(foundRecord == false || i < a.length - 1){
            
            i++;
            
            if(a[i].assessmentID == assessmentID){
                
                foundRecord = true;
               
            }
            
        }
        
       return  a[i];
       
    }
   /* public static Assessment getRecord(){
        
        
        
        Assessment a = new Assessment();
        
        return Assessment;
        
    }*/
}
