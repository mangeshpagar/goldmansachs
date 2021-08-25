package com.goldmansachs.medium.subarrayexceedingsum;

public class SubArrayExceedingSum {

    public static  int  subArrayExceedsSum(int[] arr,int x){
        if(arr.length<1){
            return  -1;
        }
        int sum=0;
        int left=0;
        int len= arr.length;
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];

            while (sum > x && left<= right){
               len =  Math.min(len,right-left+1);

               sum-=arr[left];
               left++;
            }
        }

        if(len == arr.length){
            return -1;
        }
        return len;
    }

    public static void main(String[] args) {

        boolean result = true;
        int[] arr = { 1, 2, 3, 4 };
        result = result && subArrayExceedsSum( arr, 6 ) == 2;
        result = result && subArrayExceedsSum( arr, 12 ) == -1;

        int[] arr1 = { 1, 5, 9, 2 };
        result = result && subArrayExceedsSum( arr1, 12 ) == 2;

        int[] arr2 = { -3, 5, 9, 2 };
        result = result && subArrayExceedsSum( arr1, 12 ) == 2;


        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
    }

}
