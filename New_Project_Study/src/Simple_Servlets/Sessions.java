package Simple_Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/session_ex")
public class Sessions  extends HttpServlet {
    //сессии только в req
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("First","new");//можно запихивать в сессию товары,например
        Enumeration<String> enumeration = httpSession.getAttributeNames();
        System.out.println(enumeration.hasMoreElements());
        while(enumeration.hasMoreElements()){
            String attributeName = enumeration.nextElement();
            System.out.println(attributeName + " " + httpSession.getAttribute(attributeName));
        }
    }
}
