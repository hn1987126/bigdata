package cn.jhsoft.study.springhibernate.service;

import cn.jhsoft.study.springhibernate.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenyi9 on 2017/8/16.
 */
@Service("orderService")
@Transactional
public class OrderService {

    // 这个会自动注解进来，意思是，orderDao这个 就已经在 OrderDaoImpl里创建了，因为那个类上方有个  @Component("orderDao")
    @Autowired
    private OrderDao orderDao;

    public void add(){
        System.out.println("service add");
        orderDao.add();
    }

}
