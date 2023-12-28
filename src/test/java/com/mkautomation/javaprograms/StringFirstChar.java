package com.mkautomation.javaprograms;

public class StringFirstChar {

    public static void main(String args[]){
        String str="Selenium Java Cucumber TestNG";

        String[] strArray=str.split(" ");
        String reverse="test";
        System.out.print(strArray.length);

        for(String str1:strArray){
            //System.out.println(str1);
            System.out.println(str1.charAt(0));
        }

        for(int i=0;i<strArray.length;i++ ){
            System.out.println(strArray[i].charAt(0));
        }
      //  System.out.print(reverse);
    }
}
