package com.goldmansachs.high.snowpack;

public class SnowPack {

    public static int computeSnowpack(int[] arr){

        if(arr.length<3){
            return -1;
        }
        int[] left =  new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
           left[i] = Math.max(arr[i],left[i-1]);
           System.out.print(left[i]+" ");
        }
        System.out.println();

        int[] right = new int[arr.length];
        right[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0 ; i--) {
            right[i]  = Math.max(arr[i],right[i+1]);
            System.out.print(right[i]+" ");
         }

        int showPackCount = 0;
        for (int i = 0; i <arr.length ; i++) {
            showPackCount+= Math.min(left[i],right[i]) - arr[i];
        }

      return showPackCount;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        boolean result = true;
        result &= computeSnowpack(new int[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;

        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
