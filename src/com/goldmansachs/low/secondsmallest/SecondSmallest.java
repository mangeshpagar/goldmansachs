package com.goldmansachs.low.secondsmallest;

public class SecondSmallest {


    public static int findSecondSmallest(int[] arr){

        if(null == arr || arr.length<1){
            return -1;
        }
        if(arr.length<2){
            return arr[0];

        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest =  Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] < smallest){
                secondSmallest =smallest;
                smallest = arr[i];

            }
            if(arr[i] > smallest && arr[i] < secondSmallest){
                secondSmallest = arr[i];
            }

        }

        System.out.println(secondSmallest);
        return secondSmallest;
    }

    public static void main(String[] args) {


        boolean result  = true;
        result= result &&  findSecondSmallest(new int[]{}) == -1;
        result= result &&  findSecondSmallest(null) == -1;
        result= result &&  findSecondSmallest(new int[]{1,2,3,4,5,6}) == 2;
        result= result &&  findSecondSmallest(new int[]{8,9,10,11,12,1,2,3,4,5,6}) == 2;
        result= result &&  findSecondSmallest(new int[]{8,9,2,3,4,5,6}) == 3;
        result= result &&  findSecondSmallest(new int[]{2,1}) == 2;
        result= result &&  findSecondSmallest(new int[]{3,1,2}) == 2;
        result= result &&  findSecondSmallest(new int[]{-2,-3,1,2,3,5,7,9}) == -2;
        result= result &&  findSecondSmallest(new int[]{1,2,3,5,7,9,-2,-3}) == -2;
        if(result)
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("There are test failures");
        }

    }
}
