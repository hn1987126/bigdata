package cn.jhsoft.study.other;

import scala.runtime.Int;

import java.util.Arrays;

/**
 * Created by chen on 2017/8/12.
 */
public class ArrayDemo {

    public static void main(String[] args) {
        int arr[] = {34, 19, 11, 109, 3, 56};
        show(arr);


        //System.out.println(arr[3]);
//        arr = null;
//        System.out.println(arr);

        // 选择排序
//        selectSort(arr);

        // 冒泡排序
//        bubbleSort(arr);

//        Arrays.sort(arr);

        // 选择排序 提高性能
//        selectSort1(arr);

        // 折半查找。这要求被查找的数组是排好序的。专业叫法 二分查找法
        int arr1[] = {1,2,3,4,5,6,30,45,55,60};
        int index = binarySearch(arr1, 33);
        System.out.println(index);

        int a = Arrays.binarySearch(arr1, 45);
        System.out.println(a);

        show(arr);

    }

    /**
     * 二分查找、折半查找
     *
     * @param arr
     */
    private static int binarySearch(int[] arr, int searchNum) {
        int min = 0;  // 最小角标，它在循环过程中会不断往右跑
        int max = arr.length - 1;  // 最大角标，它在循环过程中不断往左跑
        int middle = (min + max)/2;  // 最中间的角标
        while (arr[middle] != searchNum) {
            if (searchNum > arr[middle]) { // 比最中间的那个数大，说明在右半边
                min = middle + 1;
            } else if (searchNum < arr[middle]) {
                max = middle - 1;
            }

            if (max < min){  //这说明是找不到，没有再折半的必要。
                return -1;
            }
            middle = (min+max)/2;
        }

        return middle;
    }


    /**
     * 选择排序
     * 大圈套小圈的原理
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 第一轮：从第一个 与后面所有的比一遍，把最大的放在了最后一位了。
     * 第二轮：最后一个数字就不需要参与比较了。再按第一轮一样的方式再打一轮。
     * 也是 大圈套小圈的原理
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // i 控制外面大圈的圈数
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) { // j控制内圈两个相邻变量之间的对比。中间的j<arr.length-1-i  这个-i 是为了外循环一轮，内圈就少一个，因为最后面的已经不需要参与比较了。
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序性能提升
     * 大圈套小圈的原理
     * @param arr
     */
    public static void selectSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // num和index是用来记录外圈循环时，每一轮循环时的最小值， 初始值是第i个元素
            int num = arr[i]; // 记录最小值
            int index = i; // 记录最小值所在的位置
            for (int j = i+1; j < arr.length; j++) {
                if (num > arr[j]){
                    num = arr[j];
                    index = j;
                }
            }

            // 一个外圈循环只交换一次位置
            if (i != index) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
    }

    /**
     * 显示数组
     * @param arr
     */
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


}
