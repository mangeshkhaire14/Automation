package com.mkautomation.javaprograms;

import java.util.Scanner;

public class PerfectNumber {

    public static void main(String args[]) {
        int n;
        System.out.println("Enter value of n:");
        n = new Scanner(System.in).nextInt();
        int temp=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                temp=temp+i;
            }
        }
        if(temp==n){
            System.out.println("Number is Perfect");
        }
        else{
            System.out.println("Number is not Perfect");

        }
    }
}
