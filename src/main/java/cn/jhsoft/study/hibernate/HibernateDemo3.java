package cn.jhsoft.study.hibernate;

import clojure.lang.Obj;
import cn.jhsoft.study.hibernate.entity.Customer;
import cn.jhsoft.study.hibernate.entity.LinkMan;
import cn.jhsoft.study.hibernate.entity.Order;
import cn.jhsoft.study.hibernate.many2manyentiy.Role;
import cn.jhsoft.study.hibernate.many2manyentiy.User;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by chenyi9 on 2017/8/16.
 */
public class HibernateDemo3 {

    // 测试 对象导航查询
    @Test
    public void testObjectNav(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Customer cus = session.get(Customer.class, 5);
            for (LinkMan linkMan : cus.getLinkMen()) {
                System.out.println(linkMan);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }


    // 测试 HQL查询
    @Test
    public void testHQL(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

//            Query query = session.createQuery("from Order");
            Query query = session.createQuery("from Order t1 where t1.id>? or t1.username = ?");
            // 如果是条件查询，还需要向?里设置值
            // setParameter方法第一个参数是 int，代表? 的位置，位置从0开始
            // 第二个参数，具体参数值
            query.setParameter(0, 11);
            query.setParameter(1, "sbsb");

            List<Order> list = query.list();
            for (Order order : list) {
                System.out.println(order);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }


    // 测试 HQL查询（Like）
    @Test
    public void testHQLLike(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

//            Query query = session.createQuery("from Order");
            Query query = session.createQuery("from Order t1 where t1.username like ? order by id desc");
            // 如果是条件查询，还需要向?里设置值
            // setParameter方法第一个参数是 int，代表? 的位置，位置从0开始
            // 第二个参数，具体参数值
            query.setParameter(0, "%c%");

            // 分页查询
            // 设置开始的位置，相当于limit 0,10中的0
            query.setFirstResult(0);
            // 设置每页记录数，相当于limit 0,10中的10
            query.setMaxResults(2);

            List<Order> list = query.list();
            for (Order order : list) {
                System.out.println(order);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }

    // 测试 HQL查询（投影）查询表中的部分字段
    @Test
    public void testHQLTouying(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Query query = session.createQuery("select username from Order t1 where t1.username like ? order by id desc");
            // 如果是条件查询，还需要向?里设置值
            // setParameter方法第一个参数是 int，代表? 的位置，位置从0开始
            // 第二个参数，具体参数值
            query.setParameter(0, "%c%");

            // 分页查询
            // 设置开始的位置，相当于limit 0,10中的0
            query.setFirstResult(0);
            // 设置每页记录数，相当于limit 0,10中的10
            query.setMaxResults(2);

            List<Object> list = query.list();
            for (Object obj : list) {
                System.out.println(obj);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }

    // 测试 HQL查询（聚集函数）
    @Test
    public void testHQLJuJi(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Query query = session.createQuery("select count(*) from Order");
            // query对象里有方法，直接返回对象形式
            Object obj = query.uniqueResult();
            // 把Object转为int
            Long lobj = (Long)obj;
            int count = lobj.intValue();
            System.out.println(count);

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }


    // 测试 QBC查询
    @Test
    public void testQBCAll(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Order.class);
            List<Order> list = criteria.list();
            for (Order order : list) {
                System.out.println(order);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }


    // 测试 QBC查询-条件
    @Test
    public void testQBCFilter(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Order.class);
            // 使用Criteria对象里的方法设置条件值
            // 首先使用add方法，表示设置条件值
            // 在add方法里使用类的方法来实现条件设置
            // 类似于 id=?，第一个参数是 实体里的属性名称，第二个参数是值
            criteria.add(Restrictions.eq("id", 17));
            //criteria.add(Restrictions.eq("username", "cjh123"));
            criteria.add(Restrictions.like("username", "%cjh%"));
            //Restrictions.gt()  大于
            //Restrictions.ge() 大于等于
            //Restrictions.lt() 小于
            //Restrictions.le() 小于等于
            //Restrictions.between() 对应sql的between子句
            //Restrictions.in() 对应sql的in子句
            //Restrictions.or() or
            //Restrictions.asc() 根据传入的字段升序
            //Restrictions.desc() 根据传入的字段降序

            List<Order> list = criteria.list();
            for (Order order : list) {
                System.out.println(order);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }




    // 测试 QBC查询-排序和分页
    @Test
    public void testQBCDesc(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Order.class);
            // 设置哪个字段来升序或降序排序
            criteria.addOrder(org.hibernate.criterion.Order.desc("username"));
            criteria.addOrder(org.hibernate.criterion.Order.asc("id"));
            // 分页,设置开始位置
            criteria.setFirstResult(0);
            // 设置每页记录数，与Hql相同
            criteria.setMaxResults(2);

            List<Order> list = criteria.list();
            for (Order order : list) {
                System.out.println(order);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }




    // 测试 QBC查询-统计查询
    @Test
    public void testQBCTongji(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Order.class);
            // 设置操作
            criteria.setProjection(Projections.rowCount());
            //criteria.setProjection(Projections.sum("id"));
            //criteria.setProjection(Projections.avg("id"));
            // 调用方法得到结果
            Object obj = criteria.uniqueResult();
            System.out.println(obj);

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }




    // 测试 QBC查询-离线查询
    @Test
    public void testQBCLixian(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            // 离线创建对象
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Order.class);
            // 执行的时候才需要session
            Criteria criteria = detachedCriteria.getExecutableCriteria(session);
            List<Order> list = criteria.list();
            for (Order order : list) {
                System.out.println(order);
            }

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }


    // 测试 HQL查询 内连接
    @Test
    public void testHQLInnerJoin(){
        Transaction tx = null;

        try {
            Session session = HibernateUtils.getCurrentSessionObject();

            //4、开启事务
            tx = session.beginTransaction();

            Query query = session.createQuery("from Customer c inner join c.linkMen");
            // 返回的list，list的每部分是数组形式。
            List list = query.list();

            Query query1 = session.createQuery("from Customer c inner join fetch c.linkMen");
            List list1 = query1.list();
            for (Object obj:list1){
                System.out.println(obj);
            }
            System.out.println(list1);

            tx.commit();


        }catch (Exception e){
            System.out.println(e.toString());
            tx.rollback();
        }
    }

}
