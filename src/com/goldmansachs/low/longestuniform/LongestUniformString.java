package com.goldmansachs.low.longestuniform;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUniformString {

    private static final Map<String, int[]> testCases = new HashMap<>();

    public static int[] getLongestUniformString(String input){

        if(null == input || input.trim().isEmpty()){
            return new int[]{-1,0};
        }
        int startIndex=0;
        int length = 1;
        int longestStartIndex =0;
        int longestCount =1;

        for (int i =1; i<input.length()-1;i++) {

            if (input.charAt(i) == input.charAt(i - 1)) {
                length++;
            } else {
                if (length > longestCount) {
                    longestCount = length;
                    longestStartIndex = startIndex;
                }
                length = 1;
                startIndex = i;
            }
        }
        if(length> longestCount){
            longestCount = length;
            longestStartIndex = startIndex;
        }
    return  new int[]{longestStartIndex,longestCount};
    }



    public static void main(String[] args) {

        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = getLongestUniformString(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }
}
