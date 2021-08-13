package com.goldmansachs.low.fractions;

public class AddFraction {

    public static int[] addFraction(int[] arr1,int arr2[]){
        int numerator1 = arr1[0];
        int numerator2 = arr2[0];
        int denominator1 = arr1[1];
        int denominator2 = arr2[1];
        int lcm  = lcm(denominator1,denominator1);
        int fraction =((lcm/denominator1)*numerator1) +((lcm/denominator2)*numerator2);

        lcm= lcm/gcd(lcm,fraction);
        fraction= fraction/gcd(lcm,fraction);

        return  new int[]{fraction,lcm};
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
    }
}
