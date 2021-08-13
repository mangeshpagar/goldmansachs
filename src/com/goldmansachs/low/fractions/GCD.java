package com.goldmansachs.low.fractions;

public class GCD {

    public static int gcd(int den1,int den2){
        if(den2 == 0){
            return den1;
        }else{
            return gcd(den2,den1%den2);
        }

    }

    public static void main(String[] args) {
        System.out.println(gcd(5,10));
        System.out.println(gcd(12,8));
    }
}
