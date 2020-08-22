package JBDCday01;
import java.sql.*;
import java.util.Scanner;
public class DemoLoginDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String name=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        login(name,password);

    }

    private static void login(String name, String password) {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = JdbcUtils.getConnection();

            statement=connection.createStatement();

            String sql="select * from user where name='"+name+"' and password='"+password+"'";
            System.out.println(sql);
            rs=statement.executeQuery(sql);
            if(rs.next()){
                System.out.println("登录成功，欢迎您：" + name);
            }else {
                System.out.println("登录失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection,statement,rs);
        }
    }
}
