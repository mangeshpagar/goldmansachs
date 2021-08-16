package com.goldmansachs.medium.cyclecount;

public class CycleCount {


    public static int countCycleLength( int[] arr, int startIndex ) {
        int slow = 0;
        int fast = 0;
        int count=1;
        while(true) {
            count++;
            if(slow < 0 || fast < 0 || slow > arr.length-1 || fast > arr.length-1){
                return -1;
            }
            fast=arr[fast];
            if (slow==fast){
                return count;
            }

            if(fast<0 || fast >= arr.length){
                return -1;
            }

            fast=arr[fast];
            if(slow== fast){
                return count;
            }
            slow= arr[slow];

            if(slow==fast){
                return count;
            }


        }
    }

    public static void main(String[] args) {


        boolean testsPassed = true;

        testsPassed &= countCycleLength(new int[]{1, 0}, 0) == 2;
        testsPassed &= countCycleLength(new int[]{1, 2,0}, 0) == 3;
        testsPassed &= countCycleLength(new int[]{1, 2, 3,1}, 0) == 3;
        testsPassed &= countCycleLength(new int[]{1, 2, 8}, 0) == -1;
        testsPassed &= countCycleLength(new int[]{1, 2, 3,8}, 0) == -1;

        if(testsPassed) {
            System.out.println( "Test passed." );
            //return true;
        } else {
            System.out.println( "Test failed." );
            //return false;
        }
    }
}
