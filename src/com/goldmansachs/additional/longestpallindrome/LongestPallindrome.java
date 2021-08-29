package com.goldmansachs.additional.longestpallindrome;
/*
* Largest palindrome in a given string
* */
public class LongestPallindrome {
    public static String findLongestPallindrome(String input){

        int n= input.length();
        boolean[][] table = new boolean[n][n];

        int maxlenght =1;
        for (int i=0;i<n;i++){
            table[i][i] =  true;
        }

        int start =0;
        for (int i=0;i<n-1;i++){
            if(input.charAt(i) == input.charAt(i+1)){
                table[i][i+1] =  true;
                start=i;
                maxlenght=2;
            }
        }

        for (int k=3;k<=n;k++) {

            for (int i = 0; i < n - k + 1; i++) {

                int j = i + k - 1;
                if (table[i + 1][j - 1] && input.charAt(i) == input.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxlenght) {
                        maxlenght = k;
                        start = i;
                    }
                }
            }
        }
        System.out.println(input+" "+start+" "+maxlenght);
        System.out.println(input.substring(start,(start+maxlenght)));
        return input.substring(start,(start+maxlenght));
    }

    public static void main(String[] args) {
        boolean result= true;
        result&=findLongestPallindrome("aaaabbaacd").equals("aabbaa");
        result&=findLongestPallindrome("a").equals("a");
        result&=findLongestPallindrome("aa").equals("aa");
        result&=findLongestPallindrome("aaaabaacd").equals("aabaa");
        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }
}
