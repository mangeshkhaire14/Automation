package com.mkautomation.javaprograms;

import java.util.Scanner;

public class ReverseStringWithoutInterChanginPositionOfString {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String:");
        String str=scanner.nextLine();
        //String str="I am Mangesh";

        String[] strArray=str.split(" ");

        String rev="";
        for(String s:strArray){
            char[] charArray=s.toCharArray();
            for(int i=charArray.length-1;i>=0;i--){
                rev=rev+charArray[i];
            }
            rev=rev+" ";
        }
        System.out.println(rev);
    }
}
