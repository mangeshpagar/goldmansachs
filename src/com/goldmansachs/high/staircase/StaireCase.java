package com.goldmansachs.high.staircase;

public class StaireCase {

    public static int countSteps(int n){
        if(n == 0 || n == 1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            return  countSteps(n-1) + countSteps(n-2) + countSteps(n-3);
        }

    }


    public static boolean doTestsPass()
    {
        return countSteps(3) == 4
                && countSteps(4) == 7;
    }

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

        for (Integer n = 1; n <= 5; n++)
        {
            Integer numberOfCombinations = countSteps(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }
    }
}