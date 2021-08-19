package com.goldmansachs.high.fractionrepresentaion;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNumberInFractionAfterDecimal {

    /**
     * Return the fraction output in the following way Examples: If after decimal,
     * repeating numbers are there in the output . eg. 1/3=0.333333333, this should
     * be represented as 0.(3) 6/11=0.54545454, this should be represented as 0.(54)
     * fractionRepresentation(1,2)=0.5 fractionRepresentation(1,3)=0.(3)
     * fractionRepresentation(6,11)=0.(54)
     *
     *
     * not like 0/0 handle this case
     * deno as 0;
     * num as 0;
     */
    public static String fractionRepresentation(int num, int den) {
        StringBuilder ans = new StringBuilder();
        int q = num/den;
        int r = num%den;
        ans.append(q);
        if(r==0){
            return ans.toString();
        }else{
            ans.append(".");
            Map<Integer,Integer> map = new HashMap<>();
            while (r != 0){
                if(map.containsKey(r)){
                    int len= map.get(r);
                    ans.insert(len,"(");
                    ans.append(")");
                    break;
                }else{
                    map.put(r,ans.length());
                    r*=10;
                    q = r / den;
                    r = r % den;
                    ans.append(q);

                }
            }
        }
        System.out.println(ans.toString());
        return ans.toString();
    }

    public static void main(String args[]) {

        if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
                && fractionRepresentation(93, 7).equals("13.(285714)")) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }
}
