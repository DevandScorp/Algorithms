package Tomcat_EE;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

//Tomcat-это контейнер.Менеджмент бин-это бин,работающий под контейнером.Для того,чтобы указать это,необходимо создать класс xml
@WebServlet("/dlExample")
public class DependencyInjection_Example extends HttpServlet {
    @Inject
    //@Student_Interface
    Person person;
    //После вызова аннотации вызовется student
//    Student student = new Student();/**Но это зло.Так делать низя.Но нам же нужно как-то управлять созданием класса.
//    И тут приходит injection control.Т.е. мы хотим,чтобы контейнер все сделал без нашего участия.
//      Ты это делаешь с помощью inject
//     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(person.getName());
    }
}
//@Qualifier
//@Retention(RUNTIME)
//@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
//@interface Student_Interface {
//
//}

interface Person {
    String getName();
}
/**
 * Java-бины-это бины,у которых обязательно должны быть все приватные поля,геттеры и сеттеры и конструктор по умолчанию
 *
 */
//@Student_Interface
@Alternative
class Student implements Person{
    private String name;

    public String getName() {
        return "student";
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Не заработает,т.к. несколько имплементаций
 */
class Worker implements Person{

    @Override
    public String getName() {
        return "worker";
    }
}
