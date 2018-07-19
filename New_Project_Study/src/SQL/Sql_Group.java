package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_Group {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * писать много executeUpdate-это немножко долго и плохо.Можно запихнуть все в один xml и потом выполнить сразу
         * это называется накатить группой.
         */
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Simple_Servlets.Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password);
            Statement statement = connection.createStatement()){
            statement.addBatch("insert into books (name) values ('New world')");
            statement.addBatch("insert into books (name) values ('West World')");
            statement.addBatch("insert into books (name) values ('American Gods')");
            statement.executeBatch();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
