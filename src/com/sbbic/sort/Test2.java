package com.sbbic.sort;

/**
 * Created by God on 2016/3/15.
 */
public class Test2 {
    public static void main(String[] args) {
        String str = "001110001";
        int num=0;
        for (int i=0,j=str.length()-1;i<j;++i,j--) {
            while (i < j) {
                if (str.charAt(i) == '0') {
                    i++;
                }
            }
            while (j > i) {
                if (str.charAt(j) == '1') {
                    j++;
                }
            }

            if (i < j) {
                num++;
            }

        }

        System.out.println(num);
    }
}
