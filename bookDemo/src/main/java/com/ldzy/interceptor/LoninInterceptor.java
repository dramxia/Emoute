package com.ldzy.interceptor;

import com.ldzy.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoninInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        if(user!=null){
            return true;
        }
        request.setAttribute("msg","您还没有登录呢！");
        request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
        return false;
    }
}
