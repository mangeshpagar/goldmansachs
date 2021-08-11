package com.goldmansachs.medium.medianofsortedarray;

public class MedianSortedArrryUsingBinarySearch {

    public static int findMedianOfSortedArray(int[] arr){

        if(arr.length % 2 ==0){
            int mid = ((arr.length-1) / 2);
            return arr[mid];
        }else{
            int mid = ((arr.length-1) / 2);
            return (arr[mid]+ arr[mid+1] )/2;
        }

    }

    public static int findMedianOfSortedArray(int[] arr1,int[] arr2){
        if(arr1.length<=0 && arr2.length<=0){
            return -1;
        }
        if(arr1.length<0){
           return  findMedianOfSortedArray(arr2);
        }

        if(arr2.length<0){
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
                    return (Math.max(left1,left2) + Math.min(right1,right2)) /2;
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

        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};
        if(findMedianOfSortedArray(arr1,arr2) == -1){
            System.out.print("Test Passed");
        }else{
            System.out.print("Test Failed");
        }
    }
}