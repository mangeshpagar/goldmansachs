package com.goldmansachs.medium.logs;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApacheLogs {

    public  static String maxAccessedIp(String[] input){
        int maxFrequency = 0;
        String maxIpAddress ="";
       List<String> ips =  Stream.of(input).map(log-> log.split(" ")).map(log-> log[0]).collect(Collectors.toList());
        for (String ip : ips) {
           int frequency  = Collections.frequency(ips,ip);
           if(frequency > maxFrequency){
               maxFrequency = frequency;
               maxIpAddress = ip;
           }
         }
       return maxIpAddress;
    }


    public static void main(String[] args) {

        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132" };
        boolean result = maxAccessedIp(lines).equals("10.0.0.1");
        if (result)
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }
}
