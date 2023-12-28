package com.mkautomation.javaprograms;

import java.util.Locale;

public class CalculateTime {

    public static void main(String args[]) throws InterruptedException {
        long start=System.currentTimeMillis();
        System.out.println("Start Time:"+start);

        int a=10;
        int b=20;
        System.out.println(a+b);

        String str="calculate time";
        System.out.println(str.toUpperCase(Locale.ROOT));
        Thread.sleep(2000);
        long end=System.currentTimeMillis();
        System.out.println("End Time:"+end);

        long totalTime=((end-start)/1000)%60;
        System.out.println("TotalTime:"+totalTime);
    }
}
