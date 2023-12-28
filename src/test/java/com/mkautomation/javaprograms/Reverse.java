package com.mkautomation.javaprograms;

public class Reverse {
    public static void main(String[] args){

        // Reversing integer
        int n=12345;
        String str=String.valueOf(n);
        //Using char Array
        System.out.println("Using Char Array");
        char[] charArray=str.toCharArray();

        for(int i= charArray.length-1;i>=0;i--) {
            System.out.print(charArray[i]);
        }

        //Using String buffer
        System.out.println("\nUsing String Buffer");
        StringBuffer stringBuffer=new StringBuffer(str);
        System.out.println(stringBuffer.reverse());

       int[] intArray={1,2,3,4};
        // Reversing String
        String str1="Software Testing";
        //Using char Array
        System.out.println("Using Char Array");
        char[] charArray1=str1.toCharArray();
        for(int i= charArray1.length-1;i>=0;i--) {
            System.out.print(charArray1[i]);
        }

        //Using String buffer
        System.out.println("\nUsing String Buffer");
        StringBuffer stringBuffer1=new StringBuffer(str1);
        System.out.println(stringBuffer1.reverse());
    }
}
