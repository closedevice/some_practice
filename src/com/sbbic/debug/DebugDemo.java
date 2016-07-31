package com.sbbic.debug;

/**
 * Created by God on 2016/6/1.
 */
public class DebugDemo {
    private String name = "default";

    public void alertName() {
        int num = 10;
        int min = Math.min(num, 100);
        System.out.println(min);
        debug();
        int result=add(4,5);
        result = mul(4, 2);
    }

    private int mul(int i, int i1) {
        return i*i1;
    }

    private int add(int i, int i1) {
        return i+i1;
    }

    public void debug() {
        this.name = "debug";
        System.out.println(name);
    }

    public static void main(String[] args) {
        new DebugDemo().alertName();
    }


}
