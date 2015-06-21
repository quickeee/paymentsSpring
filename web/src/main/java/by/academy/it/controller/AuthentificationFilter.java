
package by.academy.it.controller;

/*
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.academy.it.resources.constant.Constants.*;


public class AuthentificationFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("doFilter is execute");
        // Мы не можем вызвать response.sendRedirect("login.jsp") так как нам нужен httpResponse, а не ServletResponse.

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpRequest.getSession();
        // Получаем путь до страницы типа /index.jsp или /login.jsp
        String uriPath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        String val = (String)session.getAttribute(PARAM_SESSION_USER_LAST_NAME);
        if (session == null || session.getAttribute(PARAM_SESSION_USER_LAST_NAME) == null || session.getAttribute(PARAM_SESSION_USER_LAST_NAME) == ""){
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            if(PAGE_LOGIN.equals(uriPath)){
                filterChain.doFilter(servletRequest, servletResponse);
            }
            httpResponse.sendRedirect(PAGE_LOGIN + "?destination=" + uriPath);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;

    }
}
*/
