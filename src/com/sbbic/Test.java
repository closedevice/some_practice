package com.sbbic;

/**
 * Created by God on 2016/3/15.
 * 字符串压缩
 */
public class Test {
    public static void main(String[] args) {
        String str = "ab";
        compressBad2(str);


    }

    private static void compressBad2(String string) {
        String mystr = "";
        char last = string.charAt(0);
        int num = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == last) {
                num++;
            } else {
                mystr += last + "" + num;
                last = string.charAt(i);
                num = 1;
            }
        }

        System.out.println(mystr + last + num);
    }

    private static void compressBad1(String str) {
        //String str = "abc";
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        int num = 1;
        System.out.println(chars.length);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                num++;
            } else {
                if (num == 1) {
                    sb.append(chars[i - 1]);
                } else {
                    sb.append(chars[i - 1]).append(num);
                }
                num = 1;
            }

        }
        if (num == 1) {
            sb.append(chars[chars.length - 1]);
        } else {
            sb.append(chars[chars.length - 1]).append(num);
        }

        System.out.println(sb.toString());
    }
}
