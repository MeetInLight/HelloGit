package JBDCday01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 使用 PreparedStatement
 */
public class DemoLoginDemo02 {
    //从控制台上输入的用户名和密码
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        login(name, password);
    }
    /**
     * 登录的方法
     * @param name
    17 / 21
     * @param password
     */
    private static void login(String name, String password) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        //写成登录 SQL 语句，没有单引号
        String sql = "select * from user where name=? and password=?";
        //得到语句对象
        PreparedStatement ps = connection.prepareStatement(sql);
        //设置参数
        ps.setString(1, name);
        ps.setString(2,password);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功：" + name);
        }
        else {
            System.out.println("登录失败");
        }
        //释放资源,子接口直接给父接口
        JdbcUtils.close(connection,ps,resultSet);
    }
}