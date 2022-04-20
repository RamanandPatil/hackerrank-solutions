package com.rpatil.hackerrank.java.intro;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-if-else/problem?isFullScreen=true">Java If Else</a>
 */
public class IfElse {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int N = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (N % 2 != 0) {
            System.out.println("Weird");
        } else {
            if (N >= 2 && N <= 5) {
                System.out.println("Not Weird");
            } else if (N >= 6 && N <= 20) {
                System.out.println("Weird");
            } else {
                System.out.println("Not Weird");
            }
        }
        SCANNER.close();
    }
}

