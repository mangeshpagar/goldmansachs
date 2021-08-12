package com.goldmansachs.high.election;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Election {

    public  static int whoIsElected(int n,int k){

        List<Integer> students = IntStream.rangeClosed(1,n).boxed().collect(Collectors.toList());
        if(students.size()==1){
            return students.get(0);
        }
        int start =0;
        while(students.size()>1){
            start = (start+k-1) % students.size();
            students.remove(start);
        }
        return students.get(0);


    }

    /**
     * bool doTestsPass()
     * Runs various tests. Returns true if tests pass. Otherwise,
     * returns false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        // test cases are structered as {n, k, expected answer}
        int[][] testCases = {
                {1, 1, 1},
                {2, 2, 1},
                {4, 2, 1},
                {100, 2, 73},
                {5, 3, 4},
                {6, 4, 5},
                {1000, 5, 763}
        };

        for (int[] testCase : testCases) {
            int answer = whoIsElected(testCase[0], testCase[1]);
            if (answer != testCase[2]) {
                System.out.println("test failed!");
                System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);
                return false;
            }
        }
        System.out.println("All tested passed");
        return true;
    }

    /**
     * Execution entry point.
     */
    public static void main(String args[]) {
        doTestsPass();
    }
}

