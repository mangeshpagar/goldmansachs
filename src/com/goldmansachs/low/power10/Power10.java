package com.goldmansachs.low.power10;

public class Power10 {
    /*
    * check for 0 and negative
    * fine
    * */
    public static boolean isPowerOf10(int i){

        while(i>1 && i%10 ==0){
            i/=10;
        }
        return  i==1;

    }

    public static boolean doTestsPass()
    {
        int[] isPowerList = {1,10};
        int[] isNotPowerList = {0,-1};

        for(int i : isPowerList)
        {
            if(!isPowerOf10(i))
            {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        for(int i : isNotPowerList)
        {
            if(isPowerOf10(i))
            {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        System.out.println("All tested passed");
        return true;
    };


    public static void main(String args[])
    {
        doTestsPass();
    }
}
