package com.goldmansachs.medium.panagram;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Panagram {
    public static  final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public  static String findMissing(String input){

        StringBuilder missingChars = new StringBuilder();
        if (null == input || input.trim().isEmpty()){
            return ALPHABETS;
        }

        for (int i = 0; i < ALPHABETS.length(); i++) {
            if(!input.toUpperCase().contains(String.valueOf(ALPHABETS.charAt(i)))){
                missingChars.append(ALPHABETS.charAt(i));
            }
       }
        return  missingChars.toString();
    }

    public static void main(String[] args) {
        boolean result = true;
        result = result && findMissing("The quick brown fox jumps over the lazy dog").equals("");
        result = result && ALPHABETS.equals(findMissing(""));

        if(result)
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }
}
