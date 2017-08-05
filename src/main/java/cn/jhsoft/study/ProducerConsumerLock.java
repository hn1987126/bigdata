package cn.jhsoft.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chen on 2017/8/5.
 *
 * 多生产多消费
 * 在单生产单消费的基础上，如果直接用它的代码，多生产会出现问题。会存在重复消费和重复生产的问题
 * 锁对象Lock
 * Lock代替了synchronized
 * condition 代替了object锁名
 *
 * jdk1.5之后，把同步代码块，这种隐式锁，替换成了Lock对象，将隐式动作变成了显式动作(封装到lock对象的方法中了)
 *
 */
class Resourcess{
    private String name;
    private int count = 1;
    private boolean flag = false;   // 是否生产完成(如果消费完成了，这个应该是否，因为又要重新生产了)

    // 锁对象
    Lock lock = new ReentrantLock();
    // 监视器
    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    // 生产者会调用 这个方法来生产
    public void set(String name){

        // 拿到锁
        lock.lock();
        try {

            while (flag)
                try {
                    producer_con.await();
                } catch (InterruptedException e) {
                }

            this.name = name + count;
            System.out.println(Thread.currentThread().getName() + "生产了" + name + count++);

            flag = true;
            // 唤醒消费者
            consumer_con.signal();

        }finally {
            // 释放锁
            lock.unlock();
        }
    }

    // 消费者会调这个方法来消费
    public void out(){
        lock.lock();
        try {

            while (!flag)
                try {
                    consumer_con.await();
                } catch (InterruptedException e) {
                }

            System.out.println(Thread.currentThread().getName() + "消费了--------------" + name);

            flag = false;
            // 唤醒生产者
            producer_con.signal();

        }finally {
            lock.unlock();
        }
    }
}

// 生产线程
class Producers implements Runnable{

    Resourcess r;

    public Producers(Resourcess r){
        this.r = r;
    }

    @Override
    public void run() {
        while (true)
            r.set("烤鸭");
    }
}

// 消费线程
class Consumers implements Runnable{

    Resourcess r;

    public Consumers(Resourcess r){
        this.r = r;
    }

    @Override
    public void run() {
        while (true)
            r.out();
    }
}


public class ProducerConsumerLock {

    public static void main(String[] args) {
        Resourcess r = new Resourcess();
        Producers p = new Producers(r);
        Consumers c = new Consumers(r);

        // t0,t1两个生产者，t2,t3两个消费者
        Thread t0 = new Thread(p);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t0.start();
        t1.start();
        t2.start();
        t3.start();

    }

}
