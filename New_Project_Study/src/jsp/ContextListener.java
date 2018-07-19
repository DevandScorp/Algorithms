package jsp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("init context");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destroy context");
    }
}
