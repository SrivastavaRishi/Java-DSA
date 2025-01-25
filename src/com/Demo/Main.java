package com.Demo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
//        Scanner input = new Scanner(System.in);
//        int a = input.nextInt(), b = input.nextInt();
//        System.out.println(a+b);


        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];
        int[] brr = new int[]{1, 2, 3, 4, 5};
        int []crr = {1, 2, 3, 47};

        for(int i=0;i< arr.length;i++){
            arr[i] = input.nextInt();
        }

        for(int x: arr){
            System.out.print(x + " ");
        }

        for(int x: brr){
            System.out.print(x + " ");
        }

        System.out.println(Arrays.toString(crr));

        ///////////////////////////////////////////////////////////////////
        // ////////////////////////////////////////////////////////////////////////
        // ////////////////////////////////////////////////////////////////////////
        // /////////////////////////////////////////////////////////////////////////


        // 2D arrays
        int m = input.nextInt();
        int[][] matrix = new int[m][m];
        // row in mandatory, col is not

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = input.nextInt();
            }
        }

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
