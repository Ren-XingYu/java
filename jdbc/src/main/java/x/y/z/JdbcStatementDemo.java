package x.y.z;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class JdbcStatementDemo {
    public static void main(String[] args) throws Exception {
        Connection connection = null;

        try {

            // 1、注册驱动(通过SPI自动注册)
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // 2、获取链接
            String url = "jdbc:mysql://192.168.10.10:3306/ssm";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);

            // 手动事务
            connection.setAutoCommit(false);

            // 3、定义SQL
            String sql = "select * from tb_user where username='张三'";

            // 4、获取执行SQL的对象
            Statement statement = connection.createStatement();

            // 5、执行SQL
            ResultSet resultSet = statement.executeQuery(sql);
            // int count = statement.executeUpdate(sql);

            // 6、打印结果
            while (resultSet.next()) {
                String name = resultSet.getString("username");
                System.out.println(name);
            }

            // 提交事务
            connection.commit();
        } catch (Exception ex) {
            if (Objects.nonNull(connection)) {
                // 发送异常回滚事务
                connection.rollback();
            }
        }
    }
}
