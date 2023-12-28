package com.mkautomation.javaprograms;

public class OccuranceOfChar {
    public static void main(String args[]){
        String str="Selenium";

        char[] charArray=str.toCharArray();
        for(char c1:charArray){
            int count=0;
            for(int i=0;i<charArray.length;i++)
            {
                if(c1==charArray[i]){
                    count++;
                }
            }
            System.out.println("Occurrence of "+c1+":"+count);
        }

    }
}
