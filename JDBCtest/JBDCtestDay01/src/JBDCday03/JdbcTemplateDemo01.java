package JBDCday03;

import JBDCday02.JbdcUtilDruid;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate template=new JdbcTemplate(JbdcUtilDruid.getDataSource());
        System.out.println(template);
        String sql="update user set password = '13726190049' where name =?";
        int count=template.update(sql,"zjy");
        System.out.println(count);

    }
}
