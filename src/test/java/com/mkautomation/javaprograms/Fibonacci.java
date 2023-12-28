package com.mkautomation.javaprograms;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number:");
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        int c = 1;
        System.out.println("Fibonacci Series using loop:");
        int i = 1;
        while (i <= n) {
            System.out.print(c);
            c = a + b;
            a = b;
            b = c;
            i++;
        }

        System.out.println("\nFibonacci Series using recursion:");
        for (int j = 0; j < n; j++) {
            System.out.print(fibonacci(j) + " ");
        }
    }

    public static int fibonacci(int n){

        if(n<=1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
