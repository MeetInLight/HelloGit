package JBDCday01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdomo01 {
    public static void main(String[] args) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT%2B8";
        //1) 使用用户名、密码、URL 得到连接对象
        //Connection connection = DriverManager.getConnection(url, "root", "root");
        //com.mysql.jdbc.JDBC4Connection@68de145
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, "root", "root");
            //2. 通过连接对象得到语句对象
            statement = conn.createStatement();
            //3. 通过语句对象发送 SQL 语句给服务器
            //4. 执行 SQL
            statement.executeUpdate("create table student (id int PRIMARY key auto_increment, " +
                    "name varchar(20) not null, gender boolean, birthday date)");
            //5. 返回影响行数(DDL 没有返回值)
            System.out.println("创建表成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //6. 释放资源
        finally {
            //关闭之前要先判断
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
