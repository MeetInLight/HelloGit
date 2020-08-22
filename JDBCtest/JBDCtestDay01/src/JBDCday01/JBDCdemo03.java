package JBDCday01;

import java.sql.*;

public class JBDCdemo03 {
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
            //3) 执行 SQL 语句得到结果集 ResultSet 对象
            ResultSet rs = statement.executeQuery("select * from student");
            //4) 循环遍历取出每一条记录
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                Date birthday = rs.getDate("birthday");
                //5) 输出的控制台上
                System.out.println("编号：" + id + ", 姓名：" + name + ", 性别：" + gender + ", 生日：" +
                        birthday);
            }
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
