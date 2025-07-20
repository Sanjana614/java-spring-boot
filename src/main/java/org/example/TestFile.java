package org.example;


import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        for(int i = 0; i <= data; i++) {
            for(int j = i; j < data; j++) {
                System.out.println(" ");
            }
            for(int k = i; k < data; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = data-1; i >=1; i--) {
            for(int j = data ; j <= data; j++) {
                System.out.println(" ");
            }
            for(int k = i; k < data; k++) {
                System.out.print("*");
            }
        }
    }
}
