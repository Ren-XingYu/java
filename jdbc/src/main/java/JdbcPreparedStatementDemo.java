import java.sql.*;

public class JdbcPreparedStatementDemo {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://192.168.10.10:3306/ssm?useServerPrepStmts=true";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from tb_user where username = ?";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, "张三");

        ResultSet resultSet = prepareStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("username");
            System.out.println(name);
        }
    }
}
