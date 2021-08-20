package com.goldmansachs.medium.logs;


import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApacheLogs {
/*
*validate ip (using java 8/regex)
* handled ,null test cases
* */
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

    public static  String maxAccessedIpUsingStreamAndValidatingIp(String[] input){
        if(null == input || input.length<1){
            return "";
        }

        int maxFrequency = 0;
        String maxIpAddress ="";
        List<String> ips =   Stream.of(input).filter(line-> line != null).map(line-> line.split(" ")).
                                map(line -> line[0]).filter(ApacheLogs::validateIp).collect(Collectors.toList());
        for (String ip : ips) {
            int frequency  = Collections.frequency(ips,ip);
            if(frequency > maxFrequency){
                maxFrequency = frequency;
                maxIpAddress = ip;
            }
        }
        return maxIpAddress;
    }

    public static boolean validateIp(String ip){
        String reg = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern pattern= Pattern.compile(reg);
        return pattern.matcher(ip).matches();
    }

    public static void main(String[] args) {

        String lines[] = new String[] {
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 133132",
                "abcd - xyz ",
                "abcd - xyz ",
                    null,
                "abcd - xyz ",
                "abcd - xyz " };
        boolean result = maxAccessedIpUsingStreamAndValidatingIp(lines).equals("10.0.0.1");
        if (result)
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }
}
