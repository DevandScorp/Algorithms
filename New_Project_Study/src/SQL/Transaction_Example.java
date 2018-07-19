package SQL;

import java.sql.*;

public class Transaction_Example {
    public static void main(String[] args) throws ClassNotFoundException {
        //транзакции-это операции,которые должны быть выполнены целостно,т.е. если одна полетела,
        //то и остальные тоже не будут выполняться
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Simple_Servlets.Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password);
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);//после этого операции не будут выполнены,пока ты не вызовешь commit()
            statement.executeUpdate("insert into books (name) values ('Solomon Key')");
            connection.commit();
            /**
             * connection.rollback()-вернет все к началу,т.е. операции выполнены не будут.
             * (но это не относится к Create/Insert таблицы.Вставки роллбэкнутся.И удаление тоже
             */
            /**
             * есть еще savepoint-он создается и в месте,где ты его создал,в этом месте методом rollback(savepoint)
             * ты вернешься на savepoint
             */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}