package JBDCday01;

import java.sql.*;

public class JdbcUtils {
    private static final String USER="root";
    private static final String PWD="root";
    private static final String URL="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT%2B8";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    //1) 使用用户名、密码、URL 得到连接对象
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL,USER,PWD);
    }

    public static void close(Connection conn, Statement stmt){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn,stmt);
    }
}
