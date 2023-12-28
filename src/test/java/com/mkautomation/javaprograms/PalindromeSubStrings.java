package com.mkautomation.javaprograms;

public class PalindromeSubStrings {
    public static void main(String args[]){
        String str="TENET";
        int count=0;
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                //getting substring
                String subString=str.substring(i,j+1);
                if(checkPalindrome(subString)){
                    count++;
                }
                System.out.println(subString);
            }
        }
    }

    public static boolean checkPalindrome(String str){
        int count=str.length();
        boolean flag=true;
        //iterating over stirng till midway to chek palindrome behaviour
        for(int i=0;i<count/2;i++){
            if(str.charAt(i)!=str.charAt(count-i-1)){

                // not palindrome
                flag=false;
            }
        }
        return flag;
    }

}
