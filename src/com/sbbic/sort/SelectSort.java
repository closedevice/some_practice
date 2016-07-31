package com.sbbic.sort;

/**
 * Created by God on 2016/3/10.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {16,4, 2, 5, 4, 63, 66, 32};
        sort1(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }




    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //这里我们不写for(int j=i;i<n;j++)的原因在于,一个数没有必要和自身进行比较
            for (int j = i + 1; j < n; j++) {
                //每找到一个比arr[i]小的数就进行一次交换,整个过程可能进行多次交换
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }
    public static void sort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min=i;//最小元素的位置
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
