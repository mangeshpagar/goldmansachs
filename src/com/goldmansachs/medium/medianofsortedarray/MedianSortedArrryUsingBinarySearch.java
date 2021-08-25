package com.goldmansachs.medium.medianofsortedarray;

public class MedianSortedArrryUsingBinarySearch {

    /*
     * fine
     * O(min of both length) (logn)
     */

    public static double findMedianOfSortedArray(int[] arr){
        int mid = ((arr.length-1) / 2);
        if(arr.length % 2 == 0){
            return Double.valueOf(arr[mid] + arr[mid+1])/2;
        }else{
            return arr[mid];
        }

    }

    public static double findMedianOfSortedArray(int[] arr1,int[] arr2){
        if(arr1.length<=0 && arr2.length<=0){
            return -1;
        }
        if(arr1.length<1){
           return  findMedianOfSortedArray(arr2);
        }

        if(arr2.length<1){
            return  findMedianOfSortedArray(arr1);
        }

        if(arr2.length < arr1.length){
            return  findMedianOfSortedArray(arr2,arr1);
        }
        int length1 = arr1.length;
        int length2 = arr2.length;
        int low=0,high=length1;
        while (low<= high){

            int cut1= (low+high) /2;
            int cut2= ((length1+length2+1)/2)-cut1;

            int left1 = cut1==0?Integer.MIN_VALUE:arr1[cut1-1];
            int left2 = cut2==0?Integer.MIN_VALUE:arr2[cut2-1];

            int right1 = cut1 == length1 ?Integer.MAX_VALUE:arr1[cut1];
            int right2 = cut2 == length2 ?Integer.MAX_VALUE:arr2[cut2];

            if(left1 <= right2 && left2 <= right1){
                if((length1+length2)%2 == 0){
                    return (Double.valueOf(Math.max(left1,left2)) + Double.valueOf(Math.min(right1,right2))) /2;
                }else{
                    return Math.max(left1,left2);
                }
            }
            else if(left1>right2){
                high =cut1-1;
            }else{
                low =cut1+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{};
        System.out.println(findMedianOfSortedArray(arr1,arr2));
        if(findMedianOfSortedArray(arr1,arr2) == 1.5){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }



        int[] arr3 = new int[]{-12, -10, -6, -5 , -3};
        int[] arr4 = new int[]{3, 4, 6, 10, 12, 15};
        System.out.println(findMedianOfSortedArray(arr3,arr4));
        if(findMedianOfSortedArray(arr3,arr4) == 3){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        int[] arr5 = new int[]{1,3,7,9};//1 2 3 3 5 7 8 9
        int[] arr6 = new int[]{2,3,5,8};
        System.out.println(findMedianOfSortedArray(arr5,arr6));
        if(findMedianOfSortedArray(arr5,arr6) == 4){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }


        int[] arr7 = new int[]{2,2,2,2}; //1 2 3 3 5 7 8 9
        int[] arr8 = new int[]{2,2,2};
        System.out.println(findMedianOfSortedArray(arr5,arr6));
        if(findMedianOfSortedArray(arr7,arr8) == 2){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }


        int[] arr9 = new int[]{1,2,2,2,3}; //1 2 3 3 5 7 8 9
        int[] arr10 = new int[]{4,5,6,7,8};
        System.out.println(findMedianOfSortedArray(arr9,arr10));
        if(findMedianOfSortedArray(arr9,arr10) == 3.5){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

    }
}
