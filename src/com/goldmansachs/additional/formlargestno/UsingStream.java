package com.goldmansachs.additional.formlargestno;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingStream {

    public static  long largestNo(int[] arr){
        StringBuilder largeNo =  new StringBuilder();
        IntStream.of(arr).boxed().sorted(UsingStream::compareTo).forEach(no-> largeNo.append(no));
        return Long.valueOf(largeNo.toString());
    }

    public static int compareTo(Integer i,Integer j){
        String ij = i.toString()+j.toString();
        String ji = j.toString()+j.toString();
        return ji.compareTo(ij);

    }

    public static void main(String[] args) {
        boolean result= true;
        result&=largestNo(new int[]{1, 34, 3, 98, 9, 76, 45, 4}) == 998764543431l;
        result&=largestNo(new int[]{98, 9, 76, 45, 9}) == 99987645;
        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
