package com.sbbic.error;

import sun.rmi.runtime.Log;

/**
 * Created by God on 2016/4/27.
 */
public class WhileDemo {

    private static final int MAX_REDIRECTS =4 ;

    public static void main(String[] args) {


        int code=1;

        int redirect=0;
        test(code, redirect);

    }

    private static void test(int code, int redirect) {
        while (redirect < MAX_REDIRECTS) {
            try {
                System.err.println("--");
                switch (code) {
                    case 1:
                    case 2:
                        System.out.println("单线程");
                        return;
                    case 3:
                    case 4:
                        System.out.println("重定向");
                        redirect++;
                        continue;
                    default:
                        System.out.println("error");
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } finally {
                System.out.println("finally");
            }
        }

        System.out.println("__+++");
    }


}
