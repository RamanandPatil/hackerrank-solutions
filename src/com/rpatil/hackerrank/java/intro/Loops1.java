package com.rpatil.hackerrank.java.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://www.hackerrank.com/challenges/java-loops-i/problem?isFullScreen=true">Loops-1</a>
 */
public class Loops1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();

        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i +" = " + (N * i));
        }
    }
}
