package com.mkautomation.javaprograms;

import java.util.Scanner;

public class FactorialNumber {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number:");
        int n = scanner.nextInt();
        int fact = 1;
        // Using loop
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of Number is:" + fact);
        System.out.println("Factorial of Number using recursion:" + recursiveFactorial(n));
    }

    public static int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * recursiveFactorial(n - 1));
        }
    }}
