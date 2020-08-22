package JBDCday01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransationDemo {
    //没有异常，提交事务，出现异常回滚事务
    public static void main(String[] args) {
        //1) 注册驱动
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //2) 获取连接
            connection = JdbcUtils.getConnection();


            //3) 开启事务
            connection.setAutoCommit(false);



            //4) 获取到 PreparedStatement
            //从 jack 扣钱
            ps = connection.prepareStatement("update account set balance = balance - ? where name=?");
            ps.setInt(1, 500);
            ps.setString(2,"Jack");
            ps.executeUpdate();
            //出现异常
            System.out.println(100 / 0);
            //给 rose 加钱
            ps = connection.prepareStatement("update account set balance = balance + ? where name=?");
            ps.setInt(1, 500);
            ps.setString(2,"Rose");
            ps.executeUpdate();
            //提交事务
            connection.commit();
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //事务的回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("转账失败");
        }
        finally {
            //7) 关闭资源
            JdbcUtils.close(connection,ps);
        }
    }
}

