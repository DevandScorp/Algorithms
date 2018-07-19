package SQL;

import java.sql.*;

public class Sql_Tutuorials {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Simple_Servlets.Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        /**
         * NOT NULL - Ensures that a column cannot have a NULL value
         * UNIQUE - Ensures that all values in a column are different
         * PRIMARY KEY - A combination of a NOT NULL and UNIQUE. Uniquely identifies each row in a table
         * FOREIGN KEY - Uniquely identifies a row/record in another table
         * CHECK - Ensures that all values in a column satisfies a specific condition
         * DEFAULT - Sets a default value for a column when no value is specified
         * INDEX - Used to create and retrieve data from the database very quickly
         */
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password);
            Statement statement = connection.createStatement()){
            statement.executeUpdate("drop table if exists tutorials");
            statement.executeUpdate("create table if not exists tutorials(PersonId int not null auto_increment,LastName varchar (255),Firstname varchar(255),Birthday date not null,primary key(PersonId))");
            Date date = new Date(System.currentTimeMillis());
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tutorials (LastName,Firstname,Birthday) VALUES (?,?,?) ");
            preparedStatement.setString(1,"Artem");
            preparedStatement.setString(2,"Dachevsky");
            preparedStatement.setDate(3,new Date(System.currentTimeMillis()));
            preparedStatement.execute();
            preparedStatement.setString(1,"Max");
            preparedStatement.setString(2,"Dachevsky");
            preparedStatement.setDate(3,new Date(System.currentTimeMillis()));
            preparedStatement.execute();

            /**
             * с помощью alter table можно добавлять новые колонки и удалять из уже созданной таблицы
             */
            statement.executeUpdate("alter table tutorials add new_name date");
            statement.executeUpdate("alter table tutorials drop column new_name");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
