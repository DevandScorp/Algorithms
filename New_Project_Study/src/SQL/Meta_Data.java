package SQL;

import java.sql.*;

public class Meta_Data {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Simple_Servlets.Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password);
            Statement statement = connection.createStatement()){
            DatabaseMetaData databaseMetaData = connection.getMetaData();
                ResultSet resultSet = databaseMetaData.getTables(null,null,"%",new String[]{"TABLE"});
            while(resultSet.next()){

                System.out.println(resultSet.getString(3));//в 3 хранится имя таблицы
            }
            Statement statement1 = connection.createStatement();
            ResultSet resulSet2 = statement1.executeQuery("select * from books");
            ResultSetMetaData resultSetMetaData = resulSet2.getMetaData();
            //аналогично для resultset
            System.out.println("______________________________________");
            for(int i = 1;i<=resultSetMetaData.getColumnCount();++i){
                System.out.println(resultSetMetaData.getColumnLabel(i));
                //и еще куча всяких фиговин интересных

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
