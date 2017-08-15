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


    @After
    public void testAfter(){
        //6、提交事务
        tx.commit();

        //7、关闭资源和连接
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testfindById(){
        // 第一个参数是实体类，第二个参数是ID值（主键值）
        Order order = session.get(Order.class, 1);
        System.out.println(order);
    }

    @Test
    public void testUpdate(){
        Order order = session.get(Order.class, 1);
        order.setUsername("hahaha");
        session.update(order);  // save方法也可以 或者  saveOrUpdate方法
    }

    @Test
    public void testDelete(){
        // 先查询，再删除
        Order order = session.get(Order.class, 1);
        session.delete(order);

        // 第二种删除
        Order order1 = new Order();
        order1.setId(1);
        session.delete(order1);
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
        order.setUsername("cjh123");
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
