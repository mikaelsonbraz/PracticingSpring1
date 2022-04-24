package com.web.practice.PracticingSpring1.api.services.authentication;

import com.web.practice.PracticingSpring1.api.services.CookieService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("Pre handle method is calling");

        if (CookieService.getCookie(request, "userId") != null){
            return true;
        }

        response.sendRedirect("/");
        return false;
    }

    /*
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        System.out.println("Post handle method is calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handlew, Exception exception) throws Exception{
        System.out.println("Request and response are completed");
    }
    */
}
