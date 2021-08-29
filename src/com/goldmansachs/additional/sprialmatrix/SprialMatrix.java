package com.goldmansachs.additional.sprialmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* Print matrix in spiral form e.g. {{1,2,3},{4,5,6},{7,8,9}} Output . 1,2,3,6,9,8,7,4,5
* */
public class SprialMatrix {

    public  static List<Integer> spiral(int[][] matrix){

        List<Integer> spiralForm =  new ArrayList<>();
        if(matrix == null || matrix.length <1){
            return spiralForm;
        }

        int t=0,b=matrix.length-1,l=0,r=matrix[0].length-1;
        int dir =0;
        while(t<= b && l<= r){
            if(dir == 0){
                for(int i=l;i<=r;i++){
                    spiralForm.add(matrix[t][i]);
                }
                t++;
                dir =1;
            }
            if(dir ==1){

                for(int i=t;i<=b;i++){
                    spiralForm.add(matrix[i][r]);
                }
                r--;
                dir=2;
            }
            if(dir ==2){

                for (int i=r;i>=l;i--){
                    spiralForm.add(matrix[b][i]);
                }
                b--;
                dir =3;
            }
            
            if(dir==3){
                for (int i = b; i >=t ; i--) {
                    spiralForm.add(matrix[i][l]);
                }
                l++;
                dir=0;
            }
        }
        return spiralForm;
    }

    public static void main(String[] args) {
        boolean result =  true;
        result&= spiral(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).equals(Arrays.asList(1,2,3,6,9,8,7,4,5));
        result&= spiral(new int[][]{{1,2,3},{4,5,6}}).equals(Arrays.asList(1,2,3,6,5,4));
        result&= spiral(null).equals(Arrays.asList());
        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }

    }
}
