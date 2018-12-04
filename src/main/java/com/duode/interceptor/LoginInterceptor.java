package com.duode.interceptor;

import com.duode.constant.ApiStatusCode;
import com.duode.constant.Constants;

import com.duode.response.ResponseDataModel;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fanyufeng on 2018/11/25
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        ResponseDataModel resDataModel = new ResponseDataModel();

        HandlerMethod method = (HandlerMethod ) handle;
        Class<?> controllerType = method.getBeanType();
        HttpSession session = request.getSession();
        String token = (String)session.getAttribute(Constants._SESSION_USER_ID_KEYPREFIX);
        System.out.print("token "+ token);
        if(token != null){
            return true;
        }

        resDataModel.setStatusCode(ApiStatusCode.ACCESS_DENY.value());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        Gson gson = new Gson();
        try {
            out = response.getWriter();
            out.append(gson.toJson(resDataModel));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
