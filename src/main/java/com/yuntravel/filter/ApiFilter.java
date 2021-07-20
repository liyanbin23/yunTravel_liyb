package com.yuntravel.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest)req;

        String origin = request.getHeader("Origin");
        System.out.println("++++++++++++"+origin);
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authentication");
//        response.setHeader("Access-Control-Allow-Headers", "x-access-token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader(" Access-Control-Allow-Origin", "*");
        System.out.println("??????????");
        String method = request.getMethod();
        if(method.equalsIgnoreCase("OPTIONS")){
            res.getOutputStream().write("Success".getBytes("utf-8"));
        }else{
            chain.doFilter(req, res);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
