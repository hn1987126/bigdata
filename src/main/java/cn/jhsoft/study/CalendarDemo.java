package cn.jhsoft.study;

import java.util.Calendar;

/**
 * Created by chenyi9 on 2017/8/7.
 */
public class CalendarDemo {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, 2019);

        // 加两天,减2天是 -2
        cal.add(Calendar.DAY_OF_MONTH, 2);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1; // 这样获取会比当前真正月小1，需要加1
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int week = cal.get(Calendar.DAY_OF_WEEK); // 老外的星期日是1，星期一是2
        // 加两年,减2年是 -2
        cal.add(Calendar.DAY_OF_MONTH, 2);

        System.out.println(year+"年"+month+"月"+day+"日,星期"+week);

        System.out.println(cal.getWeeksInWeekYear());
        System.out.println(cal.get(Calendar.YEAR));
    }

}
