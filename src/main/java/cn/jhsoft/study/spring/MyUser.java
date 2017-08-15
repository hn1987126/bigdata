package cn.jhsoft.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by chen on 2017/8/14.
 */
@Aspect  // AOP注解
@Component("myUser")
public class MyUser {

    // 给User类里的所有方法，各种参数类型的，都增强
    @Before(value = "execution(* cn.jhsoft.study.spring.User.*(..))")
    public void before1(){
        System.out.println("前置增强");
    }

    public void after1(){
        System.out.println("后置增强");
    }

    // 环绕通知
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 方法之前
        System.out.println("环绕增强，方法之前。。。");
        // 执行被增强的方法
        proceedingJoinPoint.proceed();
        // 方法之后
        System.out.println("环绕增强，方法之后。。。");
    }
}
