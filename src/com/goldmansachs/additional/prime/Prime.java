package com.goldmansachs.additional.prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* print all prime till given no.
* */
public class Prime {

    public static List<Integer> primes(int no){

        List<Integer>  primes= new ArrayList<>();
        for(int i=2;i<=no;i++){
            boolean isPrime= true;
            for(int j=2;j<= Math.sqrt(i);j++){
                if(i%j == 0){
                    isPrime= false;
                    break;
                }
            }
            if(isPrime){
                primes.add(i);
            }
        }
    return primes;

    }

    public static void main(String[] args) {
        boolean result =  true;
        result&= primes(10).equals(Arrays.asList(2,3,5,7));
        result&= primes(1).equals(Arrays.asList());
        result&= primes(2).equals(Arrays.asList(2));
        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }
    }
}
