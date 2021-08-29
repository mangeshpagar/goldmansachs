package com.goldmansachs.additional.pairsequaltosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Find out the number of pair from given integer array whose sum is equal to a given number.
* ex1 input {1,5,7,1} sum=6 output = 2 (1+5 ==6 and 5+1 == 6 )
* time complexity = O(n^2)
* */
public class NaiveApproach {

    public  static int  findNoOfPairWhoseSumEqualtoNo(Integer[] arr,int no){

        int counter=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j] == no){
                    System.out.println("{"+arr[i]+","+arr[j]+"}");
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        boolean result =  true;
        result&= findNoOfPairWhoseSumEqualtoNo(new Integer[]{1,5,7,1},6) == 2;

        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }
    }
}
