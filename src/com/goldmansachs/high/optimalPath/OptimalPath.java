package com.goldmansachs.high.optimalPath;

public class OptimalPath {

    public static  int optimalPathRecusive(Integer[][] arr,int row ,int col,int[][] gridValue){

        if(col<0){
            return  0;
        }else if(row>arr.length-1){
            return 0;
        }else if(row == arr.length-1 && col==0){
            return arr[row][col];
        }else{
            gridValue[row][col] = arr[row][col] + Math.max(optimalPathRecusive(arr,row,col-1,gridValue),optimalPathRecusive(arr,row+1,col,gridValue));
            return  gridValue[row][col];
        }

    }

    public static int optimalPath(Integer[][] grid){
        if (grid.length == 0) {
            return 0;
        }
        int[][] gridValue = new int[grid.length][grid[0].length];
        int result = optimalPathRecusive(grid,0,grid[0].length-1,gridValue);;
        return  gridValue[0][gridValue[0].length-1];

    }

    public static boolean doTestsPass() {
        boolean result = true;
        result &= optimalPath(new Integer[][] { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } }) == 10;
        result &= optimalPath(new Integer[][] { { 1,1,3 }, { 2, 2, 1 }, { 2, 3, 2 } }) == 11;
        return result;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
