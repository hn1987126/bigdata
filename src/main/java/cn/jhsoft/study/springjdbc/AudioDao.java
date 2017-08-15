package cn.jhsoft.study.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by chenyi9 on 2017/8/15.
 */
@Component("audioDao")
public class AudioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(){
        String sql = "insert into tbl_audio values(?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql, null, "1005", "http://www.jd.com", "jd.com", "md5");
        System.out.println(rows);
    }

}
