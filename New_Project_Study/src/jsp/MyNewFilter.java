package jsp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
//имя фильтра должно совпадать с именем сервлета,из которого ты вызываешь
@WebFilter("/MyNewServletFilter")
public class MyNewFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //можно сделать то,что работает до вызова фильтра и после
        //до
        servletResponse.getWriter().write("Before");
        //такой своеобзраный класс wrapper,который может что-то добавить в response
        //отфильтровать там что-то.
        filterChain.doFilter(servletRequest,new MyResponseWrapper((HttpServletResponse)servletResponse));
        servletResponse.getWriter().write("After");
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }
    class MyResponseWrapper extends HttpServletResponseWrapper {

        public MyResponseWrapper(HttpServletResponse response) {
            super(response);
        }
    }

}
