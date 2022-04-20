package com.rpatil.hackerrank.java.intro;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-output-formatting/problem?isFullScreen=true">Java Output Formatting</a>
 */
public class OutputFormatting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();

            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");
        sc.close();
    }
}
