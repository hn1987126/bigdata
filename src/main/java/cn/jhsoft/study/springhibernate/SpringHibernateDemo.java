package cn.jhsoft.study.springhibernate;

import cn.jhsoft.study.bean.Person;
import cn.jhsoft.study.spring.IOCDemo;
import cn.jhsoft.study.spring.User;
import cn.jhsoft.study.spring.UserService;
import cn.jhsoft.study.springhibernate.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenyi9 on 2017/8/16.
 */
public class SpringHibernateDemo {
    private ApplicationContext context;

    @Before
    public void testBefor(){
        // 加载spring配置文件
        context = new ClassPathXmlApplicationContext("spring-hibernate-final.xml");
    }

    @Test
    public void testBean(){
        OrderService orderService = (OrderService)context.getBean("orderService");
        orderService.add();
    }
}
