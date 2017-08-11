package cn.jhsoft.study.obj;

/**
 * Created by chenyi9 on 2017/8/11.
 * 需求：
 * 雇员示例
 * 需求：公司中程序员有姓名，工号，薪水，工作内容
 * 项目经理除了有这些，还有奖金
 * 对给出需求进行数据建模。
 *
 *
 *
 */

/**
 * 雇员类
 */
abstract class Employee{
    private String name;
    private String id;
    private double pay;
    Employee(String name, String id, double pay){
        this.name = name;
        this.id = id;
        this.pay = pay;
    }
    public abstract void work();
}

/**
 * 程序员类
 */
class Programmer extends Employee{

    Programmer(String name, String id, double pay){
        super(name, id, pay);
    }

    @Override
    public void work() {
        System.out.println("codding...");
    }
}

/**
 * 经理类
 */
class Manager extends Employee{

    // 自己特有的属性
    private double jiangjin;

    Manager(String name, String id, double pay, double jiangjin){
        super(name, id, pay);
        this.jiangjin = jiangjin;
    }

    @Override
    public void work() {
        System.out.println("manager...");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Programmer pro = new Programmer("陈义", "001", 100);
        pro.work();
        Manager man = new Manager("宫海涛", "002", 200, 300);
        man.work();
    }
}
