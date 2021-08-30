package com.goldmansachs.additional.formlargestno;

public class FormLargestNo {

    public static  long largestNo(int arr[]){

        for (int i = 0; i < arr.length; i++) {

            for (int j = i+1; j < arr.length; j++) {
                StringBuilder ij =  new StringBuilder();
                ij.append(arr[i]).append(arr[j]);

                StringBuilder ji =  new StringBuilder();
                ji.append(arr[j]).append(arr[i]);

                if(Integer.valueOf(ji.toString()) > Integer.valueOf(ij.toString())){
                    int temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
        }
        StringBuilder largeNo =  new StringBuilder();
        for (int i = 0; i < arr.length; i++) {

            largeNo.append(arr[i]);
        }

        return Long.valueOf(largeNo.toString());
    }




    public static void main(String[] args) {

        boolean result= true;
        result&=largestNo(new int[]{1, 34, 3, 98, 9, 76, 45, 4}) == 998764543431l;


        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
}
