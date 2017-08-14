package cn.jhsoft.study.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chenyi9 on 2017/8/14.
 */

@Component(value = "user")
@Scope(value = "prototype")
public class User {
    private String uname;

    private String[] arrs;

    private List<String> list;

    private Map<String, String> map;

    private Properties pro;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String[] getArrs() {
        return arrs;
    }

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getPro() {
        return pro;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }

    public void test1(){
        System.out.println("arrs："+arrs);
        System.out.println("list："+list);
        System.out.println("map："+map);
        System.out.println("pro："+pro);
        System.out.println("uname："+uname);
    }
}
