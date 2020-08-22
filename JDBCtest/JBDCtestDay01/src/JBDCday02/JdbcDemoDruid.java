package JBDCday02;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class JdbcDemoDruid {
    public static void main(String[] args) throws Exception {

        Properties pro=new Properties();
        pro.load(JdbcDemoDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection connection=ds.getConnection();
        System.out.println(connection);
    }
}
