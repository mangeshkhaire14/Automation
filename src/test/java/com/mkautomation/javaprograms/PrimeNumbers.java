package com.mkautomation.javaprograms;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String args[]){
        int n;
        System.out.println("Enter value of n:");
        n= new Scanner(System.in).nextInt();
        int c=0;
        int i=1;
        while(c<n) {
                int flag = 0;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = 0;
                        break;
                    } else {
                        flag = 1;
                    }

                }
                if (flag == 1) {
                    System.out.println(i);
                    c++;
                }
                i++;

            }
        }
}
