package cn.jhsoft.study.hibernate.entity;

/**
 * Created by chenyi9 on 2017/8/15.
 */
public class Order {

    /*hibernate要求实体类有一个属性唯一*/
    private int id;

    private String username;

    private int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                '}';
    }
}
