package com.goldmansachs.medium.magicportion;

public class MagicPortion {
    /*
    * handle null check
    * */
    public  static  int magicPortion(String input){
    StringBuilder magicPortion =  new StringBuilder();
    magicPortion.append(input.charAt(0));

    for (int i=1;i<input.length();i++){

        if(i*2 <input.length()){
             String left = input.substring(0,i);
             if(left.equals(input.substring(i,i*2))){
                 magicPortion.append("*");
                 i = i * 2-1;
             }else{
                 magicPortion.append(input.charAt(i));
             }

        }else{
            magicPortion.append(input.charAt(i));
        }
    }
    return magicPortion.toString().length();
    }

    public static void main(String[] args) {
        if (magicPortion("ABABCABABCE") == 6 && magicPortion("ABCABCE") == 5) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
