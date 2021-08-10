package com.goldmansachs.medium.medianofsortedarray;

public class MedianOfSortedArray {


    public static double findMedian(int arr1[],int arr2[]){

        int[] arr3 = new int[arr1.length+arr2.length];
        int arrIndex1 = 0;
        int arrIndex2 = 0;
        int arrIndex3 = 0;
        while(arrIndex1 < arr1.length && arrIndex2 < arr2.length){

            if(arr1[arrIndex1] < arr2[arrIndex2]){
                arr3[arrIndex3]=arr1[arrIndex1];
                arrIndex1++;
            }else{
                arr3[arrIndex3]= arr2[arrIndex2];
                arrIndex2++;
            }
            arrIndex3++;
        }
        if(arrIndex1<arrIndex2 ){
            for (int i = arrIndex1; i < arr1.length ; i++) {
                arr3[arrIndex3] = arr1[i];
                arrIndex3++;
            }
        }else{
            for (int i = arrIndex2; i < arr2.length ; i++) {
                arr3[arrIndex3] = arr2[i];
                arrIndex3++;
            }
        }
        double median;
        if(arr3.length % 2 == 0){
            int mid = (arr3.length-1)/2;
             median=((double) (arr3[mid] + arr3[mid+1] ))/2;
        }else{
             median = arr3[(arr3.length-1) /2];
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }

        System.out.println("Median is :"+median);

    return median;
    }

    public static void main(String[] args) {

       /* int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{5,6,7,8};
        if(findMedian(arr1,arr2) == 4.5){
            System.out.print("Test Passed");
        }else{
            System.out.print("Test Failed");
        } */

        int[] arr1 = new int[]{1,3,4};
        int[] arr2 = new int[]{2,5,7,8};
        if(findMedian(arr1,arr2) == 4){
            System.out.print("Test Passed");
        }else{
            System.out.print("Test Failed");
        }


    }

}
