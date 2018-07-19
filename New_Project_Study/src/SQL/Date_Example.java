package SQL;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Date_Example {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Test?serverTimezone=UTC";
        //String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password); Statement statement = connection.createStatement();) {
            statement.execute("drop table if exists dates");
            statement.executeUpdate("CREATE table if not exists dates(id MEDIUMINT not null auto_increment,name char(30)NOT NULL ,dt DATE not NULL ,primary key (id))");
            statement.executeUpdate("insert into  dates (name, dt) values ('thirdname',{d'2018-02-07'})");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into dates (name,dt) VALUES ('somename',?) ");
            preparedStatement.setDate(1,new Date(System.currentTimeMillis()));
            preparedStatement.execute();

            statement.executeUpdate("insert into dates (name, dt) values ('anothername',{d'2017-02-08'})");
            ResultSet resultSet = statement.executeQuery("select * from dates");
            while(resultSet.next()){
                System.out.println(resultSet.getDate("dt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
