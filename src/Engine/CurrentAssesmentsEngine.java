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
import assesment.manager.UI.CurrentAssesments;
/**
 *
 * @author joshf
 */
public class CurrentAssesmentsEngine {
    
    static ResultSet rs;
    /**
     * access' assesment database, returns array with title of each assesment
     * */
    public static Assesment[] addTitles(){
       
        int currentRecordNumber = 0, index = 0;
        Assesment[] a = new Assesment[0];
        
        try{
            
            rs.beforeFirst();
            
            while(rs.next()){
                
                a = Arrays.copyOf(a, a.length + 1);
                a[index] = new Assesment();
                a[index].assesmentID = rs.getInt("assesment_id");
                a[index].assesmentTitle = rs.getString("assesment_title");
                a[index].assesmentModule = rs.getString("assesment_module");
                a[index].assesmentDescription = rs.getString("assesment_description");
                a[index].dateDue = rs.getDate("date_due");
                a[index].reminderDate = rs.getDate("reminder_date");
          
                index += 1;
                
            }
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
           
        return a;
        
    }
    
    public static int arraySize(){
        
        Connection con;
        Statement stmnt;
        String SQL;
        int currentRecordNumber = -1;
        
        String host = "jdbc:derby://localhost:1527/assesments", uName = "assesments", uPass = "assesments";
        try{
            
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //stores the SQL statement to be made
            SQL = "SELECT * FROM ASSESMENTS.ASSESMENT";
            //stores results of the SQL statement, in this case all records
            //from table ASSESMENT table
            rs = stmnt.executeQuery(SQL);
            
            while(rs.next()){
                
                currentRecordNumber += 1;
                
            }
            
            
        } catch (SQLException err){
            
            System.out.println(err.getMessage());
            
        }
        
        return currentRecordNumber;
        
    }
    public static Engine.Assesment getRecord(int assesmentID){
        
        //Engine.Assesment record = new Engine.Assesment();
        boolean foundRecord = false;
        int i = -1;
        
        while(foundRecord == false || i < a.length - 1){
            
            i++;
            
            if(a[i].assesmentID == assesmentID){
                
                foundRecord = true;
               
            }
            
        }
        
       return  a[i];
       
    }
   /* public static Assesment getRecord(){
        
        
        
        Assesment a = new Assesment();
        
        return Assesment;
        
    }*/
}
