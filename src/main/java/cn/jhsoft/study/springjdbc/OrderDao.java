package cn.jhsoft.study.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by chenyi9 on 2017/8/15.
 */
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 做对数据库操作的方法 ，不管业务方法
     * chenyi 少钱的方法
     */
    public void lessMoney(){
        String sql = "update tbl_order set salary=salary-? where username='chenyi'";
        int rows = jdbcTemplate.update(sql, 100);
        System.out.println(rows);
    }

    /**
     * gonghaitao 多钱的方法
     */
    public void moreMoney(){
        String sql = "update tbl_order set salary=salary+? where username='gonghaitao'";
        int rows = jdbcTemplate.update(sql, 100);
        System.out.println(rows);
    }

}
