package Simple_Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import static com.sun.jmx.snmp.ThreadContext.contains;

@WebServlet("/g_zip")
public class Gzip_Servlet extends HttpServlet {
    /**Czip используется для сжатия файлов html

     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getHeader("Accept-Encoding").contains("gzip")){
            PrintWriter printWriter = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            printWriter.write("hello world");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
