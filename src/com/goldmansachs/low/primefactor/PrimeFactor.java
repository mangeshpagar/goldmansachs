package com.goldmansachs.low.primefactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeFactor {

    /*
    * fine
    * */
    public static ArrayList<Integer> primeFactorization(int no){
        Set<Integer> primeFactor = new HashSet<>();
        if(no<=1){
            return new ArrayList<>();
        }
        if(no==2){
            primeFactor.add(2);
            return new ArrayList<>(primeFactor);
        }

        for (int i=2;i<Math.sqrt(no);i++){

            while(no % i == 0){
                primeFactor.add(i);
                no/=i;
            }

        }

        if(no > 1){
            primeFactor.add(no);
        }
        return new ArrayList<>(primeFactor);

    }

    public static void main(String args[])
    {

        System.out.println(primeFactorization(42) + " " + primeFactorization(5));
        if(primeFactorization(42).equals(Arrays.asList(2,3,7))
                &&
                primeFactorization(5).equals(Arrays.asList(5))
        ) {
            System.out.println("All passed");
        }else {
            System.out.println("Failed");
        }

    }

}
