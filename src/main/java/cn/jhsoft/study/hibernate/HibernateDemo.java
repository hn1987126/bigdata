package cn.jhsoft.study.hibernate;

import cn.jhsoft.study.hibernate.entity.Customer;
import cn.jhsoft.study.hibernate.entity.LinkMan;
import cn.jhsoft.study.hibernate.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by chenyi9 on 2017/8/15.
 */
public class HibernateDemo {

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
        try {
            // 第一个参数是实体类，第二个参数是ID值（主键值）
            Order order = session.get(Order.class, 11);
            System.out.println(order);
            int i = 10/0;
            Order order2 = session.get(Order.class, 11);
            System.out.println(order2);
        }catch (Exception e){
            // 回滚
            tx.rollback();
        }finally {
            //7、关闭资源和连接
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void testUpdate(){
        Order order = session.get(Order.class, 11);
        order.setUsername("sbsb");
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

    @Test
    public void testSaveOrUpdate(){
        // 先查询，再删除
        Order order = session.get(Order.class, 1);
        if (order == null){
            order = new Order();
            order.setUsername("hahaha");
        }
        order.setSalary(10000);

        session.saveOrUpdate(order);
    }

    // Query对象查询
    @Test
    public void testQuery(){
        // 1、创建Query对象，方法参数里写hql语句
        Query query = session.createQuery("from Order");
        // 2、调用query对象里的方法得到结果
        List<Order> list = query.list();

        for (Order order:list){
            System.out.println(order);
        }
    }

    // Criteria对象查询
    @Test
    public void testCriteria(){
        // 1、创建Criteria对象，方法参数 是对象的class
        Criteria criteria = session.createCriteria(Order.class);
        // 2、调用Criteria对象里的方法得到结果
        List<Order> list = criteria.list();

        for (Order order:list){
            System.out.println(order);
        }
    }

    // SQLQuery 用sql语句查询
    @Test
    public void testSQLQuery(){
        // 1、创建SQLQuery对象，方法参数 是对象的class
        SQLQuery sqlQuery = session.createSQLQuery("select * FROM tbl_order");
        // 2、调用SQLQuery对象里的方法得到结果，结果是数组
        List<Object[]> list = sqlQuery.list();
        for (Object[] objects : list){
            System.out.println("姓名："+objects[1]);
            System.out.println(Arrays.toString(objects));
        }
    }


    // SQLQuery 用sql语句查询，返回对象
    @Test
    public void testSQLQueryRetunObject(){
        // 1、创建SQLQuery对象，方法参数 是对象的class
        SQLQuery sqlQuery = session.createSQLQuery("select * FROM tbl_order");
        // 1.1、返回list中每部分是对象形式，并把实体传进去。
        sqlQuery.addEntity(Order.class);
        // 2、调用SQLQuery对象里的方法得到结果，结果是数组
        List<Order> list = sqlQuery.list();
        for (Order order : list){
            System.out.println(order);
        }
    }


    // 测试一对多，级联保存
    @Test
    public void testOneToManyInsert(){
        try {
            // 添加一个客户，为这个客户添加一个联系人
            // 1、创建客户和联系人对象
            Customer cus = new Customer();
            cus.setRelname("jd");

            LinkMan linkMan = new LinkMan();
            linkMan.setName("chenyi");

            // 2、在客户表示联系人，在联系人表示客户，也就是建立客户对象和联系人对象的关系
            cus.getLinkMen().add(linkMan);
            linkMan.setCustomer(cus);

            // 3、保存到数据
            session.save(cus);
            session.save(linkMan);

        }catch (Exception e){
            tx.rollback();
        }
    }

    // 测试一对多，级联删除
    @Test
    public void testOneToManyDelete(){

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

        //7、关闭资源和连接，实际上 sessionFactory是不需要关闭，如果是本地线程这种方式的，session也不需要关闭
        session.close();
        sessionFactory.close();

    }


    // 原始写法--本地线程
    @Test
    public void testAdd2(){

        Session session = HibernateUtils.getCurrentSessionObject();

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

    }

}
