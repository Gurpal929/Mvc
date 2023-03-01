import java.sql.Connection;
import java.sql.SQLException;

public class Main {
 public static void main(String[] args) throws SQLException, ClassNotFoundException {
  Connection con=AddDao.getConnection();
////    if(con != null){
//         System.out.println("Database is connected");
//     }
     try {


         // Check if the connection is null
         if (con == null) {
             System.out.println("No connection to the database");
         }
         // Check if the connection is closed
         else if (con.isClosed()) {
             System.out.println("Connection to the database is closed");
         }
         else {
             System.out.println("Connection to the database is active");
         }
     } catch (SQLException e) {
         e.printStackTrace();
     } finally {
         try {
             // Close the connection
             if (con != null && !con.isClosed()) {
                 con.close();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }
}



