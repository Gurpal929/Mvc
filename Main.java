import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.xdevapi.DatabaseObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
 public static void main(String[] args) throws SQLException, ClassNotFoundException {
  Connection con= AddDao.getConnection();
   /*  if(con != null){
         System.out.println("Database is connected");
     }*/
  AddDao ad=new AddDao();
  //ad.Save();
  ad.showNum();
 }
}
