package com.goldmansachs.low.pasal;

public class Pascal {
    /*
    * column > row return -1;
    *           col0 col1 col2 col3 col4
    * 0th row   1
    * 1st row   1     1
    * 2nd row   1     2     1
    * 3rd row   1     3     3   1
    * 4th row   1     4     6   4    1
    * */
    public static int pascal(int col,int row){

        if(col < 0 || row  < 0 || col > row){
                return -1;
        }
        if(col==0) return 1;
        else if(col==row) return 1;
        else  return pascal(col-1,row-1) + pascal(col,row-1);
    }

    public static void main(String[] args) {
        boolean testResult = true;
        testResult = testResult && pascal(0,0) == 1;
        testResult = testResult && pascal(1,1) == 1;
        testResult = testResult && pascal(2,4) == 6;
        testResult = testResult && pascal(5,3) == -1;
        if(testResult)
            System.out.println("passed");
        else
            System.out.println("Failed");

    }

}
