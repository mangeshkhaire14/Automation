package com.mkautomation.javaprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingNumbers {

    public static void main(String args[]){

        int array[]={5,4,1,7,2,0,1,3};

        int k=0;
        //Bubble Sort
        for(int i=0;i<array.length;i++){
            for(int j=1;j<(array.length);j++){
                if(array[j-1]>array[j]){
                    k=array[j-1];
                    array[j-1]=array[j];
                    array[j]=k;

                }
            }
        }

        for(int l=0;l<array.length;l++){
            System.out.print(array[l]);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        //minimum number from an array
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int l=0;l<array.length;l++){
            // System.out.println(array[l]);
            arrayList.add(array[l]);
        }
        System.out.println(Collections.min(arrayList));

    }
}
