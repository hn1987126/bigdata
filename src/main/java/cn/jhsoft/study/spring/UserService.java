package cn.jhsoft.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chenyi9 on 2017/8/14.
 */
//@Service("userService")
public class UserService {

    // Autowired自动装配get和set方法
    @Autowired
    //@Resource(name="userDao")
    private UserDao userDao;

    // 用注解方式，可以不需要set和get方法，会自动生成
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void add(){
        System.out.println("service add");
        userDao.add();

    }

}
