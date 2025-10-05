package com.DataStructure;

import java.util.*;

public class MergeIntervals {

    static int[][] mergeIntervals(int[][] intervals)
    {
        Arrays.sort(intervals);
        int n = intervals.length;
        int i = 0;
        List<List<Integer>> list = new ArrayList<>();
        while(i < n){
            int j = i;
            int start = intervals[i][0], end = intervals[i][1];
            while(j < n && intervals[j][0] <= end){
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            i = j;
            list.add(Arrays.asList(start, end));
        }
        return list.stream()
                .map(innerList -> innerList.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int start, end;

        int [][] intervals = new int[n][2];

        for(int i=0;i<n;i++){
            start = sc.nextInt();
            end = sc.nextInt();
            intervals[i][0] = start;
            intervals[i][1] = end;
        }

        int [][] res = mergeIntervals(intervals);

        for (int[] re : res) {
            for(int x: re)
                System.out.print(x + " ");
            System.out.println();
        }

    }
}
