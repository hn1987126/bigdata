package cn.jhsoft.study;

/**
 * Created by chenyi9 on 2017/8/4.
 */
class Ticket implements Runnable{
    private int num = 10;

    public void run(){
        while (true){

            // 同步代码块解决线程安全问题
//            synchronized (this){
                show();
//            }
        }
    }

    public synchronized void show(){
        if (num > 0) {
            try {
                // 加个休眠 或者别的语句，那cpu就可能切走了，在没有减之前，别的线程就进来了，就会 有-1
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "----," + num--);
            } catch (Exception ex) {}
        }
    }
}

public class SellTicket {
    public static void main(String[] args) {
//
//        Ticket ticket = new Ticket();
//        Thread t = new Thread(ticket);
//        Ticket ticket1 = new Ticket();
//        Thread t1 = new Thread(ticket1);
//        Ticket ticket2 = new Ticket();
//        Thread t2 = new Thread(ticket2);
//        Ticket ticket3 = new Ticket();
//        Thread t3 = new Thread(ticket3);

        // Ticket 类只负责 写任务代码
        Ticket ticket = new Ticket();
        // 4个线程 用同一个任务
        Thread t = new Thread(ticket);
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
