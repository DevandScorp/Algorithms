package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import Model.User;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.servlet.ServletContext;

public class Test {
        public static void main(String[] args) throws ClassNotFoundException {
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
                Statement statement = connection.createStatement()) {
                String insertion = "insert into new_table (col) values (\'Mr.D''_S\')";
                statement.executeUpdate(insertion);

            } catch (SQLException e) {
                e.printStackTrace();
            }
//        String fileLocation = "C:\\Users\\User\\IdeaProjects\\Muniverse\\web\\Users\\Mr.D_S\\Asking Alexandria-Breathless.mp3";
//        File[] files = new File("C:\\Users\\User\\IdeaProjects\\Muniverse\\web\\Users\\Mr.D_S").listFiles();
//        System.out.println(files.length);
//        for(File file:files){
//            System.out.println(file.getName().substring(0,file.getName().indexOf(".")));
//            try(InputStream input = new FileInputStream(new File(file.getAbsolutePath()))) {
//                ContentHandler handler = new DefaultHandler();
//                Metadata metadata = new Metadata();
//                Parser parser = new Mp3Parser();
//                ParseContext parseCtx = new ParseContext();
//                parser.parse(input, handler, metadata, parseCtx);
//                // Retrieve the necessary info from metadata
//                // Names - title, xmpDM:artist etc. - mentioned below may differ based
//                System.out.println("----------------------------------------------");
//                System.out.println("Title: " + metadata.get("title"));
//                System.out.println("Artists: " + metadata.get("xmpDM:artist"));
//                System.out.println("Album : "+metadata.get("xmpDM:album"));
//
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (SAXException e) {
//                e.printStackTrace();
//            } catch (TikaException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
