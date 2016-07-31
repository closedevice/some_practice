package com.sbbic.sort;

/**
 * Created by God on 2016/3/10.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {16, 4, 2, 5, 4, 63, 66, 32};
        sort3(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void sort1(int[] arr) {
        int n = arr.length;
        boolean isSwap = true;
        while (isSwap) {
            isSwap = false;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 1; j < n - i; j++) {
                    if (arr[j - 1] > arr[j]) {
                        swap(arr, j - 1, j);
                        isSwap = true;
                    }

                }
            }
        }

    }


    public static void sort3(int[] arr) {
        int n = arr.length;
        int k;
        boolean isSwap = true;
        while (isSwap) {
            k = n - 1;
            isSwap = false;
            for (int i = 0; i < k; i++) {
                for (int j = 1; j < n - i; j++) {
                    if (arr[j - 1] > arr[j]) {
                        swap(arr, j - 1, j);
                        isSwap = true;
                        k = j;
                    }

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
