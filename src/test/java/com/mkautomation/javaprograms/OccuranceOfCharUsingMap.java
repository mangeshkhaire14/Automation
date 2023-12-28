package com.mkautomation.javaprograms;

import java.util.HashMap;

public class OccuranceOfCharUsingMap {
    public static void main(String args[]){
        String str="Selenium";

        HashMap<Character,Integer> charCount=new HashMap<>();

        for(int i=0;i<str.length();i++){
            if(charCount.containsKey(str.charAt(i))){
                int count=charCount.get(str.charAt(i));
                charCount.put(str.charAt(i),++count);
            }
            else{
                charCount.put(str.charAt(i),1);
            }
        }

        System.out.println(charCount);

    }
}
