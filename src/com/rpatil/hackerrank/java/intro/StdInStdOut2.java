package com.rpatil.hackerrank.java.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-stdin-stdout/problem?isFullScreen=true">Java Stdin and Stdout - 2</a>
 */
public class StdInStdOut2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        double d = scan.nextDouble();
        // Read the remaining line after
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
