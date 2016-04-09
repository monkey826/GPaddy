//package Source;
//import java.sql.*;
//
//public class SQLiteJDBC
//{
//  public static void main( String args[] )
//  {
//    Connection c = null;
//    Statement stmt = null;
//    try {
//      Class.forName("org.sqlite.JDBC");
//      c = DriverManager.getConnection("jdbc:sqlite:dictionary.db");
//      System.out.println("Opened database successfully");
//
//      stmt = c.createStatement();
//      String sql = "CREATE TABLE Dictionary " +
//                   " word           TEXT NOT NULL, " + 
//                   " Meanning       Text    NOT NULL )" ; 
//                   
//      stmt.executeUpdate(sql);
//      stmt.close();
//      c.close();
//    } catch ( Exception e ) {
//      e.printStackTrace();
//    }
//    System.out.println("Table created successfully");
//  }
//}