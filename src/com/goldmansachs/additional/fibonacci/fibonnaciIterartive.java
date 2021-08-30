package com.goldmansachs.additional.fibonacci;

public class fibonnaciIterartive {

    public static int fib(int no){
     int n1= 0;
     int n2=1;
     int start=2;
     int fib=0;
     while (start<=no){
         fib = n1+n2;
         n1=n2;
         n2= fib;
         start++;
     }
    return  fib;
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
