package com.goldmansachs.high.dictionary1;


import java.util.*;
import java.util.stream.Collectors;



class Dictionary {
    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public  String[] getEntries(){
        return entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }
}

public class DictionarySolution {


    public static Set<String> longestWord(String letters, Dictionary dict) {

        if(letters == null || dict.getEntries() == null  || letters.isEmpty() || dict.getEntries().length<1){
            return  new HashSet<>();
        }


        int maxLength=0;
       Set<String> longestWord= new HashSet<>();
        for(String word:dict.getEntries()) {
            if(word != null && !word.trim().isEmpty()){
                boolean isCharPresent = false;
                for(char ch: word.toCharArray()){
                    if(letters.contains(Character.toString(ch))){
                        isCharPresent= true;
                    }else{
                        isCharPresent = false;
                        break;
                    }
                }
                if(isCharPresent){
                    if(maxLength< word.length()){
                        maxLength= word.length();
                    }
                    longestWord.add(word);
                }
            }
        }

        return   maxlengthWord(longestWord,maxLength);
    }

    public static Set<String> maxlengthWord(Set<String> longestWord,int maxlen){
        return  longestWord.stream().filter(word-> word.length() == maxlen).collect(Collectors.toSet());
    }

    public static boolean pass() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana",null});
        boolean r = true;
        r= r && new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        r= r && new HashSet<String>(Arrays.asList("toe","doe")).equals(longestWord("oetd", dict));
        r= r && new HashSet<String>().equals(longestWord(null, null));

        return r;
    }

    /*
     * find the new solution
     * */
    public static void main(String[] args) {
        if(pass()) {
            System.out.println("Pass");
        } else {
            System.err.println("Fails");
        }
    }
}