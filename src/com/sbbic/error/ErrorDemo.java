package com.sbbic.error;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by God on 2016/4/13.
 * 异常导致的对象状态不一致
 *
 */
public class ErrorDemo {
    private static long aLong;
    private static long bLong;

    public static void main(String[] args) {
        //Person person = new Person();
        //person.age = 100;
        //person.name = "ta";
        //try {
        //    error(person);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //System.out.println(person.toString());

        //int max = new Random().nextInt(20000);
        //ArrayList<String> list = new ArrayList<>();
        //for (int i=0;i<max;i++) {
        //    list.add(System.currentTimeMillis() + "");
        //}
        //
        //new ErrorDemo().testAbnormal(list.toArray(new String[list.size()]));
        //new ErrorDemo().testNormal(list.toArray(new String[list.size()]));
        //System.out.println("exception:" + aLong + " normal:" + bLong);

        try {
            new ErrorDemo().testError();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-------------");
        }


    }

    public static void ok(Object object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
    }

    private static void error(Person person) {
        person.name = "ld";
        person.age = compulate();
    }

    private static int compulate() {
        throw new NullPointerException();
    }


    static class Person {
        private int age;
        private String name;

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public void testNormal(String[] args) {
        long start = System.currentTimeMillis();

        for (String arg : args) {
            //System.out.println(arg);
        }

        bLong=System.currentTimeMillis()- start;
    }


    public void testAbnormal(String[] args) {
        long start = System.currentTimeMillis();
        try {
            int i = 0;
            while (true) {
                System.out.println(args[i++]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            Logger.getLogger(ErrorDemo.class.getSimpleName()).log(Level.ALL,e.getMessage());

        }
        aLong = System.currentTimeMillis() - start;

    }


    public void testError() {
        try {
            testError();
        } catch (Exception e) {

        }
    }
    
    
    public void loopError() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        for (String s : list) {
            
        }
        
        
        
        
    }
}
