package com.goldmansachs.additional.googlesearch;
/*
 * There are List of words along with their ranks in some datasource (in-memory) and you need to implement two methods for a search like the one in google search where  when the user type the character sequence, it should fetch all the words matching the character sequence.
 *  For Ex - In datasource you have – HE (rank=10), HEL (rank=20),  HELL (rank=15),  HELLO (rank=100),  HLOE (rank=25),
 * And
 * User types H then it should match all words HE, HEL, HELL, HELLO, HLOE
 * User types HE then it should match words HE, HEL, HELL, HELLO
 * User types HEL then it should match words HEL, HELL, HELLO
 * User types HEL then it should match words HEL, HELL, HELLO
 * User types HL then it should match words HLOE
 * You need to Implement two methods (Functions) :
 * 1. To insert new keywords into the datasource.
 * 2. To search the user entered string with all the possible suggestions in decreasing order of their ranks.
 */

import java.util.*;
import java.util.stream.Collectors;

public class GoogleSearch {

    public static Map<String,Integer> datasource =  new HashMap<>();

    public  static  void add(String word,Integer rank){
        datasource.put(word,rank);
    }

    public  static List<String> search(String searchString){
        if(searchString == null || searchString.trim().isEmpty()){
            return  new ArrayList<>();
        }
        return datasource.
                entrySet().
                stream().
                sorted((entry1,entry2)-> entry1.getValue().compareTo(entry2.getValue())).
                map(entry-> entry.getKey()).
                filter(s -> s.startsWith(searchString)).
                collect(Collectors.toList());
    }



    public static void main(String[] args) {
        add("HE",10);
        add("HEL",20);
        add("HELL",15);
        add("HELLO",100);
        add("HLOE",25);

        boolean result= true;
        System.out.println(search(null));
        result&= search("H").equals(Arrays.asList("HE","HELL","HEL","HLOE","HELLO"));
        result&= search("HE").equals(Arrays.asList("HE","HELL","HEL","HELLO"));
        result&= search("HEL").equals(Arrays.asList("HELL","HEL","HELLO"));
        result&= search("HL").equals(Arrays.asList("HLOE"));
        result&= search(null).equals(new ArrayList<>());

        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }
}
