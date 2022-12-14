package com.example.demo.filter;

import com.example.demo.error.LoginBeforeAction;
import com.example.demo.repos.IAuthenticationFacade;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
//@ComponentScan(value = "/api")
public class CustomFilter implements Filter {
    List<String> listMethodController = new ArrayList<>(Arrays.asList("post", "patch", "put", "delete"));
    @Autowired
    HttpServletRequest servletRequest;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        if (listMethodController.contains(servletRequest.getMethod().toLowerCase())) {
//            if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
//                throw new LoginBeforeAction("login before do something");
//            }
//        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
