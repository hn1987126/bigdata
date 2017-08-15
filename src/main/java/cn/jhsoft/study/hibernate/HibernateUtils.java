package cn.jhsoft.study.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by chen on 2017/8/15.
 */
public class HibernateUtils {

    private static Configuration cfg = null;
    private static SessionFactory sessionFactory = null;
    private static Session session = null;
    private static Transaction transaction = null;

    // 静态代码块
    static {
        // 1、加载hibernate核心配置文件
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    // 2、获取SessionFactory对象
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //3、使用SessionFactory创建session对象（与web项目里的session完全不同，本身不是一个东西）
    // session是单线程对象，不能共用，只能自己用
    public static Session getSession() {
        return session;
    }

    //4、开启事务
    public static Transaction getTransaction() {
        return transaction;
    }


}
