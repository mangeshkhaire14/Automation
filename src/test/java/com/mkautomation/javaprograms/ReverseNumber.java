package com.mkautomation.javaprograms;

public class ReverseNumber {

    public static void main(String args[]){
        int number=45678;
        int r;
        int rev=0;
        while(number>0) {
            r = number % 10;
            rev = rev * 10 + r;
            number = number / 10;
        }
        System.out.print("Reverse Number:"+rev);
    }
}
