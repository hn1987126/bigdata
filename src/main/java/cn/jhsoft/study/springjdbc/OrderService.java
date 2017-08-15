package cn.jhsoft.study.springjdbc;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenyi9 on 2017/8/15.
 */
// 对OrderService类下的所有方法进行事务管理
@Transactional
public class OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 调用dao方法
     * 业务逻辑层，写转账业务
     */
    public void accountMoney(){
        // chenyi少100
        orderDao.lessMoney();

        //int i = 10/0;

        // gonghaitoa多100
        orderDao.moreMoney();
    }
}
