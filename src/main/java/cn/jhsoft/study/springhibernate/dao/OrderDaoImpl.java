package cn.jhsoft.study.springhibernate.dao;

import cn.jhsoft.study.hibernate.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenyi9 on 2017/8/16.
 */
@Component("orderDao")
public class OrderDaoImpl implements OrderDao {

    // 得到hibernateTemplate对象，写Autowired 后就已经有值了，因为在spring配置文件里进行了对象的创建。
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void add() {
        // 调用里面的save方法实现添加
        Order order = new Order();
        order.setUsername("spring");
        order.setSalary(20000);
        hibernateTemplate.save(order);

        // get方法
        Order o = hibernateTemplate.get(Order.class, 1);
        System.out.println(o);

        // find方法查询所有记录，find方法全是返回List
        // 第一个参数是hql语句，第二个参数是语句中参数的值（可变参数）
        List<Order> list = (List<Order>)hibernateTemplate.find("from Order");
        for (Order order1:list){
            System.out.println(order1);
        }

        // find条件查询
        List<Order> list2 = (List<Order>)hibernateTemplate.find("from Order where id=?", 1);
        for (Order order1:list2){
            System.out.println(order1);
        }

    }
}
