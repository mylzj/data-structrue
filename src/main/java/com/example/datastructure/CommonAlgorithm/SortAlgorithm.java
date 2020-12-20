package com.example.datastructure.CommonAlgorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 常用排序算法实现
 * @Author mylzj
 * @Date 2020/12/20 14:58
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 7, 1};
//        insertSort(a);
//        selectSort(a);
        bubbleSort(a);
        for (int i : a) {
            System.out.print(i);
        }
    }

    public static void insertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 第一个未排序的变量
            int temp = a[i];
            int j = i;
            // 与已经排序的变量中做比较,第二个循环实际上是做数据迁移
            // 即在做比较的时候，将已经排序的数据往前诺一位
            for (; j > 0; j--) {
                if (temp < a[j - 1]) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j] = temp;
        }
    }

    public static void selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    index = j;
                }
            }
            int temp1 = a[i];
            a[i] = a[index];
            a[index] = temp1;
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n-1-i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
