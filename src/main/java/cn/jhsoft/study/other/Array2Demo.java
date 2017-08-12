package cn.jhsoft.study.other;

/**
 * Created by chen on 2017/8/12.
 */
public class Array2Demo {

    public static void main(String[] args) {
        // 创建一个二维数组，该数组中有2个一维数组，每个一维数组中有2个元素。
        int[][] a = new int[2][3];
        int[][] b = {{1,2,3},{4,5,6}};
        a[1][2] = 1;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println(b[i][j]);
            }
        }
        System.out.println(a);

        // 另外一种创建的方式
        int[][] c = new int[2][]; // 列可以不限定，这里是创建了一个二维数组，他有两行。也就是创建了两个一维数组。
        System.out.println(c);  // 打印出   [[I@xxx
        System.out.println(c[0]);   // 打印出  null
        System.out.println(c[0][0]);  // 编译没问题，运行时会出现下标越界的异常。
        c[0] = new int[2];
        c[1] = new int[3];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.println(c[i][j]);
            }
        }

    }

}
