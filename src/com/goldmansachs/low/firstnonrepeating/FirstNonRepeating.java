package com.goldmansachs.low.firstnonrepeating;

import java.util.*;
import java.util.stream.Stream;

public class FirstNonRepeating {
    /*
    * use array [256]
    * search for optimized solution  fromm geek for geeks
    *
    * */
    public  static  char firstNonRepeatingChar(String input){

        Map<Character,Integer> chars= new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if(chars.containsKey(input.charAt(i)))
            {
                chars.put(input.charAt(i),chars.get(input.charAt(i)+1));
            }else{
                chars.put(input.charAt(i),1);
            }
        }
        for (int i = 0; i < input.length(); i++) {
            int freq = chars.get(input.charAt(i));
            if(freq ==1){
                return input.charAt(i);
            }
        }
        return '1';
    }


    public static char firstNonRepeatingCharOptimized(String input){
        Map<Character,Integer> map= new LinkedHashMap<>();
        for(char c: input.toCharArray()){
            map.put(c,map.containsKey(c)? map.get(c)+1:1);
        }
        Optional<Map.Entry<Character,Integer>> optional =   map.entrySet().stream().filter(entry-> entry.getValue() ==1).findFirst();
        if(optional.isPresent()){
            return optional.get().getKey();
        }else{
            return '0';
        }
    }

    public static void main(String[] args) {


        String[] inputs = {"apple","racecars", "ababdc","aabbccddd"};
        char[] outputs = {'a', 'e', 'd','0' };

        boolean result = true;
        for(int i = 0; i < inputs.length; i++ )
        {
            result = result && firstNonRepeatingCharOptimized(inputs[i]) == outputs[i];
            if(!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }

}
