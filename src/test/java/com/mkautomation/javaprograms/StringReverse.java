package com.mkautomation.javaprograms;

public class StringReverse {

    public static void main(String args[]){
        String str="Selenium Java Cucumber TestNG";

        String[] strArray=str.split(" ");
        String reverse=" ";
        for(int i=strArray.length-1;i>=0;i-- ){
            reverse=reverse+strArray[i]+" ";
        }
        System.out.print(reverse);
    }
}
