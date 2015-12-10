package com.cquacmer.shiro;

import com.cquacmer.model.User;
import com.cquacmer.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by admin on 2015/12/10.
 */
public class ISLoginFilter implements Filter {

    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       Subject subject= SecurityUtils.getSubject();
        if(subject.isRemembered() && ((HttpServletRequest)servletRequest).getSession().getAttribute("user")==null){
            User u= userService.findByEmail((String)subject.getPrincipal());
            System.out.println(u);
                    ((HttpServletRequest) servletRequest).getSession().setAttribute("user",u);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
