package com.mkautomation.javaprograms;

public class LargestNumberInArray {

    public static void main(String args[]) {
        int array[] = {23, 34, 12, 45, 25};

        //Calculate First Largest Number
        int largestNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (largestNumber < array[i]) {
                largestNumber = array[i];
            }
        }
        System.out.print("First Largest Number:" + largestNumber);
        //Calculate Second Largest Number using selection sort

        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("\nSecond Largest Number:" + array[array.length-2]);

    }

}
