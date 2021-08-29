package com.goldmansachs.additional.longestuniquestring;

import java.util.HashMap;
import java.util.Map;
/*
* Largest substring with unique characters e.g. aaabcbdeaf Output : cbdeaf
* */
public class LongestUniqueString {


    public static String findLongestSubstring(String input){
        if(input ==  null || input.trim().isEmpty()){
            return "";
        }
        int i=0;
        Map<Character,Integer> indexMap = new HashMap<>();
        int maxStartIndex=0;
        int startIndex = 0;
        int maxLength=0;
        indexMap.put(input.charAt(0),0);

        for( i=1;i<input.length();i++){

            if(indexMap.containsKey(input.charAt(i))){

                if(indexMap.get(input.charAt(i)) >= startIndex){

                    int len = i- startIndex;
                    if(maxLength< len){
                        maxLength= len;
                        maxStartIndex= startIndex;
                    }

                    startIndex= indexMap.get(input.charAt(i))+1;
                }
                indexMap.replace(input.charAt(i),i);

            }else{
                indexMap.put(input.charAt(i),i);
            }
        }

        if(maxLength< i-startIndex ){
            maxLength= i - startIndex;
            maxStartIndex= startIndex;
        }

        return input.substring(maxStartIndex,maxStartIndex+maxLength);
    }




    // Driver Code
    public static void main(String[] args)
    {
        String str = "aaabcbdeaf";
        System.out.print(findLongestSubstring(str));
    }
}

