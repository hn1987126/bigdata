package cn.jhsoft.study.hibernate.many2manyentiy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyi9 on 2017/8/16.
 */
public class User {
    private Integer id;
    private String name;

    // 一个用户多个角色
    private Set<Role> role = new HashSet<>();

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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
