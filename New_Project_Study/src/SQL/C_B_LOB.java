package SQL;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class C_B_LOB {
    //BLOB - Binary Large Objects
    //CLOB - Character Large Objects
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "Bb14337107916408";
        String another_connection = "jdbc:mysql://localhost:3306/Simple_Servlets.Test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String connectionURL = "jdbc:mysql://localhost:3306/Simple_Servlets.Test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(another_connection,userName,password); Statement statement = connection.createStatement();) {
            statement.execute("drop table if exists blobs");
            statement.executeUpdate("create table if not exists blobs(id mediumint not null  auto_increment,name char(30) not null ,img BLOB,primary key(id))");
            BufferedImage bufferedImage = ImageIO.read(new File("src\\SQL\\if_menu_309053.png"));
            Blob blob = connection.createBlob();
            try(OutputStream outputStream = blob.setBinaryStream(1)){
                ImageIO.write(bufferedImage,"png",outputStream);
            }

            PreparedStatement preparedStatement = connection.prepareStatement("insert into blobs (name,img) values(?,?)");
            preparedStatement.setString(1,"inferno");
            preparedStatement.setBlob(2,blob);
            preparedStatement.execute();
            ResultSet resultSet = statement.executeQuery("select * from blobs");
            while(resultSet.next()){
                Blob blob1 = resultSet.getBlob("img");
                BufferedImage image2 = ImageIO.read(blob1.getBinaryStream());
                File outputFile = new File("saved.png");
                ImageIO.write(image2,"png",outputFile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
