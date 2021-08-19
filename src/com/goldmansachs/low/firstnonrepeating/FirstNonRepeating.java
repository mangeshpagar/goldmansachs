package com.goldmansachs.low.firstnonrepeating;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRepeating {
    /*
    * use array [256]
    * search for optimized solution  fromm geek for geeks
    * */
    public  static  char firstNonRepeatingChar(String input){

        List<Character> chars= new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {

            if(chars.contains(Character.valueOf(input.charAt(i))))
            {
                chars.remove(Character.valueOf(input.charAt(i)));
            }else{
                chars.add(Character.valueOf(input.charAt(i)));
            }
        }
       return  chars.get(0);
    }


    public static char firstNonRepeatingCharOptimized(String input){
        Map<Character,Integer> map= new LinkedHashMap<>();
        for(char c: input.toCharArray()){
            map.put(c,map.containsKey(c)? map.get(c)+1:1);
        }
        return map.entrySet().stream().filter(entry-> entry.getValue() ==1).findFirst().get().getKey();

    }

    public static void main(String[] args) {


        String[] inputs = {"apple","racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd' };

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
