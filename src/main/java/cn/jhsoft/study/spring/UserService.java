package cn.jhsoft.study.spring;

/**
 * Created by chenyi9 on 2017/8/14.
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add");
        userDao.add();

    }

}
