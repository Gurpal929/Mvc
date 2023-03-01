import java.sql.*;


public class AddDao {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://root:Root@localhost:3306/add_numbers");

        } catch (Exception e) {System.out.println(e);}
        return con;
    }
    public  int Save(){
        int status = 0;
        try{
            Connection con=AddDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into new_table(Numbers,Number1,Number2) values(?,?,?)");

            ps.setInt(1,4);
            ps.setInt(2,5);
            ps.setInt(3,6);
            status= ps.executeUpdate();

            System.out.println(status);
        }catch (Exception exception){exception.printStackTrace();}
        return status;
    }
    public  int showNum(){
        try {
            Connection con=AddDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from new_table");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int Numbers=rs.getInt("Numbers");
                int Number1=rs.getInt("Number1");
                int Number2=rs.getInt("Number2");
                System.out.println(Numbers+"\t\t"+Number1+"\t\t "+Number2);
            }
        } catch (Exception e) {e.printStackTrace();}
        return 0;
    }

}
