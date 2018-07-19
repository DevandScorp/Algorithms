package Tomcat_EE;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pool")
public class Thread_Pools extends HttpServlet {

    /**
     * Для того,чтобы юзать пул потоков,необходимо просто вместо Inject написать Resource
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    /**
     * Тут те же самые наборы потоки,только они начинаются со слова Managed,т.к. они управляются
     */
    @Resource
    ManagedExecutorService executorService;

    /**
     * Shutdown не надо,т.к. тут все работает через Inject
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(int i = 0;i<10;++i){
            executorService.submit(new MyRunnable(i));
        }

    }
    static class MyRunnable implements Runnable{
        private int i;

        public MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(i);
        }
    }

}
