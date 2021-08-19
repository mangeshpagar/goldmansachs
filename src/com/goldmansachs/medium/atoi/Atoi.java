package com.goldmansachs.medium.atoi;

public class Atoi {

    /*
    * character should  be in 0-9 check in while
    * */
    public static int atoi(String input){

        if(null == input || input.trim().isEmpty()){
            return -1;
        }
        int result=0;
        int i=0;
        int sign=1;
        if(input.charAt(i) =='-'){
            sign =-1;
        }

        while(i<input.length()){
            int inputchar = input.charAt(i);
            int zero = '0';
            System.out.println(inputchar);
            System.out.println(zero);
            System.out.println(inputchar-zero);
            result =  result*10 + input.charAt(i)-'0';
            i++;
        }
        return result*sign;
    }

    public static void main(String[] args) {

        boolean result = true;
        result =  result && 41 == atoi("41");
        if(result)
                System.out.println("Passed");
        else
            System.out.println("Failed");


    }

}
