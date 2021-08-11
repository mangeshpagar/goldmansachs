package com.goldmansachs.low.firstnonrepeating;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeating {

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


    public static void main(String[] args) {


        String[] inputs = {"apple","racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd' };

        boolean result = true;
        for(int i = 0; i < inputs.length; i++ )
        {
            result = result && firstNonRepeatingChar(inputs[i]) == outputs[i];
            if(!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }

}
