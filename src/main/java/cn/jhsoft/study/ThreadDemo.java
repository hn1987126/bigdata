package cn.jhsoft.study;

/**
 * Created by chenyi9 on 2017/8/4.
 */
class Demo1 extends Object{
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("gc demo");
    }
}

class ThreadDemo{
    public static void main(String[] args){
        new Demo1(); // 匿名类产生垃圾
        System.gc();
        System.out.println("main ok");
    }
}

// ----------------------------------------------------------------------------------------------------------------
// 多线程
/**
 一共有3个线程，主线程+两个子线程，cpu在他们之间来回切，所以看到的执行顺序是随机的。
 */

class Demo2 extends Thread{
    String name;
    Demo2(String name){
        // 调用父类构造方法，可以传个线程名称给他，以后线程名称就是自定义了
        //super(name);
        this.name = name;
    }

    @Override
    public void run() {
        show();
    }

    public void show(){
        for(int i=0; i<10; i++){
            System.out.println(name+"-----"+i+"--线程名称："+getName()+"，当前运行的线程："+Thread.currentThread().getName());
        }
    }
}

class Demo3 implements Runnable{
    String name;
    Demo3(String name){
        // 调用父类构造方法，可以传个线程名称给他，以后线程名称就是自定义了
        //super(name);
        this.name = name;
    }

    @Override
    public void run() {
        show();
    }

    public void show(){
        for(int i=0; i<10; i++){
            System.out.println(name+"-----"+i+"--当前运行的线程："+Thread.currentThread().getName());
        }
    }
}

class ThreadDemo1{
    public static void main(String[] args) {
//        Demo2 ght = new Demo2("ght");
//        Demo2 xiaoqiang = new Demo2("xiaoqiang");
//        ght.show();
//        xiaoqiang.show();

        /**
         创建线程的目的是为了开启一条执行路径，去运行指定代码，与其他代码实现同时进行
         而运行的指定代码就是这个执行路径的任务
         jvm创建的主线程的任务都定义在主函数中
         而自定义的线程，他的任务在哪？
         Thread类用于描述线程，线程是需要任务的。所以Thread类也是对任务的描述
         这个任务通过Thread类中的run方法来体现，也就是说，run方法就是封装自定义线程运行任务的函数。

         run方法中 就是线程要运行的线程代码
         开启线程是为了运行指定代码，所以只有继承Thread类，并复写run方法。
         将运行的代码放在run方法中即可。

         */

//        //匿名类
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                System.out.println("thread");
//            }
//        }.start();

        Demo2 ght = new Demo2("ght");
        Demo2 xiaoqiang = new Demo2("xiaoqiang");
        ght.start();
        xiaoqiang.start();

        for(int x=0; x<20; x++){
            System.out.println(x+"--"+Thread.currentThread().getName());
        }

        //------------------------------------------------------------------------------------------

        /**
         用Thread来创建对象，对象的start方法来执行。创建对象时构造方法里传一个实现了Runnable接口的对象进去。
         */
        // 匿名类，实现Runnable接口这种形式的。
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("runnable");
//            }
//        }).start();

        // Thread构造方法可以传第二个参数进去，那个参数是 线程名称。
        Thread t1 = new Thread(new Demo3("ght"));
        Thread t2 = new Thread(new Demo3("xiaoqiang"));
        t1.start();
        t2.start();

    }
}

