package Model;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import Controller.Music_Tag_Handler;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
@Named("user")
@SessionScoped
public class User_Bean implements Serializable {
    @Inject
    User user;
    private String JSTags;
    private String PlayerTags;

    public String getJSTags() {
        return this.JSTags;
    }

    public void setJSTags() {
        this.JSTags = Music_Tag_Handler.getJSTag(user.getNickname());
    }

    public String getPlayerTags() {
        return Music_Tag_Handler.getPlayerTag(user.getFilepath());
    }

    public void setPlayerTags() {
        PlayerTags = Music_Tag_Handler.getPlayerTag(user.getFilepath());
    }

    public String getNickname() {
        return user.getNickname();
    }

    public void setNickname(String nickname) {
        user.setNickname(nickname);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public String getFilepath() {
        return user.getFilepath();
    }

    public void setFilepath(String filename) {
        user.setFilepath(filename);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user.getId() +
                ", nickname='" + user.getNickname() + '\'' +
                ", email='" + user.getEmail() + '\'' +
                ", password='" + user.getPassword() + '\'' +
                ", filepath='" + user.getFilepath() + '\'' +
                ", USERNAME='" + User.getUSERNAME() + '\'' +
                ", PASSWORD='" + User.getPASSWORD() + '\'' +
                ", CONNECTION='" + User.getCONNECTION() + '\'' +
                '}';
    }
}
