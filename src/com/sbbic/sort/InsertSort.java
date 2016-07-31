package com.sbbic.sort;

/**
 * Created by God on 2016/3/10.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2};

        sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }


    public static void sort1(int[] arr) {
        int n = arr.length;
        int i, j, k;
        for (i = 1; i < n; i++) {
            //在[0...i-1]区间内查找元素arr[i]待插入的位置
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    break;
                }
            }
            //如果找了待插入的位置
            if (j != i - 1) {
                int temp = arr[i];
                //比a[i]大的数据往后移动
                for (k = i - 1; k > j; k--) {
                    arr[k + 1] = arr[k];
                }
                //将a[i]放在待插入的位置
                arr[k + 1] = temp;
            }

        }

    }


    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
