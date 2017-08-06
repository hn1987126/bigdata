package cn.jhsoft.study.sort;

/**
 * Created by chen on 2017/8/6.
 */

import cn.jhsoft.study.bean.Student;

import java.util.Comparator;

/**
 * 比较器，需要实现Comparator接口
 */
public class ComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        int temp = s1.getName().compareTo(s2.getName());
        return temp == 0 ? s1.getAge() - s2.getAge() : temp;
    }
}
