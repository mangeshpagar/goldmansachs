package com.goldmansachs.high.dictionary;


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

public class DictionarySolutiion {

    public static  String getSortedString(String s){

        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        Set<Character> charSet =  charList.stream().sorted().collect(Collectors.toSet());
        StringBuilder sb= new StringBuilder();
        charSet.stream().forEach(ch -> sb.append(ch));

        return sb.toString();
    }

    public static Set<String> longestWord(String letters, Dictionary dict) {
        Set<String> longestWord = new TreeSet<>(Comparator.comparing(String::length));
        letters = getSortedString(letters);
        for(String word:dict.getEntries()) {
            String sortedWord =  getSortedString(word);
            if(letters.equals(sortedWord)){
                longestWord.add(word);
            }
        }
        return maxlengthWord(longestWord);
    }

    public static Set<String> maxlengthWord(Set<String> longestWord){
        TreeSet<String> list = new TreeSet<>(longestWord);
        int maxlen = list.last().length();
        return  longestWord.stream().filter(word-> word.length() == maxlen).collect(Collectors.toSet());
    }

    public static boolean pass() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
        boolean r = true;
        r= r && new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        Dictionary dict1 = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});

        r= r && new HashSet<String>(Arrays.asList("toe")).equals(longestWord("oetdo", dict));

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