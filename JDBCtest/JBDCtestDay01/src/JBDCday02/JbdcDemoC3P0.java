package JBDCday02;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JbdcDemoC3P0 {
    public static void main(String[] args) throws SQLException {
        DataSource ds=new ComboPooledDataSource();
        Connection connection=ds.getConnection();

        System.out.println(connection);
        connection.close();

        for (int i = 0; i < 10; i++) {
            Connection connection1=ds.getConnection();
        }
    }
}
