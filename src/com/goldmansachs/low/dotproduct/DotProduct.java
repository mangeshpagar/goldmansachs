package com.goldmansachs.low.dotproduct;

public class DotProduct {

    public static int dotProduct(int[] arr1,int[] arr2){
        if((arr1== null  &&  arr2 == null) || (arr1.length<1  &&  arr2.length<1 )  ){
            return -1;
        }

        if(arr2.length > arr1.length){
            return dotProduct(arr2,arr1);
        }

        int sum=0;
        for(int i=0 ;i<arr1.length;i++){

            if(i< arr2.length){
                sum+=(arr1[i]* arr2[i]);
            }else{
                sum+=arr1[i];
            }
        }
        System.out.println(sum);
        return sum;

    }

    public static void main( String[] args ) {

        boolean result = true;
        int[] array1 = { 1, 2 };
        int[] array2 = { 2, 3 };
        result = result && dotProduct( array1, array2 ) == 8;

        int[] array3 = { 1, 2,3 };
        int[] array4 = { 4, 5 ,6,7,8};
        result= result && dotProduct( array3, array4) ==47;


        int[] array5 = {  };
        int[] array6 = { 4, 5 ,6,7,8};
        result= result && dotProduct( array5, array6) ==30;

        int[] array7 = {1, 2,3  };
        int[] array8 = { };
        result= result && dotProduct( array7, array8) ==6;

        int[] array9 = { };
        int[] array10 = { };
        result= result && dotProduct( array9, array10) ==-1;

        int[] array11 = { -1, -2 };
        int[] array12 = { -2, 3 };
        result = result && dotProduct( array11, array12 ) == -4;

        if( result) {
            System.out.println( "Passed." );
        } else {
            System.out.println( "Failed." );

        }
    }
}

