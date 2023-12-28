package com.mkautomation.javaprograms;

public class OccuranceOfWordInString {

    public static void main(String arg[]){
        String line="test my test program test";

        String[] strArray=line.split(" ");

        for(String s:strArray){
            int count=0;
            for(int i=0;i<strArray.length;i++){
                if(s.equalsIgnoreCase(strArray[i])){
                    count++;
                }
            }
            System.out.println("Occurrence of "+s+"="+count);
        }
    }
}
