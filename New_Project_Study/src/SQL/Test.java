package SQL;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * Короче смотри,для того,чтобы создать database,тебе сначала
         * нужно написать create DATABASE TEST в mysqlLocalhost(для примера);
         * а потом уже создавать через добавлние файла
         */
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Simple_Servlets.Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String userId = "1' or 1 = '1'";
        //если ты вставишь такую строку в запрос,то оно выведется все.
        //.т.е. рофл в том,что ты подставляешь какие-то некорректные данные,которые приведут
        //к тому,что у тебя будут все данные.Это sql-инъекция
        //для защиты необходим Preparement Statement.
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password);
            PreparedStatement preparedStatement = connection.prepareStatement("select from * books where id = ?"); Statement statement = connection.createStatement();)
        {
            //preparedStatement.setInt(1,Integer.parseInt(userId));//parameterIndex-это номер вопроса
            statement.executeUpdate("drop table books");
            statement.executeUpdate("create TABLE if not exists Books(id MEDIUMINT not null auto_increment,name char(30)NOT NULL ,primary key (id))");
            statement.executeUpdate("insert into books (name) values('Dagon')");
            statement.executeUpdate("insert into books set name = 'Ktulhu'");
            ResultSet result = statement.executeQuery("select * from books");
            //ResultSet result_3 = preparedStatement.executeQuery();
            while(result.next()){
                System.out.println(result.getInt(1) + " " + result.getString(2));
                /**getInt(id)+getString(name)*/
            }
//            while(result_3.next()){
//                System.out.println(result.getInt(1) + " " + result.getString(2));
//                /**getInt(id)+getString(name)*/
//            }
            ResultSet resultSet = statement.executeQuery("select name from books where id=1");
            while(resultSet.next()){
                System.out.println( resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
