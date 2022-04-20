package com.rpatil.hackerrank.java.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem?isFullScreen=true">Java Stdin and Stdout</a>
 */
public class StdInStdOut {
    public static void main(String[] args) {
        readUsingScanner();
        readUsingBufferedReader();

    }

    private static void readUsingScanner() {
        try(Scanner scanner = new Scanner(System.in)) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void readUsingBufferedReader() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
