package com.estsoft.springmvc.filter;

import jakarta.servlet.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfigg) throws ServletException {
        System.out.println("FirstFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter.dofilter requ");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("FirstFilter.dofilter req");
        request.getParameter("requestURI: "+ request.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("FirstFilter.dofilter response");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter.destroy");
    }
}
