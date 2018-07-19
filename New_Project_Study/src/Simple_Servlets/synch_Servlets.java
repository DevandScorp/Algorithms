package Simple_Servlets;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/synchServlet",asyncSupported = true)
public class synch_Servlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //предположим ситуацию,когда у тебя сервлет требует долгого выполнения чего-либо,а тебе необходимо,
        //чтобы параллельно работало что-то еще.Т.е. необходимо асинхронное выполнение.Делается это
        //добавлением в аннотацию вышеприведенных параметров
        AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                //code
                //т.е. ты в отдельном потоке выполняешь свою задачу
                //request работают с отдельным пулом потоков,а вот таким образом ты
                //не заставляешь сервлет выполнять задачу в этому пуле,а делаешь все в отдельном.
            }
        });

    }
}
