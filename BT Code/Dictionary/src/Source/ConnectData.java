/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Monkey
 */
public class ConnectData {
    public static Connection conn ;
    public ConnectData(){
        try{
            Class.forName("org.sqlite.JDBC");
            String pathDB = System.getProperty("user.dir").concat("/Dictionary.db");
            conn = DriverManager.getConnection("jdbc:sqlite:"+pathDB);
            conn.setAutoCommit(true);
        }
        catch(Exception e){
            System.err.println(e.getClass().getName()+ ": " + e.getMessage()) ;
            System.exit(0);
        }
        System.out.println("Opened database succesfully");
    }
   public static Connection getConn(){
       return ConnectData.conn;
   }
}
