package cn.jhsoft.study;

/**
 * Created by chen on 2017/8/5.
 *
 * 多线程处理同一资源，但是任务不同
 *
 */

// 输入和输出共用的资源
class Resource{

    String name;
    String sex;
    Boolean flag = false;  // 是否完成输入

}


// 输入线程
class Input implements Runnable{

    Resource r;

    public Input(Resource r){
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true){

            // 同步代码块
            synchronized(r) {

                // 如果完成输入了则等待
                if (r.flag)
                    try { r.wait(); } catch (InterruptedException e) {}

                if (x == 0) {
                    r.name = "ght";
                    r.sex = "nan";
                } else {
                    r.name = "丽丽";
                    r.sex = "女女女女女女";
                }
                x = (x + 1) % 2;

                // 输入完后，把状态置为完成输入
                r.flag = true;
                // 唤醒 与本锁 同一锁 里别的线程
                r.notify();

            }
        }
    }
}

// 输出线程
class Output implements Runnable{

    Resource r;

    public Output(Resource r){
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            synchronized(r) {
                // 未完成输入，则输出线程要等待
                if (!r.flag)
                    try { r.wait(); } catch (InterruptedException e) {}

                System.out.println(r.name + "---" + r.sex);

                // 输出完成后，把状态置为未完成输入，别人又可以重新输入了
                r.flag = false;
                // 唤醒输入线程
                r.notify();

            }
        }
    }
}


public class ResourceInputOutput {

    public static void main(String[] args) {
        Resource r = new Resource();
        Input input = new Input(r);
        Output output = new Output(r);
        Thread t1 = new Thread(input);
        Thread t2 = new Thread(output);

        t1.start();
        t2.start();
    }

}
