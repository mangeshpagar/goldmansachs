package com.goldmansachs.high.robotmovement;

import java.util.Arrays;

public class RobotMovement {

    public  static int[] getPostion(String input){

        if(null == input || input.trim().isEmpty()){
            return new int[]{0,0};
        }
        int x=0,y=0;
        for (char c:input.toCharArray()) {
            switch (c) {
                case 'U' :y++;break;
                case 'D' :y--;break;
                case 'R' :x++;break;
                case 'L' :x--;break;
            }
        }
    return new int[]{x,y};

    }


    public static boolean isEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean pass() {
        boolean res = true;

        {
            String test = "UUU";
            int[] result = getPostion(test);
            res &= isEqual(result, new int[]{0, 3});
        }

        {
            String test = "ULDR";
            int[] result = getPostion(test);
            res &= isEqual(result, new int[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            int[] result = getPostion(test);
            res &= isEqual(result, new int[]{-2, 2});
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            int[] result = getPostion(test);
            res &= isEqual(result, new int[]{1, 1});
        }

        return res;
    }

    public static void main(String[] args) {
        if(pass()){
            System.out.println("Pass");
        } else {
            System.out.println("Test failures");
        }
    }
}

