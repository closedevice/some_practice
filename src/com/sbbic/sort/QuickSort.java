package com.sbbic.sort;

/**
 * Created by God on 2016/3/5.
 * 快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 4, 6, 20, 3,5};
        QuickSort.srot(arr);

        for (int i : arr) {
            System.out.printf(" " +
                    i);
        }
    }
    public static void srot(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    public static int partion(int[] arr, int lo, int hi) {
        int part = arr[lo];
        int left=lo;
        int right=hi+1;

        while (true) {
            while (less(arr[++left],part))
            {
                if (left == hi)
                    break;

            }
            while (less(part, arr[--right])) {
                if(right==lo)
                    break;
            }
            if(left>=right)break;
            exch(arr, left, right);
        }

        exch(arr,lo,right);
        return right;
    }

    private static void sort(int[] arr, int lo, int hi) {
            if(hi<=lo)return;
        int partiont = partion(arr, lo, hi);
            sort(arr, lo, partiont - 1);
            sort(arr, partiont + 1, hi);
    }

    private static void exch(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right]=temp;
    }

    private static boolean less(int i, int part) {
        if(i<0||part<0)return false;
        return i<part;
    }
}
