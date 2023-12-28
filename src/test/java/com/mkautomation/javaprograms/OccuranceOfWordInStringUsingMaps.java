package com.mkautomation.javaprograms;

import java.util.HashMap;

public class OccuranceOfWordInStringUsingMaps {

    public static void main(String arg[]){
        String line="test my test program test";
        String[] strArray=line.split(" ");

        HashMap<String,Integer> wordCount=new HashMap<>();
        for(String s:strArray){
           if(wordCount.containsKey(s)){
               int count=wordCount.get(s);
               wordCount.put(s,++count);
           }else{
               wordCount.put(s,1);
           }
        }
        System.out.println(wordCount);
    }
}
