package cn.jhsoft.study.hibernate.many2manyentiy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyi9 on 2017/8/16.
 */
public class Role {
    private Integer id;
    private String name;

    // 一个角色 多个用户
    private Set<User> user = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
