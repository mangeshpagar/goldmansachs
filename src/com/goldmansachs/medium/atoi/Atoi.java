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
            /*int zero = '0';
            System.out.println(inputchar);
            System.out.println(zero);
            System.out.println(inputchar-zero);*/

            int diff = input.charAt(i)-'0';
            if(diff >= 0  && diff<=9) {
                result = result * 10 + input.charAt(i) - '0';
                i++;
            }else {
                return -1;
            }


        }
        return result*sign;
    }

    public static void main(String[] args) {

        boolean result = true;
        result =  result && 41 == atoi("41");
        result =  result && -1 == atoi("4A1");
        if(result)
                System.out.println("Passed");
        else
            System.out.println("Failed");


    }

}
