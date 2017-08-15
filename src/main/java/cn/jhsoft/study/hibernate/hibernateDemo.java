package cn.jhsoft.study.hibernate;

import cn.jhsoft.study.hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chenyi9 on 2017/8/15.
 */
public class hibernateDemo {

    // 1.加载hibernate核心配置文件
    Configuration cfg;
    //2、创建SessionFactory对象
    SessionFactory sessionFactory;
    //3、使用SessionFactory创建session对象
    Session session;
    //4、开启事务
    Transaction tx;


    @Before
    public void testBefore(){
        //1、加载hibernate核心配置文件
        // 到src下面找到名称是 hibernate.cfg.xml
        // 在hibernate里面封装对象
        cfg = new Configuration();
        cfg.configure();

        //2、创建SessionFactory对象
        // 读取hibernate核心配置文件内容，创建sessionFactory
        // 在过程中，根据映射关系，在配置数据库里面把表创建
        sessionFactory = cfg.buildSessionFactory();

        //3、使用SessionFactory创建session对象（与web项目里的session完全不同，本身不是一个东西）
        // 类似于Connection连接
        session = sessionFactory.openSession();

        //4、开启事务
        tx = session.beginTransaction();
    }


    @Test
    public void testUpdate(){
        // 5、写具体逻辑 crud 操作
    }

    @After
    public void testAfter(){
        //6、提交事务
        tx.commit();

        //7、关闭资源和连接
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testDelete(){
        
    }


    // 原始写法
    @Test
    public void testAdd(){
        //1、加载hibernate核心配置文件
        // 到src下面找到名称是 hibernate.cfg.xml
        // 在hibernate里面封装对象
        Configuration cfg = new Configuration();
        cfg.configure();

        //2、创建SessionFactory对象
        // 读取hibernate核心配置文件内容，创建sessionFactory
        // 在过程中，根据映射关系，在配置数据库里面把表创建
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //3、使用SessionFactory创建session对象（与web项目里的session完全不同，本身不是一个东西）
        // 类似于Connection连接
        Session session = sessionFactory.openSession();

        //4、开启事务
        Transaction tx = session.beginTransaction();

        //5、写具体逻辑 crud 操作
        // 添加功能
        Order order = new Order();
        order.setUsername("cjh");
        order.setSalary(2500);
        // 调用session里的方法实现添加
        session.save(order);

        //6、提交事务
        tx.commit();

        //7、关闭资源和连接
        session.close();
        sessionFactory.close();

    }

}
