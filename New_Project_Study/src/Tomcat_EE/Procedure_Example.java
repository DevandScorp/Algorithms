package Tomcat_EE;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.logging.Logger;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/procedure")
public class Procedure_Example extends HttpServlet {
    @Inject
    MyLogger logger;
    @Inject
    String s;
    @Inject
    int i;
    @Inject
    double d;
    @Inject
    Car car;
    @Inject
    @S2
    String s2;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(s + " " + i + " " + d + " " + car.name + " " + s2 + " ");
    }

}
@Qualifier
@Retention(RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@interface S2 { }
class Producer {
    @Produces
    String s = "hello world";
    @Produces
    int i = 5;
    @Produces
    @S2
    String s2 = "another string";
    @Produces
    double getDouble(){
        return 10.0;
    }
    @Produces
    Car getCar(){
        return new Car("lada");
    }
    /**Этот метод вызовется при очистке ресурсов*/
    public void clean(@Disposes Car car){
        car.clean();
    }
}
class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }
    public void clean(){
        System.out.println("Car clean");

    }
}

/**
 * Можно получать информацию об инджекте через Injection Point
 */

/**
 * Injection POint
 */
class MyLogger{
    @Produces
    public Logger getLogger(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
