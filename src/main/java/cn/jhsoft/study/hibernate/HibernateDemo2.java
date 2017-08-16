package cn.jhsoft.study.hibernate;

import cn.jhsoft.study.hibernate.entity.Customer;
import cn.jhsoft.study.hibernate.entity.LinkMan;
import cn.jhsoft.study.hibernate.entity.Order;
import cn.jhsoft.study.hibernate.many2manyentiy.Role;
import cn.jhsoft.study.hibernate.many2manyentiy.User;
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
import java.util.List;

/**
 * Created by chenyi9 on 2017/8/16.
 */
public class HibernateDemo2 {

    // 测试一对多，级联保存
    @Test
    public void testOneToManyInsert(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 添加一个客户，为这个客户添加一个联系人
            // 1、创建客户和联系人对象
            Customer cus = new Customer();
            cus.setRelname("jd");

            LinkMan linkMan = new LinkMan();
            linkMan.setName("chenyi");

            // 2、在客户中表示联系人，在联系人表示客户，也就是建立客户对象和联系人对象的关系
            cus.getLinkMen().add(linkMan);
            linkMan.setCustomer(cus);

            // 3、保存到数据
            session.save(cus);
            session.save(linkMan);

            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }
    }


    // 测试一对多，级联保存 简化写法
    @Test
    public void testOneToManyInsert2(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 添加一个客户，为这个客户添加一个联系人
            // 1、创建客户和联系人对象
            Customer cus = new Customer();
            cus.setRelname("yidao");

            LinkMan linkMan = new LinkMan();
            linkMan.setName("sxs");

            // 2、在客户中表示联系人
            cus.getLinkMen().add(linkMan);

            // 3、保存到数据
            session.save(cus);

            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }
    }

    // 测试一对多，级联删除
    @Test
    public void testOneToManyDelete(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 1、查询对象
            Customer cus = session.get(Customer.class, 1);
            // 2、删除
            session.delete(cus);

            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }
    }

    // 测试一对多，改联系人的外键值，也就是他所属的客户
    @Test
    public void testOneToManyUpdate(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 1、查询客户对象
            Customer cus = session.get(Customer.class, 5);
            // 2、查询联系人对象，把此联系人的 客户ID 改为上面查询到的那个客户。
            LinkMan linkMan = session.get(LinkMan.class, 5);
            // 设置持久态对象
            // 把联系人放到客户里
            cus.getLinkMen().add(linkMan);
            // 把客户放到联系人里
            linkMan.setCustomer(cus);

            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }
    }



    // 测试多对多，同时添加用户和角色
    @Test
    public void testManyToManyInsert(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 多对多级联保存
            User user = new User();
            user.setName("cy1");
            User user2 = new User();
            user2.setName("ght1");

            Role role = new Role();
            role.setName("administrator1");
            Role role2 = new Role();
            role2.setName("admin1");

            user.getRole().add(role);
            user.getRole().add(role2);
            user2.getRole().add(role);
            user2.getRole().add(role2);

            // 保存两个用户，不用管角色，因为已经配置了set 的cascade="save-update"属性
            session.save(user);
            session.save(user2);

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }

    // 测试多对多，级联删除
    @Test
    public void testManyToManyDelete(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 先查再删
            User user = session.get(User.class, 1);
            session.delete(user);

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }



    // 测试多对多，维护第三张表，添加
    @Test
    public void testManyToManyThirdTableInsert(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 让某个用户有某个角色
            // 让ght有administrator1角色
            // 1 查询用户和角色对象
            User user = session.get(User.class, 2);
            Role role = session.get(Role.class, 4);
            // 添加操作
            user.getRole().add(role);

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }



    // 测试多对多，维护第三张表，删除
    @Test
    public void testManyToManyThirdTableDelete(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 让某个用户没有某个角色
            // 让ght没有administrator1角色
            // 1 查询用户和角色对象
            User user = session.get(User.class, 2);
            Role role = session.get(Role.class, 4);
            // 移除操作
            user.getRole().remove(role);

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }
}
