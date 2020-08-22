package JBDCday02;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidDemo02 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection=JbdcUtilDruid.getConnection();
            System.out.println(connection);
            String sql="INSERT INTO USER VALUES (NULL,?,?);";
            ps=connection.prepareStatement(sql);
            ps.setString(1,"zjy");
            ps.setString(2,"q1m1w8n7e7");
            int count = ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JbdcUtilDruid.close(connection,ps);
        }
    }
}
