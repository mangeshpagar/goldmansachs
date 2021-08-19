package com.goldmansachs.low.bestaverage;

import java.util.HashMap;
import java.util.Map;

public class BestAverage {

    /*
    * java 8 scope
    * use compute
    * can be done one for loop.
    * if not find ping
    * */

    public  static  double bestAvgGrade(String[][] input){

        HashMap<String,double[]> studentsMap = new HashMap<>();
        for (String[] student: input) {
            if(studentsMap.containsKey(student[0])){
                double[] grades = studentsMap.get(student[0]);
                double[] newgrade =  new double[]{grades[0]+Double.valueOf(student[1]),grades[1]+1};
                studentsMap.put(student[0],newgrade);
            }else{
                double[] newgrade =  new double[]{Double.valueOf(student[1]),1};
                studentsMap.put(student[0],newgrade);
            }
        }

        double avgGrade=0;
        double bestAverageGrade=0;

        for(Map.Entry<String,double[]> entry  : studentsMap.entrySet()){
            double[] grades= entry.getValue();
            avgGrade = grades[0]/grades[1];

            if(avgGrade>bestAverageGrade){
                bestAverageGrade = avgGrade;
            }
        }

    return bestAverageGrade;

    }

    public static boolean pass() {
        String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" } };

        return bestAvgGrade(s1) == 84;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("Pass");
        } else {
            System.out.println("Some Fail");
        }
    }
}
