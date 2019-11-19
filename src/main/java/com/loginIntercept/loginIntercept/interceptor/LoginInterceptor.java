package com.loginIntercept.loginIntercept.interceptor;


import com.loginIntercept.loginIntercept.annotation.LoginRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 实现自定义拦截器逻辑
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    //请求处理前，也就是访问Controller前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
//            log.info("不是HandlerMethod类型，不进行检查");
            return true;
        }
        HandlerMethod method =(HandlerMethod) handler;
        boolean hasLoginRequired = method.getMethod().isAnnotationPresent(LoginRequired.class);
        if(!hasLoginRequired){
//            log.info("该方法上未注解自定义LoginRequired注解，不进行检查");
            return true;
        }

        //到这一步则说明需要进行登录的判断
        //获取登录标识
        String loginStr = request.getParameter("login");
        //登录逻辑判断
        if("login".equals(loginStr)){
//            log.info("已登录");
            return true;
        }else {
//            log.info("未登录");

            //设置编码格式
            response.setCharacterEncoding("UTF-8");
            //这句话是解决乱码的
            response.setHeader("Content-Type", "text/html;charset=UTF-8");

            response.getWriter().append("你尚未登录，请先登录");
            return false;
        }
    }

    //请求已经被处理，但在视图渲染前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //请求结果结果已经渲染好了，response没有进行返回但也无法修改reponse了（一般用于清理数据）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
