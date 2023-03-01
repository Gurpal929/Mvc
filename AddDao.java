import java.sql.*;


public class AddDao {
    int status=0;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://root:Root@localhost:3306/add_numbers");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public int Save() {

        try {
            Connection con = AddDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into new_table(Numbers,Number1,Number2) values(?,?,?)");

            ps.setInt(1, 2);
            ps.setInt(2, 40);
            ps.setInt(3, 50);
            status = ps.executeUpdate();
            System.out.println(status);
            System.out.println("Record saved");
            con.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return status;
    }

    public int showNum() {
        try {
            Connection con = AddDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from new_table");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Numbers = rs.getInt("Numbers");
                int Number1 = rs.getInt("Number1");
                int Number2 = rs.getInt("Number2");
                System.out.println(Numbers + "\t\t" + Number1 + "\t\t " + Number2);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Delete() {
        try {
            Connection con = AddDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from new_table where Numbers=?");
            int Numbers = 0;
            ps.setInt(1, 2);
             status = ps.executeUpdate();
            System.out.println(status);
            System.out.println("Record Deleted");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update() {
        int Numbers=0;

        try {
            Connection con = AddDao.getConnection();
            PreparedStatement ps = con.prepareStatement("" +
                    "update new_table set Number1=?,Number2=? where Numbers=?");
            ps.setInt(1,12);
            ps.setInt(2,13);
            ps.setInt(3,1);
            status=ps.executeUpdate();
            System.out.println(status);
            System.out.println("Record updated");
            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
