package br.pa.com.femabra.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LockInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session  = request.getSession();
//        System.out.println("pre handle: "+session.getLastAccessedTime());
//        System.out.println("pre handle: "+session.isNew());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpSession session  = request.getSession();
//        System.out.println("after completion: "+session.getLastAccessedTime());
//        System.out.println("after completion: "+session.isNew());

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HttpSession session  = request.getSession();
//        System.out.println("post handler: "+session.getLastAccessedTime());
//        System.out.println("post handler: "+session.isNew());
    }


}
