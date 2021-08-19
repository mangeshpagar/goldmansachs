package com.goldmansachs.medium.uniquetuples;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueTuples {

    /* fine
    *
    * */
    public static Set<String> uniqueTuples(String input,int len){

        Set<String> uniqueTuples = new HashSet<>();
        for (int i=0;i<input.length()-len+1;i++){
            uniqueTuples.add(input.substring(i,i+len));
        }
        return uniqueTuples;
    }

    public static void main(String[] args) {
        boolean testResult = true;

        testResult = testResult && uniqueTuples("aaab",2).contains("aa")  && uniqueTuples("aaab",2).contains("ab");
        testResult = testResult && uniqueTuples("aaabbbccd",3).contains("aaa")  && uniqueTuples("aaabbbccd",3).contains("bbb") && uniqueTuples("aaabbbccd",3).contains("bcc");;
        if (testResult)
            System.out.print("Passed");
        else
            System.out.print("Failed");
    }
}
