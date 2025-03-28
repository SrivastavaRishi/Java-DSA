package com.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(3);
        arr.add(23);
        arr.add(10);
        arr.add(88);
        arr.add(8998);
        System.out.println(arr);
        System.out.println(arr.get(1));


        // 2D
        ArrayList<ArrayList<Integer>>matrix = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int row = input.nextInt();
        int col = input.nextInt();

        for (int i=0;i<row;i++){
            matrix.add(new ArrayList<>());
            for(int j = 0; j < col; j++){
                matrix.get(i).add(input.nextInt());
            }
        }

        System.out.println(matrix);

        String s = "";
        s.charAt(0);


        for (ArrayList<Integer> into : matrix) {
            System.out.println(into.toString());
        }
        input.close();
    }
}
