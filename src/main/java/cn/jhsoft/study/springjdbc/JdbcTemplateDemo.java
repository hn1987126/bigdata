package cn.jhsoft.study.springjdbc;

import cn.jhsoft.study.spring.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chenyi9 on 2017/8/15.
 */
public class JdbcTemplateDemo {

    // 设置数据库信息
    DriverManagerDataSource dataSource;

    // 创建jdbcTemplate对象
    JdbcTemplate jdbcTemplate;

    @Before
    public void before(){
        // 设置数据库信息
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///artime365");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 创建jdbcTemplate对象
        jdbcTemplate = new JdbcTemplate(dataSource);

        // 调用jdbcTemplate对象
    }

    @Test
    public void testAdd(){
        String sql = "insert into tbl_audio values(?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql, null, "1004", "http://www.jd.com", "jd.com", "md5");
        System.out.println(rows);
    }

    @Test
    public void testUpdate(){
        String sql = "update tbl_audio set code_url=? where id=?";
        int rows = jdbcTemplate.update(sql, "www.jd.com", 6);
        System.out.println(rows);
    }

    @Test
    public void testDelete(){
        String sql = "delete from tbl_audio where id>=?";
        int rows = jdbcTemplate.update(sql, 4);
        System.out.println(rows);
    }

    // 查询表有多少条记录
    @Test
    public void testQueryCount(){
        String sql = "select count(*) from tbl_audio";
        // queryForObject第一个是sql,第二个是返回值类型
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    // 查询表返回单个对象
    @Test
    public void testQueryObject(){
        String sql = "select * from tbl_audio where id = ?";
        // queryForObject第一个是sql,
        // 第二个是接口RowMapper，需要自己写实现类实现接口，自己做数据封装。类似dbutils里面的接口
        // 第三个参数是 可变参数
        Audio audio = jdbcTemplate.queryForObject(sql, new MyRowMapper(), 1);
        System.out.println(audio);
    }

    // 查询表返回List集合
    @Test
    public void testQueryList(){
        String sql = "select * from tbl_audio where id>=?";
        // queryForObject第一个是sql,
        // 第二个是接口RowMapper，需要自己写实现类实现接口，自己做数据封装。类似dbutils里面的接口
        // 第三个参数是 可变参数
        List<Audio> list = jdbcTemplate.query(sql, new MyRowMapper(), 1);
        for (Audio audio : list){
            System.out.println(audio.getId()+"-"+audio.getUrl());
        }
    }

    // c3p0连接池测试
    @Test
    public void testC3P0(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_c3p0.xml");
        AudioService audioService = (AudioService)context.getBean("audioService");
        audioService.add();
    }

    // 转帐测试
    @Test
    public void testOrder(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_all.xml");
        OrderService orderService = (OrderService)context.getBean("orderService");
        orderService.accountMoney();
    }

    // 转帐测试(注解方式)
    @Test
    public void testOrderZhuJie(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_all_Zhujie.xml");
        OrderService orderService = (OrderService)context.getBean("orderService");
        orderService.accountMoney();
    }

}

/**
 * RowMapper接口
 */
class MyRowMapper implements RowMapper<Audio>{
    @Override
    public Audio mapRow(ResultSet rs, int rowNum) throws SQLException {
        // 1、从结果集里把数据得到
        String url = rs.getString("url");
        String code_url = rs.getString("code_url");
        int id = rs.getInt("id");
        int count_id = rs.getInt("count_id");
        String count_id_md5 = rs.getString("count_id_md5");


        // 2、把得到的数据封装到对象里
        Audio audio = new Audio();
        audio.setId(id);
        audio.setUrl(url);
        audio.setCode_url(code_url);
        audio.setCount_id(count_id);
        audio.setCount_id_md5(count_id_md5);

        return audio;
    }
}


