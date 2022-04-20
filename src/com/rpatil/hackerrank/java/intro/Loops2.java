package com.rpatil.hackerrank.java.intro;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true">Loops 2</a>
 */
public class Loops2 {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int sum = a;
            for (int j = 0; j < n; j++) {
                sum += (Math.pow(2, j) * b);
                System.out.print(sum + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
