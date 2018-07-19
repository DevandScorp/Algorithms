package Tomcat_EE;


import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/expression")
public class Expression_EE extends HttpServlet {
    @Inject
    MySecondBeanExpression mySecondBeanExpression;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(mySecondBeanExpression.getS());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Jsp_Pages/Tets.jsp");
        requestDispatcher.forward(req,resp);
    }
}

/**
 * Для использования бина необходимо пометить его как named
 * Тут для использования класса нужен будет camelCase:т.е. все первые буквы должны быть строчными.
 * Т.е. твой класс будет написан как my_Bean_Example
 */
@javax.enterprise.context.RequestScoped
@Named("newName")
class MySecondBeanExpression{

    private String s = "hello world";
    public String getS() {
        return s;
    }

    public void setS(String name) {
        this.s = name;
    }
}
