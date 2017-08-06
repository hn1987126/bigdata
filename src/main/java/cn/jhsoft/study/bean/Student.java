package cn.jhsoft.study.bean;

/**
 * Created by chen on 2017/8/6.
 */
public class Student extends Person implements Comparable<Student>{

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // 覆盖比较方法
    @Override
    public int compareTo(Student s) {
        // this是当前的元素，o是拿过来比较的元素，也就是第二+个
//        if (this.age > s.age) {
//            return 1;
//        } else if (this.age < s.age) {
//            return -1;
//        }else
//            return this.name.compareTo(s.name);

        // 方法二：
        int temp = this.age - s.age;
        return temp == 0 ? this.name.compareTo(s.name) : temp;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
