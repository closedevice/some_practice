package com.sbbic.sort;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by God on 2016/3/11.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr3 = {1, 2, 5, 4};
        int[] temp = new int[arr3.length];
        sort(arr3, 0, arr3.length - 1, temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    public static void sort(int[] arr1, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;

            System.out.println("mid " + mid + "    " + start + ">" + mid + "---" + (mid + 1) + ">" + end);

            sort(arr1, start, mid, temp);
            sort(arr1, mid + 1, end, temp);


            merge(arr1, start, mid, end, temp);
        }

    }

    public static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int m = mid;
        int n = end;

        int i = start;
        int j = mid + 1;
        int z = 0;

        while (i <= m && j <= n) {
            if (arr[i] < arr[j]) {
                temp[z++] = arr[i++];
            } else {
                temp[z++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[z++] = arr[i++];
        }

        while (j <= n) {
            temp[z++] = arr[j++];
        }

        for (i = 0; i < z; i++)
            arr[start + i] = temp[i];

    }


}
