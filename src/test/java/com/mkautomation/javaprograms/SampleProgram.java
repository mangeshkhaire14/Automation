package com.mkautomation.javaprograms;

import java.util.Scanner;

public class SampleProgram {

    public static void main(String args[]){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Array Size:");

        int n = scanner.nextInt();
        int[] intArray=new int[n];

        System.out.println("Enter Array Elements:");

        for(int i=0;i<intArray.length;i++){
            int inputNumber=scanner.nextInt();
            intArray[i]=inputNumber;
        }

        System.out.println("Print Array Elements:");

        for(int j=0;j<intArray.length;j++){
            System.out.println(intArray[j]);
        }
    }

}
