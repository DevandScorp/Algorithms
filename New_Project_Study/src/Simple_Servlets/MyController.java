package Simple_Servlets;

import jsp.MyModel;
import jsp.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Simple_Servlets.MyController")
public class MyController extends HttpServlet {
    MyModel myModel = new MyModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = myModel.getPerson();
        List<String> list = new ArrayList<>();
        list.add("Hello.");
        list.add("It is me.");
        list.add("You can add me on your webpage.");
        //аналогично с мапой
        req.setAttribute("list",list);
        req.setAttribute("person",person);//эта запись аналогична выбору в jsp scope = "request"
        req.getSession().setAttribute("person",person);//эта запись аналогична выбору в jsp scope = "session"
        req.getServletContext().setAttribute("person",person);//application
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Jsp_Pages/MyView.jsp");
        requestDispatcher.forward(req,resp);//передаем управление MyView
    }
}
