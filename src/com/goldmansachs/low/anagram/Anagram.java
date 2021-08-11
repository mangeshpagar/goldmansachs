package com.goldmansachs.low.anagram;

import java.util.*;

public class Anagram {

    public static  String anagram(String input){

        HashMap<String, List<String>> anagramMap =  new LinkedHashMap<>();
        for (String word: input.split(" ")) {
            char[] wordCharArray = word.toCharArray();
            Arrays.sort(wordCharArray);
            String sortedWord  = new String(wordCharArray);
            if(!anagramMap.containsKey(sortedWord)){
                anagramMap.put(sortedWord,new ArrayList<>());
            }
            anagramMap.get(sortedWord).add(word);
        }
        StringBuilder anagrambuilder = new StringBuilder();

        for (List<String> mapEntry : anagramMap.values()) {

            for (String word: mapEntry) {
                anagrambuilder.append(word).append(" ");

            }
        }
        return  anagrambuilder.toString();

    }

    public static void main(String[] args) {

        System.out.println(anagram("cat dog tac sat tas god dog"));

    }
}
