package com.sbbic.log;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.*;

public class AnalyzeTimeTools {
    public List<Integer> timeList = new ArrayList<>();

    public static void main(String[] args) {
        String path = "C://Users//God//Desktop//log";
        AnalyzeTimeTools tools = new AnalyzeTimeTools();
        tools.analyze(path);

        tools.timeList.stream().filter(p -> p > 0).sorted().forEach(p -> System.out.println(p));


        System.out.println("===============");

        float less50 = tools.timeList.stream().filter(p -> p > 0).filter(p -> p < 50).count();
        float less100 = tools.timeList.stream().filter(p -> p > 50).filter(p -> p < 100).count();
        float less150 = tools.timeList.stream().filter(p -> p > 100).filter(p -> p < 200).count();


        float count = less50 + less100 + less100;

        float percent50 = (less50 / count);
        float percent100 = (less100 / count);
        float percent150 = (less150 / count);

        System.err.println(percent50 + percent100 + percent150);

        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2);
        System.out.println("less(ms) 50：" + nt.format(percent50));
        System.out.println("less(ms) 100：" + nt.format(percent100));
        System.out.println("less(ms) 150：" + nt.format(percent150));


    }

    public void analyze(String path) {
        File file = new File(path);
        File[] array = file.listFiles();
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                int duration = analyzeTime(array[i].getPath());
                timeList.add(duration);
            } else if (array[i].isDirectory()) {
                analyze(array[i].getPath());
            }
        }
    }

    public int analyzeTime(String filePath) {

        int duration = -1;
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    //04-14 08:22:52.968 E/st_time (30453): duration(ms):51
                    if (lineTxt.contains("duration(ms)")) {
                        String[] arr = lineTxt.split(":");
                        String[] times = lineTxt.split(":");
                        duration = Integer.valueOf(times[4]);
                        break;
                    }
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }

        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return duration;
    }


    public void test() {
        HashMap<String, String> map = null;

        // something

        Iterator<Map.Entry<String, String>> ite = map.entrySet().iterator();
        while (ite.hasNext()) {
            Map.Entry<String, String> entry = ite.next();
            if(entry.getKey()==null)continue;
            //do something on key
        }
    }




}
  