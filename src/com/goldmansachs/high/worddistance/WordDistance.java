package com.goldmansachs.high.worddistance;

import java.util.Locale;

public class WordDistance {

    public  static double shortestDistance(String document,String firstWord,String secondWord){

        int startIndex =0;
        int endIndex=0;
        boolean firstWordFound= false;
        boolean secondWordWordFound= false;

        char[] charArray = document.toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length-1; i++) {
                if (i + firstWord.length() <= charArray.length) {
                    String word1 = document.substring(i, i + firstWord.length());
                    if (word1.equalsIgnoreCase(firstWord) && !firstWordFound) {
                        startIndex = i;
                        firstWordFound = true;
                    }
                }
                if(firstWordFound) {
                    if (i + secondWord.length() <= charArray.length) {
                        String word2 = document.substring(i, i + secondWord.length());
                        if (word2.equalsIgnoreCase(secondWord) && !secondWordWordFound) {
                            endIndex = i;
                            secondWordWordFound = true;
                        }
                    }
                }
        }

        int firstWordMin= firstWord.length()/2;
        int secondWordMin= secondWord.length()/2;
        System.out.println(startIndex+" "+endIndex );
        if(startIndex>endIndex){
            return -1;
        }
        String subString = document.substring(startIndex+firstWordMin,endIndex+secondWordMin);
        System.out.println(subString+" "+subString.length());
        double length  = subString.length();
    return length;

    }


    public static boolean pass() {
        return shortestDistance(document, "and", "graphic") == 6d && shortestDistance(document, "transfer", "it") == 14d
                && shortestDistance(document, "Design", "filler") == 25d    && shortestDistance(document, "text", "graphic") == 39d
                && shortestDistance(document, "new", "test") == 5d;

    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }
    }

    private static final String document;
    static {
        StringBuffer sb = new StringBuffer();
        sb.append(
                "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        sb.append(
                " lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        sb.append(
                " for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");
        sb.append(
                " this is new test case added");

        document = sb.toString();
    }
}
