package com.goldmansachs.low.pasal;

public class Pascal {

    public static int pascal(int col,int row){
        if(col==0) return 1;
        else if(col==row) return 1;
        else  return pascal(col-1,row-1) + pascal(col,row-1);
    }

    public static void main(String[] args) {
        boolean testResult = true;
        testResult = testResult && pascal(0,0) == 1;
        testResult = testResult && pascal(1,1) == 1;
        testResult = testResult && pascal(2,4) == 6;
        if(testResult)
            System.out.println("passed");
        else
            System.out.println("Failed");

    }

}
