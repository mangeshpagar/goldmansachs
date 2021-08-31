package com.goldmansachs.low.firstnonrepeating;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingEfficeintApproach {

    static  class CountIndex{
        int count;
        int index;
        public CountIndex(int index){
            this.count =1;
            this.index =index;
        }
    }

    public static char firstNonRepeatingCharOptimized(String input){

        if(input == null || input.trim().isEmpty()){
            return '0' ;
        }

        Map<Character,CountIndex> charCountIndexMap = new LinkedHashMap<>();
        for(int i=0;i<input.length();i++){
            if(charCountIndexMap.containsKey(input.charAt(i))){
                CountIndex countIndex = charCountIndexMap.get(input.charAt(i));
                countIndex.count++;
                charCountIndexMap.put(input.charAt(i),countIndex);
            }else{
                charCountIndexMap.put(input.charAt(i),new CountIndex(i));
            }

        }
        int index =Integer.MAX_VALUE;
        for (Map.Entry<Character,CountIndex> entry :charCountIndexMap.entrySet() ) {
            int count  =  entry.getValue().count;
            int index1  =  entry.getValue().index;
            if(count==1 && index1<index){
                index = index1;
            }

        }

        System.out.println(index);

        if(index == Integer.MAX_VALUE){
            return '0';
        }else{
            System.out.println(input.charAt(index));
            return input.charAt(index);
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