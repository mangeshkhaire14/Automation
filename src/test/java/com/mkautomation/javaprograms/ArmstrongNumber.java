package com.mkautomation.javaprograms;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String args[]){
        int r;
        int sum=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number:");
        int n=scanner.nextInt();
        int temp=n;
        while(n>0){
            r=n%10;
            sum=sum+(r*r*r);
            n=n/10;
        }

        if(temp==sum){
            System.out.println("Number is Armstrong");
        }else{
            System.out.println("Number is not Armstrong");
        }

    }
}
