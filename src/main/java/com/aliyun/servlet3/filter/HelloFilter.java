package com.aliyun.servlet3.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author shiyou.xusy
 * @created 13-12-19
 */
@WebFilter(filterName = "HelloFilter", urlPatterns = {"/*"}, asyncSupported = true)
public class HelloFilter implements Filter {
    private static final Logger logger = Logger.getLogger("HelloFilter");

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("HelloFilter initing");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = request.getServletContext();
        String say = request.getParameter("say");
        logger.info("start filter,say:" + say);
        chain.doFilter(request, response);
        logger.info("end filter");
    }

    public void destroy() {
       logger.info("HelloFilter desctroy");
    }
}
