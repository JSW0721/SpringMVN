package com.estsoft.springmvc.filter;

import jakarta.servlet.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.http.HttpServletResponseWrapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("SecondFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter doFilter() request");

        // 서블릿 응답 객체를 래퍼 클래스로.
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);

        filterChain.doFilter(servletRequest, responseWrapper);

        // 클라이언트에게 응답 전 값을 모두 대문자로 변환.
        String responseString = responseWrapper.getOutputString().toUpperCase();

        // 대문자로 변환한 값을 응답
        // servletResponse.getOutputStream().write(responseString.getBytes(StandardCharsets.UTF_8));
        // servletResponse.flushBuffer();  // commit
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.write(responseString);
        out.flush();

        System.out.println("SecondFilter doFilter() response");
    }

    private static class ResponseBodyServletOutputStream extends ServletOutputStream {

        private final DataOutputStream outputStream;

        public ResponseBodyServletOutputStream(OutputStream output) {
            this.outputStream = new DataOutputStream(output);
        }

        @Override
        public void write(int b) throws IOException {
            outputStream.write(b);
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setWriteListener(WriteListener listener) {
        }
    }
}
