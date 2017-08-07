package cn.jhsoft.study;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenyi9 on 2017/8/7.
 */
public class DateDemo {

    public static void main(String[] args) throws ParseException {

        Date date1 = new Date();
        System.out.println(date1);
        date1.setTime(1502086123966L);
        System.out.println(date1);

        Date date2 = new Date(System.currentTimeMillis());
        System.out.println(date2);
        System.out.println(date2.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date2));

        // 获取日期格式化对象，具有默认的风格
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(df.format(date2));
        DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        System.out.println(df1.format(date2));

        System.out.println(sdf.parse("2017-08-07 14:34:46"));


    }


}
