package Tomcat_EE;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@WebServlet("/life_cycle")
public class Bean_Cycle extends HttpServlet {
    @Inject
    LifeCycleBean lifeCycleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lifeCycleBean.doJob();
        lifeCycleBean.doJob2();
        /**
         * Два construct из-за Dependent(он же всякий раз создает новый элемент
         * Construct
         * post construct
         * Construct
         * post construct
         * before method
         * Do job1
         * before method
         * Do job2
         * Destroy live cycle bean
         * Destroy live cycle bean
         */
    }
}

/**
 * Так удобнее управлять жизненным цмклом бинов
 */
@InterceptorBinding
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface One{}

/**
 * !!!!!!!!
 * !!!!!!!!
 * !!!!!!!!
 * В web-xml еще нужно прописать interceptors,а там классы
 */
@One
@Interceptor
class Intercepter{
    @AroundConstruct
    private Object aroundConstruct(InvocationContext invocationContext) throws Exception {
        System.out.println("Before construct");
        return invocationContext.proceed();
    }
    @PostConstruct
    private void postConstruct(InvocationContext context) throws Exception {
        System.out.println("post construct");
        context.proceed();
    }
    @AroundInvoke
    private Object aroundMethod(InvocationContext invocationContext) throws Exception {
        System.out.println("before method");
        return invocationContext.proceed();
    }
    @PreDestroy
    private void preDestroy(){
        System.out.println("pre destroy");
    }
}

/**
 *Вообще говоря,вот так вот вызывать Interceptor class не очень хорошо,поэтому придумали такую штуку,как binding
 *Сделва интерфейс-маркер,мы связваем класс с Interceptor'ом
 */
//@Interceptors(Intercepter.class)
@One
class LifeCycleBean {
    public LifeCycleBean() {
        System.out.println("Construct");
    }
//
//    /**
//     * Неважно,что он приватный.Для того,чтобы метод вызывался после,необходима аннотация post construct
//     */
//    @PostConstruct
//    private void postConstruct(){
//        System.out.println("post construct");
//    }
//
//    /**
//     * То,что вызовется до того,как начнут свое выполнение методы.Название значения не имеет,важна только сигнатура
//     */
//    @AroundInvoke
//    private Object aroundMethod(InvocationContext invocationContext) throws Exception {
//        System.out.println("before method");
//        /**
//         * из этого invocationContext тоже можно вызвать дохера чего интересного
//         */
//        return invocationContext.proceed();
//    }
//    @PreDestroy
//    private void preDestroy(){
//        System.out.println("Destroy live cycle bean");
//    }

    /**
     * Можно непосредственно перед методом
     */
    /**@Interceptors(Intercepter.class)*/
    public void doJob(){
        System.out.println("Do job1");
    }
    /**Эта аннотация значит,что перед вызовом этого метода не будет AroundInvoke*/
//    @ExcludeClassInterceptors
    public void doJob2(){
        System.out.println("Do job2");
    }
}
