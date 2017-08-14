package cn.jhsoft.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by chen on 2017/8/14.
 */
public class MyUser {
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
