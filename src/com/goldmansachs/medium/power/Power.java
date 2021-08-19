package com.goldmansachs.medium.power;

import java.util.ArrayList;

public class Power {


    /* fine
    Given base and integer exponent, compute value of base raised to the power of exponent.
     * Can you implement a solution faster than O(exp)?
     */
    public static double power(double base, int exp) {
        if(exp == 0) return 1;
        if(exp == 1) return  base;
        if(exp<0) return power(1/base,-exp);
        double result = power(base * base,exp/2);
        if(exp % 2 == 1){
            result  *=base;
        }
        return  result;
    }



    public static void main( String[] args ) {
        boolean result= true;
        result= result && 8 == power(2,3);
        result= result && 0.25 == power(2,-2);
        if (result)
            System.out.println("All Tests Pass");
        else
            System.out.println("There are test failures");
    }
}
