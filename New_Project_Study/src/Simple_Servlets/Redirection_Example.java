package Simple_Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class Redirection_Example extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**В этой жизни есть такие штуки,как статусы: у ответа*/
        /**resp.setStatus(HttpServletResponse.SC_CONTINUE);-много констант.
         * Самый интересный-это наврное redirect(404 кстати-это тоже Response).Redirect имеет отдельный метод*/
        //resp.sendRedirect("/hello");
        /**
         * Также есть error
         */
        //resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"Wrong");
        //А еще есть refresh.Эта штука необходима,когда тебе нужно перезагружать страницу
        //Если просто время-то оно просто будет через промежутки времени выполнять doGet()
        resp.setHeader("Refresh","5;URL=https://www.google.by/webhp?hl=ru&sa=X&ved=0ahUKEwi_1bfB6pHcAhVK1iwKHaS3Dn4QPAgD");//будет обновляться каждую секунду
        //System.out.println("Hello");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
