package com.goldmansachs.high.worddistance;

import java.util.Locale;

public class WordDistance2 {



    public  static double shortestDistance(String document,String firstWord,String secondWord){

        if(document== null || document.isEmpty() || firstWord == null || firstWord.isEmpty()
                || secondWord == null || secondWord.isEmpty()){

            return -1;
        }
        document= document.toLowerCase();
        firstWord= firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();
        int startIndex =0;
        int endIndex=0;
        boolean firstWordFound= false;
        boolean secondWordWordFound= false;
        double shortestDistance = Integer.MAX_VALUE;
        char[] charArray = document.toCharArray();
        for (int i = 0; i < charArray.length-1; i++) {
                if (i + firstWord.length() <= charArray.length) {
                    String word1 = document.substring(i, i + firstWord.length());
                    if (word1.equalsIgnoreCase(firstWord) ) {
                        startIndex = i;
                        firstWordFound = true;
                    }
                }
                if(firstWordFound) {
                    if (i + secondWord.length() <= charArray.length) {
                        String word2 = document.substring(i, i + secondWord.length());
                        if (word2.equalsIgnoreCase(secondWord)) {
                            endIndex = i;
                            secondWordWordFound = true;
                        }
                    }
                }

            if(firstWordFound && secondWordWordFound){
                int firstWordMin= firstWord.length()/2;
                int secondWordMin= secondWord.length()/2;
                System.out.println(startIndex+" "+endIndex );

                String subString = document.substring(startIndex+firstWordMin,endIndex+secondWordMin);
                System.out.println(subString+" "+subString.length());
                double distance  = subString.length();
                if(distance < shortestDistance){
                    shortestDistance =  distance;
                }
                firstWordFound = false;
                secondWordWordFound= false;
            }
        }

        return shortestDistance;

    }


    public static boolean pass() {
        return   shortestDistance(document, "and", "graphic") == 6d
                && shortestDistance(document, "transfer", "it") == 14d
                && shortestDistance(document, "Design", "filler") == 25d
                && shortestDistance(document, "text", "graphic") == 39d
                && shortestDistance(document, "new", "test") == 5d
                && shortestDistance(document, "earlier", "was") == 15d
                && shortestDistance("Example is we to check where is just and the recheck we just made up", "we", "just") == 4d;
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
