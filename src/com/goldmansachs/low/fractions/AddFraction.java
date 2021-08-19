package com.goldmansachs.low.fractions;

public class AddFraction {
        /*
        * null check for empty array
        * denom is 0 return -1
        * if numerator = 0
        * */
    public static int[] addFraction(int[] arr1,int arr2[]){
        int numerator1 = arr1[0];
        int denominator1 = arr1[1];

        int numerator2 = arr2[0];
        int denominator2 = arr2[1];

        int denominator3  = lcm(denominator1,denominator2);
        int numerator3 =((denominator3/denominator1) * numerator1 ) +((denominator3/denominator2) *numerator2);

        int commonFactor = gcd(denominator3,numerator3);
        System.out.printf("GCD(%d, %d) is %d",denominator3,numerator3,commonFactor);
        denominator3= denominator3/commonFactor;
        numerator3= numerator3/commonFactor;
        System.out.println();
        System.out.println(numerator3+"/"+denominator3);
        return  new int[]{numerator3,denominator3};
    }

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

    public static void main( String[] args ) {
        int[] result = addFraction( new int[]{ 2, 3 }, new int[]{ 1, 2 } );

        if( result[ 0 ] == 7 && result[ 1 ] == 6) {
           System.out.println( "Test passed." );
        } else {
            System.out.println( "Test failed." );
        }

        int[] result1 = addFraction( new int[]{ 1, 3 }, new int[]{ 3, -9 } );

        if( result1[ 0 ] == 0 && result1[ 1 ] == 1) {
            System.out.println( "Test passed." );
        } else {
            System.out.println( "Test failed." );
        }
    }
}
