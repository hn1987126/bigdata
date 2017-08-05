package cn.jhsoft.study;

/**
 * Created by chen on 2017/8/5.
 * 生产者消费者
 * 需要  生产一只消费一只，消费完了才能再生产。生产好了才能消费
 *
 * 多生产多消费
 * 在单生产单消费的基础上，如果直接用它的代码，多生产会出现问题。会存在重复消费和重复生产的问题
 *
 * 解决1：
 * 因为 notify 的时候，是同锁里任意一个线程，可能生产唤醒了生产，而被唤醒的时候，他不会再判断 flag，因为他是在wait那条语句那醒。只会执行之后的代码，所以导致生产了，再生产。
 * 还没经过消费，解决问题的办法，是把if判断标记，改为while语句，这样的话，醒了后还会再判断标记。
 *
 * 解决2：
 * notify的时候，只能唤醒一个线程，如果本方唤醒了本方，是没有意义的，这会导致死锁(因为有while在那，会循环等待)，只有唤醒对方才有效。
 * 但是没有唤醒对方的方法，只有唤醒全部。唤醒全部也没事，因为再进去会有flag判断，如果不满意，还是等待。
 * 所以用 notifyAll 方法来解决。
 *
 *
 * jdk1.5之后，把同步代码块，这种隐式锁，替换成了Lock对象，将隐式动作变成了显式动作(封装到lock对象的方法中了)
 *
 */
class Resources{
    private String name;
    private int count = 1;
    private boolean flag = false;   // 是否生产完成(如果消费完成了，这个应该是否，因为又要重新生产了)

    // 生产者会调用 这个方法来生产
    public synchronized void set(String name){
        // if是单生产时用，while是多生产时用
//        if (flag)
        while (flag)
            try { this.wait(); } catch (InterruptedException e) {}

        this.name = name+count;
        System.out.println(Thread.currentThread().getName()+"生产了"+name+count++);

        flag = true;
//        notify();
        notifyAll();
    }

    // 消费者会调这个方法来消费
    public synchronized void out(){
        // if是单生产时用，while是多生产时用
//        if (!flag)
        while (!flag)
            try { this.wait(); } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName()+"消费了--------------"+name);

        flag = false;
        // notify是单生产时用，notifyAll是多生产时用
//        notify();
        notifyAll();
    }
}

// 生产线程
class Producer implements Runnable{

    Resources r;

    public Producer(Resources r){
        this.r = r;
    }

    @Override
    public void run() {
        while (true)
            r.set("烤鸭");
    }
}

// 消费线程
class Consumer implements Runnable{

    Resources r;

    public Consumer(Resources r){
        this.r = r;
    }

    @Override
    public void run() {
        while (true)
            r.out();
    }
}


public class ProducerConsumer {

    public static void main(String[] args) {
        Resources r = new Resources();
        Producer p = new Producer(r);
        Consumer c = new Consumer(r);

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
