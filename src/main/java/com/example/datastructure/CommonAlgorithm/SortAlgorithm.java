package com.example.datastructure.CommonAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Description 常用排序算法实现
 * @Author mylzj
 * @Date 2020/12/20 14:58
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] a = new int[]{9, 7, 11, 6, 8};
//        insertSort(a);
//        selectSort(a);
//        bubbleSort(a);

        quickSort(a);
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
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void quickSort(int[] a) {
        // 快排也是递归的一种体现，快排的思想就是，在集合里面随机取一个数，然后与这个数作比较，比这个数小的放左边，
        // 比这个数大的放右边。然后以这个数为节点，重新排序左边和右边。以此递归，最后合并成一个。
        // 确定递归思想，推出递归公式，sort(Array(n)) = sort(Array(0,i-1))+sort(Array(i,n))

        int n = a.length;
        merge(a, 0, n - 1);


    }

    private static void merge(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        // 找出中间节点i，随机生成一个
        Random random = new Random();
        int part = start + random.nextInt(end - start+1);
        // 将中间节点先放在最后面
        swap(a, part, end);

        // 使用挡板发进行比较，交换
        int i = start;
        int j = end - 1;
        int temp = a[end];
        while (i <= j) {
            if (a[i] <= temp) {
                i++;
            } else {
                swap(a, i, j);
                j--;
            }
        }
        swap(a,i,end);
        merge(a, start, i - 1);
        merge(a, i, end);
    }

    private static void swap(int[] a, int start, int end) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }

}
