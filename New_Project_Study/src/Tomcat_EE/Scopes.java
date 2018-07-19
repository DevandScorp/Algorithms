package Tomcat_EE;

import javax.enterprise.context.*;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/scope_ex")
public class Scopes extends HttpServlet {
    @Inject
    MyBean myBean;
    @Inject
    ChangeMyBin changeMyBin;
    @Inject
    ConversationBean conversationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        myBean.i = 5;
//        changeMyBin.change();
//        System.out.println(myBean.i);
        /**
         * Если будет Dependent,то выведется 5,т.к. dependent в отличие от requestscope каждый раз создает новый bean.
         * Т.е. в ChangeMyBin будет уже новый скоуп.А при requestScope такого не будет.
         */


        /**
         * Тут будут абсолютно два разных значения и i будут разные
         */
        System.out.println(conversationBean.i);
        conversationBean.i = 1;
        conversationBean.startConversation();
        System.out.println(conversationBean.i);
        conversationBean.i = 20;
        conversationBean.endConversation();
        System.out.println(conversationBean.i);
    }
}
//@ApplicationScoped----
//                      |
//@SessionScoped    --------- Аналогично с обыс=чными сервлетами
//                      |
//@RequestScoped    ----
//@ConversationScoped
//@Dependent-по умолчанию
@RequestScoped
class MyBean{
    int i;
}
class ChangeMyBin {
    @Inject
    MyBean myBean;
    public void change(){
        myBean.i = 2;
    }

}
@ConversationScoped
class ConversationBean implements Serializable{
    int i;
    @Inject
    Conversation conversation;

    /**
     * Тут уже абсолютно другой бин
     */
    public void startConversation(){
        System.out.println(i);
        System.out.println("Start conversation");
        conversation.begin();
        i = 2;
    }
    public void endConversation(){
        System.out.println(i);
        System.out.println("End conversation");
        conversation.end();

    }
}