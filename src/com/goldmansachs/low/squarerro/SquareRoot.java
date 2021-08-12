package com.goldmansachs.low.squarerro;

public class SquareRoot {
    public  static double squareRoot(double no,double start,double end){
        double mid = start+((end-start)/2);
        double midSqr = mid*mid;
        if(midSqr < no+0.001 && midSqr >no-0.001){
            return mid;
        }else if(midSqr> no+0.001){
            return squareRoot(no,start,mid);
        }else{
            return squareRoot(no,mid,end);
        }
    }

    public  static double squareRoot(double no){
            return  squareRoot(no,0,no);
    }

    public static void main( String args[])
    {
        double[] inputs = {2, 4, 100};
        double[] expected_values = { 1.41421, 2, 10 };
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
            }
        }
        System.out.println( "All tests passed");
    }
}


