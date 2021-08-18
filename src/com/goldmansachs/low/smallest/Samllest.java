package com.goldmansachs.low.smallest;

public class Samllest {

    public  static int findSmallest(int[] arr){

        if(null == arr || arr.length <=0){
            return  -1;
        }
        if(arr.length <= 1){
            return  arr[0];
        }
        int start = 0;
        int end= arr.length-1;
         while (start<=end){
             if(arr[start] <= arr[end]){
                 return  arr[start];
             }
            int mid = start + ((end-start)/2);
            int prev = (((mid + arr.length)-1) % arr.length);
            int next =  ((mid+1) % arr.length);
            if(arr[mid] <= arr[prev] && arr[mid]<= arr[next]){
                return  arr[mid];
            }
            if(arr[start] <= arr[mid]){
                start= mid+1;
            }else{
                end = mid-1;
            }

         }
    return -1;

    }



    public static void main(String[] args) {
        boolean result  = true;
        result= result &&  findSmallest(new int[]{}) == -1;
        result= result &&  findSmallest(null) == -1;
        result= result &&  findSmallest(new int[]{1,2,3,4,5,6}) == 1;
        result= result &&  findSmallest(new int[]{8,9,10,11,12,1,2,3,4,5,6}) == 1;
        result= result &&  findSmallest(new int[]{8,9,2,3,4,5,6}) == 2;
        result= result &&  findSmallest(new int[]{2,1}) == 1;
        result= result &&  findSmallest(new int[]{3,1,2}) == 1;
        result= result &&  findSmallest(new int[]{-2,-3,1,2,3,5,7,9}) == -2;
        result= result &&  findSmallest(new int[]{1,2,3,5,7,9,-2,-3}) == -3;

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
