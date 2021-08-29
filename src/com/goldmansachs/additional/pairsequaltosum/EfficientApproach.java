package com.goldmansachs.additional.pairsequaltosum;

import java.util.HashMap;
import java.util.Map;

public class EfficientApproach {

   public static int  findNoOfPairWhoseSumEqualtoNo(int[] arr,int k){
    if(arr == null || arr.length<2){
        return 0;
    }

       int counter=0;
       Map<Integer,Integer> frequencyMap =  new HashMap<>();
       for (int i = 0; i < arr.length; i++) {
           if(arr[i]<= k) {
               int tempSum = k - arr[i];
               if (frequencyMap.containsKey(tempSum)) {
                   counter += frequencyMap.get(tempSum);
               }
               if (frequencyMap.containsKey(arr[i])) {
                   frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
               } else {
                   frequencyMap.put(arr[i], 1);
               }
           }
       }
       return counter;
   }

    public static void main(String[] args) {
        boolean result =  true;
        result&= findNoOfPairWhoseSumEqualtoNo(new int[]{1,5,7,1},6) == 2;
        result&= findNoOfPairWhoseSumEqualtoNo(null,6) == 0;
        result&= findNoOfPairWhoseSumEqualtoNo(new int[]{1},6) == 0;

        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }
    }

}
