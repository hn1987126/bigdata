package cn.jhsoft.study.spring;

import cn.jhsoft.study.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chen on 2017/8/13.
 */
public class IOCDemo {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("cn.jhsoft.study.bean.Person");
        Person person = (Person) clazz.newInstance();
        System.out.println(person.getName());
    }

    public static IOCDemo getBean2(){
        return new IOCDemo();
    }

    public IOCDemo getBean3(){
        return new IOCDemo();
    }

    @Test
    public void testPerson(){
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 得到配置创建的对象
        Person person = (Person) context.getBean("person");
        Person person2 = (Person) context.getBean("person");
        System.out.println(person);
        System.out.println(person2);
    }

    @Test
    public void testBean(){
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IOCDemo bean2 = (IOCDemo) context.getBean("bean2");
        System.out.println(bean2);
    }

    @Test
    public void testBean3(){
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IOCDemo bean3 = (IOCDemo) context.getBean("bean3");
        System.out.println(bean3);
    }

}
