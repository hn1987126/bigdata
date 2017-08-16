package cn.jhsoft.study.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyi9 on 2017/8/16.
 */
public class Customer {

    private Integer id;
    private String relname;

    // 一对多，用Set集合来表示 多个联系人
    private Set<LinkMan> linkMen = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    public Set<LinkMan> getLinkMen() {
        return linkMen;
    }

    public void setLinkMen(Set<LinkMan> linkMen) {
        this.linkMen = linkMen;
    }

}
