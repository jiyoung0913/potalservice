
package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public kr.ac.jejunu.User findById(Integer id) throws ClassNotFoundException, SQLException {
        //데이터 어딨어? => mysql
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/portal?" +
                                "characterEncoding=utf-8&serverTimezone=UTC"
                        ,"root","koko4019"
                );
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from  userinfo where id = ?"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        kr.ac.jejunu.User user = new kr.ac.jejunu.User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }
}

