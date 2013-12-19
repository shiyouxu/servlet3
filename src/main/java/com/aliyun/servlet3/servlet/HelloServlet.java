package com.aliyun.servlet3.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author shiyou.xusy
 * @created 13-12-19
 */
@WebServlet(name="HelloServlet", urlPatterns = {"/HelloServlet"}, loadOnStartup = 1,
    initParams = {
            @WebInitParam(name="name", value="xiazhang"),
            @WebInitParam(name="age", value = "23")
    })
public class HelloServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        ServletConfig config = getServletConfig();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Hello world"+"<br />");
        out.println(config.getInitParameter("name"));
        out.println("</body>");
        out.println("</html>");
    }
}
