package com.goldmansachs.low.fractions;

public class LCM {

    /*
    * GCD Greatest common divisor
    * */
    public static int gcd(int a,int b){
        if(b== 0){
            return a;
        }else{
            return gcd(b,a%b);
        }

    }

    /*
    * formula for LCM   = a*b/gcd(a,b)
    * first you need to find GCD(greatest Common divisor)
    * */
    public static int lcm(int a,int b){
        int gcd = gcd(a,b);
        System.out.printf("GCD(%d, %d) is %d",a,b,gcd);
        System.out.println();
        return (a*b)/gcd;

    }

    public static void main(String[] args) {
        System.out.println("LCM:"+lcm(8,16));
        System.out.println("LCM:"+lcm(6,9));
        System.out.println("LCM:"+lcm(12,8));
        System.out.println("LCM:"+lcm(500,500));
        System.out.println("LCM:"+lcm(15,15));
    }
}
