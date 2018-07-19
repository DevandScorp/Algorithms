package Simple_Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

@WebServlet("/hello")
/**
 * Ёта штука называетс€ аннотаци€ и позвол€ет упрощать вызов сервлетов
 */
public class HelloServlet extends HttpServlet {
    static int i = 0;
    @Override
    public void init() throws ServletException {
//        вызываетс€ при инициализации сервлета
        System.out.println("Initialization completed");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //request-запрос
//        //response-отклик,ответ,реакци€
//        //System.out.println("do get method");
//        System.out.println(Thread.currentThread().getName());
//        synchronized (this){
//            for(int j = 0;j<1000;++j){
//                ++i;
//            }
//            System.out.println(i);
//        }
        //это метод,который получает что-либо по параметру из request'a
        //каак эти параметры достаютс€?“ы в адресе обращаешьс€ к имени сервлета и там пишешь one=...,знаком
        //разделителем €вл€етс€ &,необходим вопрос в начале
//        String one = req.getParameter("one");
//        System.out.println(req.getServletPath());
//        System.out.println(req.getSession());
//        System.out.println(req.getRequestURI());
//        System.out.println(req.getRequestURL());
//        System.out.println(req.getRemoteHost());
//        System.out.println(req.getQueryString());
        //если параметров несколько(ты несколько раз указываешь one=&one=&...,то используй getParametres()
        //также можно получать мапу параметров,имена параметров,короче,все,что твоей душе угодно.
//        /**
//         * resp.getWriter().write("<!DOCTYPE html>\n" +
//         *                 "<html>\n" +
//         *                 "<head>\n" +
//         *                 "<meta charset=\"UTF-8\">\n" +
//         *                 "</head>\n" +
//         *                 "<body>\n" +
//         *                 "<form action = 'hello' method = 'post'>\n" +
//         *                 "  <fieldset>\n" +
//         *                 "    <legend>Contacts</legend>\n" +
//         *                 "    <p><label for=\"name\">Name <em>*</em></label><input type=\"text\" id=\"name\" name = 'one'></p>\n" +
//         *                 "  </fieldset>\n" +
//         *                 "<p><input type=\"submit\" value=\"Send\" name = 'submit'></p>\n" +
//         *                 "</form>\n" +
//         *                 "</body>\n" +
//         *                 "</html> ");
//         *                 //post - аналогично.“олько
//         */
        String one = req.getParameter("one");
        //это защита от xss-атак.≈сли ты забьешь код js в строку и потом выведешь его в код страницы,
        //то он сработает,но ведь так можно вывести все твои куки,поэтому эта строчка важна#хацкер
        one = one==null? "": one.replaceAll("<","&lt;").replaceAll(">","&gt");
        System.out.println(one);
        resp.getWriter().write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "one = " + one + " " +
                "<form action = 'hello' method = 'get'>\n" +
                "<textarea type = 'text' name = 'one'></textarea>" +
                "<input type = 'submit' name = 'submit'>"+
                "</form>\n" +
                "</body>\n" +
                "</html> ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**„тобы не паритьс€ с посто€нной перерисовкой кода,можно сделать и так:*/
        //System.out.println("do post method");
        doGet(req,resp);
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * “ут происход€т все взаимодействи€.Ётот метод провер€ет,какой запрос был отправлен
         */
        //System.out.println("service method");
        super.service(req, resp);
    }
}