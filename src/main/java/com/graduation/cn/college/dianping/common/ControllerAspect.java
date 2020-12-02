package com.graduation.cn.college.dianping.common;

import com.graduation.cn.college.dianping.controller.admin.AdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.lang.reflect.Method;
import org.aspectj.lang.reflect.MethodSignature;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Configuration
public class ControllerAspect {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpServletResponse httpServletResponse;

    @Around("execution(* com.graduation.cn.college.dianping.controller.admin.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object adminControllerBeforeValidation(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);

        if (adminPermission == null) {
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }
        String email = (String) httpServletRequest.getSession().getAttribute(AdminController.CURRET_ANDMIN_SESSION);
        if (email == null) {
            if (adminPermission.produceType().equals("text/html")) {
                httpServletResponse.sendRedirect("/admin/admin/loginpage");
                return null;
            } else {
                CommonError commonError = new CommonError(EmBusinessError.ADMIN_SHOULD_LOGIN);
                return CommonRes.create(commonError,"Failure");
            }
        } else {
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }

    }
}
