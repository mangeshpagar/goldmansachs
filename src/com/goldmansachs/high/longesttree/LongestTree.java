package com.goldmansachs.high.longesttree;

import java.util.*;

public class LongestTree {


    public static Integer getTreeSize(final Map<Integer, List<Integer>> parentToChild, final Integer rootIndex) {
        Integer result = 0;
        final Stack<Integer> nodes = new Stack<>();
        nodes.push(rootIndex);
        while (!nodes.empty()) {
            final Integer index = nodes.pop();
            for (final Integer childIndex : parentToChild.getOrDefault(index, new ArrayList<>())) {
                nodes.push(childIndex);
                result++;
            }
        }
        return result;
    }

    /*
     ** Find the largest tree.
     */
    public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
        int ltr = Integer.MIN_VALUE;
        int maxLength = 0;
        Map<Integer, List<Integer>> parentToChild = new HashMap<>();

        for (Integer key : immediateParent.keySet()) {
            int node = immediateParent.get(key);
            if (!parentToChild.containsKey(node)) {
                List<Integer> nl = new ArrayList<>();
                nl.add(key);
                parentToChild.put(node, nl);
            } else {
                parentToChild.get(node).add(key);
            }
        }

        for (Integer key : parentToChild.keySet()) {
            int currentLen = getTreeSize(parentToChild, key);
            if (currentLen > maxLength) {
                maxLength = currentLen;
                ltr = key;
            } else if (currentLen == maxLength && key < ltr) {
                ltr = key;
            }
        }
        return ltr;

    }

    /*
     ** Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        // map of test cases to expected results
        final Map<Map<Integer, Integer>, Integer> testCases = new HashMap<>();

        // More than two trees
        final Map<Integer, Integer> testCaseTwoKey = new HashMap<Integer, Integer>() {
            {
                put(2, 3);
                put(7, 8);
                put(12, 15);
                put(3, 1);
                put(13, 15);
                put(11, 15);
                put(9, 8);
                put(5, 12);
            }
        };
        testCases.put(testCaseTwoKey, 15);


        boolean passed = true;
        for (Map.Entry<Map<Integer, Integer>, Integer> entry : testCases.entrySet()) {
            final Integer actual = largestTree(entry.getKey());
            if (!actual.equals(entry.getValue())) {
                passed = false;
                System.out.println("Failed for " + entry.getKey().toString() + "\n  expected " + entry.getValue()
                        + ", actual " + actual);
            }
        }

        return passed;
    }

    /*
     ** Execution entry point.
     */
    public static void main(String[] args) {
        // Run the tests
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}