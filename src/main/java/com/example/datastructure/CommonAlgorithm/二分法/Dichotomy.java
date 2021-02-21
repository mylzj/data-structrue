package com.example.datastructure.CommonAlgorithm.二分法;

/**
 * @Description
 * 二分法
 * @Author mylzj
 * @Date 2021/2/21 20:44
 */
public class Dichotomy {
    public static void main(String[] args){
        int a[] = {1,2,3,4,4,4,5,6};
//        int i = searchFirst(a, 9);
        int i = search2(a, 4);
        System.out.println("index = "+ i);
    }

    // 取第一个等值
    private static int searchFirst(int[] a, int v) {
        int length = a.length;
        if (length == 0) {
            return 0;
        }
        int start = 0;
        int end = length - 1;
        while (end > start) {
            int middle = start + ((end - start) >> 1);
            if (a[middle] > v) {
                end = middle - 1;
            } else if(a[middle] < v){
                start = middle + 1;
            } else{
                // 如果前面那个不等于当前值，说明他就是第一个，或者他的下标是0也是说明他是第一个
                if(a[middle - 1] != v || middle == 0){
                    return middle;
                }
            }
        }
        return -1;
    }

    // 取最后一个等值
    public static int searchLast(int[] a, int v){
        int length = a.length;
        if (length == 0) {
            return 0;
        }
        int start = 0;
        int end = length - 1;
        while(end > start){
            int middle = start + ((end - start)>>1);
            if(a[middle]>v){
                end = middle-1;
            }else if(a[middle]<v){
                start=middle+1;
            }else{
                if((middle == length -1) || a[middle +1] !=v){
                    return middle;
                }
                start = middle+1;
            }

        }
        return -1;
    }

    // 取第一个大于等于的值
    public static int search1(int[] a, int v){
        int length = a.length;
        if (length == 0) {
            return 0;
        }
        int start = 0;
        int end = length - 1;
        while(end >= start){
            int middle = start + ((end - start)>>1);
            if(a[middle]>=v){
                if(middle == 0 || a[middle -1] < v){
                    return middle;
                }
                end = middle-1;
            }else {
                start=middle+1;
            }

        }
        return -1;
    }
    // 取最后一个小于等于的值
    public static int search2(int[] a, int v){
        int length = a.length;
        if (length == 0) {
            return 0;
        }
        int start = 0;
        int end = length - 1;
        while(end >= start){
            int middle = start + ((end - start)>>1);
            if(a[middle]<=v){
                if(middle == length-1 || a[middle +1] > v){
                    return middle;
                }
                start=middle+1;
            }else {
                end = middle-1;
            }

        }
        return -1;
    }
}
