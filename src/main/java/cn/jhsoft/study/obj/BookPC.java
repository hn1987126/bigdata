package cn.jhsoft.study.obj;

/**
 * Created by chen on 2017/8/11.
 * 笔记本电脑USB接口
 */

// usb接口，实现了这个接口的设备，才能在电脑上使用。
interface USB{// 暴露的规则
    public void open();
    public void close();
}

// u盘设备。实现规则，这些设备和电脑的耦合性降低了。
class Upan implements USB{

    @Override
    public void open() {
        System.out.println("upan open");
    }

    @Override
    public void close() {
        System.out.println("upan close");
    }
}

// 笔记本里的USB接口，实现了usb接口的设备才能用它。
public class BookPC {
    public static void main(String[] args) {
        // 功能扩展
        useUSB(new Upan());
    }

    // 使用规则
    public static void useUSB(USB u){  //接口类型的引用，用于接收（指向）接口的子类对象
        u.open();
        u.close();
    }
}
