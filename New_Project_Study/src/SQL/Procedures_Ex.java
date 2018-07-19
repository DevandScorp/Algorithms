package SQL;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.xml.transform.Result;
import java.sql.*;

public class Procedures_Ex {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Simple_Servlets.Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into books (name) values (?)"); Statement statement = connection.createStatement();) {
            //escapement sequence-почитать!!!
//            preparedStatement.setString(1,"Sheep");
//            preparedStatement.execute();
            CallableStatement callableStatement = connection.prepareCall("{call BooksCount(?)}");
            callableStatement.registerOutParameter(1,Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
            System.out.println();
            CallableStatement callableStatement1 = connection.prepareCall("{call getBooks_2(?)}");
            callableStatement1.setInt(1,1);
            if(callableStatement1.execute()){
                ResultSet resultSet = callableStatement1.getResultSet();
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                }
            }
            //множественные процедуры
            CallableStatement callableStatement2 = connection.prepareCall("{call getBooks_Multiple()}");
            boolean hasResults = callableStatement2.execute();
            while(hasResults){
                ResultSet resultSet = callableStatement2.getResultSet();
                while(resultSet.next()){
                    System.out.println(resultSet.getInt(1));

                }
                hasResults = callableStatement2.getMoreResults();
            }
            System.out.println("___________________________________________________________________-");
            //скролим таблицу
            //первы параметр-это параметр скролла.
            //sensistive-реагирует на изменения в базе данных
            //insensetive-не реагирует
            //type_forward_only-только вверх...
            //второй параметр-режим чтения или записи.
            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //PreparedStatement preparedStatement1 = connection.prepareStatement("",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from books");
            if(resultSet.next()){
                System.out.println(resultSet.getInt("id") + resultSet.getString("name"));

            }
            if(resultSet.next()){
                System.out.println(resultSet.getInt("id") + resultSet.getString("name"));

            }
            if(resultSet.previous()){
                System.out.println(resultSet.getInt("id") + resultSet.getString("name"));

            }
            /**На сколько колонок хочу сдвигаться(+-)**/
            if(resultSet.relative(1)){
                System.out.println(resultSet.getInt("id") + resultSet.getString("name"));
            }
            /**resultSet.absolute()-относительно начала строчки.Также есть first,last,...*/
            /**
             * для изменяемых у тебя есть текущее положение resultset.Ты вызываешь метод updateString(name,"///")(например,
             * т.е. изменяешь поле).А опотом пишешь updateRow();
             */
            Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet2 = statement2.executeQuery("select * from books");
            resultSet2.last();
            resultSet2.updateString("name","new Value");
            resultSet2.updateRow();
            resultSet2.moveToInsertRow();
            resultSet2.updateString("name","inserted row");
            resultSet2.insertRow();//при insert updaterow не вызывается

            resultSet2.absolute(2);
            resultSet2.deleteRow();//при удалении update вызывать не надо
            resultSet2.first();
            System.out.println("__________________________________________________");
            while(resultSet2.next()){
                System.out.println(resultSet2.getInt("id") + resultSet2.getString("name"));
            }
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
            //кешируем данные.Есть данные rowset
            Statement statement3 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet3 = statement3.executeQuery("select * from dates");
            cachedRowSet.populate(resultSet3);
            //cachedrowSet ты можешь спокойно возвращать.Такие штуки нужны,когда необходимо получать данные
            //при закрытой базе.(когда подключения нет,что очень удобно).
            System.out.println("CACHED ROW SET");
            //cashedRowSet.setCommand("////");Есть парочка удобных команд
            ResultSet example = cachedRowSet;
            while(example.next()){
                    System.out.println(example.getDate("dt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
