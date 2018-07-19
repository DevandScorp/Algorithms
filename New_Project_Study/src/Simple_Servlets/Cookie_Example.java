package Simple_Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie_ex")
public class Cookie_Example extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        System.out.println(cookies.length);
//        for(Cookie cookie:cookies){
//            System.out.println(cookie.getName() + " = " + cookie.getValue() + " Secure: "+ cookie.getSecure());
//        }
        Cookie cookie1 = new Cookie("First","Name");
        resp.addCookie(cookie1);
        Cookie[] cookies = req.getCookies();
        System.out.println(cookies.length);
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName() + " = " + cookie.getValue() + " Secure: "+ cookie.getSecure());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
