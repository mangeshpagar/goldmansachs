package com.goldmansachs.medium.cyclecount;

public class CycleCount {

    public  static  int getCycleCount(int arr[],int startIndex){

        if(arr == null || arr.length<1){
            return -1;
        }
        int count = 0;
        int slow = arr[startIndex];
        int fast = arr[slow];
        while(fast!= slow){
            if(fast >= arr.length){
                return -1;
            }
            count++;
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        return count+1;
    }

    public static void main(String[] args) {


        boolean testsPassed = true;

        testsPassed &= getCycleCount(new int[]{1, 0}, 0) == 2;
        testsPassed &= getCycleCount(new int[]{1, 2, 0}, 0) == 3;

        if(testsPassed) {
            System.out.println( "Test passed." );
            //return true;
        } else {
            System.out.println( "Test failed." );
            //return false;
        }
    }
}
