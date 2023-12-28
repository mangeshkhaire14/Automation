package com.mkautomation.javaprograms;

import java.util.Scanner;

public class StringPalindrome {
    public static void main(String args[]) {
        int r;
        int sum = 0;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String:");
        String str = scanner.nextLine().toLowerCase();
        //madam
        //Iterate the string forward and backward, compare one character at a time
        //till middle of the string is reached
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                flag = false;
                break;
            }
        }
        /*for(int j=0;j<str.length()/2;j++){
            if(str.charAt(j)!=str.charAt(str.length()-j-1)){
                flag=false;
                break;
            }
        }*/

        if (flag)
            System.out.println("Given string is palindrome");
        else
            System.out.println("Given string is not a palindrome");

    }
}
