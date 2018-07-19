package Tomcat_EE;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/specialize")
public class Specialize_ex extends HttpServlet {
    @Inject
    A a;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        a.print();
    }
}
interface A{
    void print();
}
class B implements A{

    @Override
    public void print() {
        System.out.println("B");
    }
}
@Specializes
class C extends B{

    @Override
    public void print() {
        System.out.println("C");
    }
}

