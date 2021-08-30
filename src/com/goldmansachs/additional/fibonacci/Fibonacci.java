package com.goldmansachs.additional.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {

    public static int fib(int no){
        if (no==0){
            return 0;
        }else if(no ==1){
            return 1;
        }else{
            return fib(no-1) + fib(no-2);
        }


    }

    public static void main(String[] args) {

        boolean result= true;

        result&= fib(5) == 5;
        result&= fib(3) == 2;
        result&= fib(2) == 1;

        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
}
