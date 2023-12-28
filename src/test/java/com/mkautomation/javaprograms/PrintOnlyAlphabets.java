package com.mkautomation.javaprograms;

public class PrintOnlyAlphabets {

    public static void main(String args[]){
        String str="automation 12#$ ABC @123 testing";

        char[] charArray=str.toCharArray();
        String str1="";

        for(int i=0;i<charArray.length;i++){
            if(charArray[i]<'A'){

            }
            else{
                str1=str1+charArray[i];
            }
        }
        System.out.println(str1);

    }
}
