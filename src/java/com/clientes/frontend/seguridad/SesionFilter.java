/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clientes.frontend.seguridad;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo A. Ramirez paramirez434@gmail.com
 */
@WebFilter(filterName = "SesionFilter", urlPatterns = {"/pages/*"})
public class SesionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String url = req.getRequestURL().toString();
        
        if(!url.contains(".cli")){
            res.sendRedirect(req.getContextPath() + "/index.cli");
        }else{
            if(req.getSession().getAttribute("usuario")==null){
                res.sendRedirect(req.getContextPath() + "/index.cli");
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
