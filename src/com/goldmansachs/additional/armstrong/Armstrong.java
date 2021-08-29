package com.goldmansachs.additional.armstrong;
/*
* Find if a given number is Armstrong number - Example: 371 = 3^3 + 7^3 + 1^3
* */
public class Armstrong {
    public static int getNoOfDigits(int no){
        int noOfDigit =0;
        while(no>0){
            no/=10;
            noOfDigit++;
        }
        return noOfDigit;
    }

    public  static boolean isArmstrong(int no){
        int noOfDigits =  getNoOfDigits(no);
        int temp = no;
        int sum=0;
        while(no>0){
           int digit = no%10;
           sum+= Math.pow(digit,noOfDigits);
           no/=10;
        }
        if(temp == sum){
            return  true;
        }
        return false;

    }

    public static void main(String[] args) {
        boolean result= true;
        result&=isArmstrong(153) == true;
        result&=isArmstrong(15) == false;

        if(result){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }



    }
}
