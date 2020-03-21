package cn.lhx.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lee549
 * @date 2020/3/20 22:53
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("do myfilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
