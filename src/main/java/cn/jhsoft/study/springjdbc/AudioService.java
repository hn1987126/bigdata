package cn.jhsoft.study.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenyi9 on 2017/8/15.
 */
@Service("audioService")
public class AudioService {

    @Autowired
    private AudioDao audioDao;

    public void add(){
        audioDao.add();
    }

}
