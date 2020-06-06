package com.test;

import java.util.Scanner;

public class testSwitch {
    public static void main(String[] args) {
        int to =0;
        Scanner in = new Scanner(System.in);

        while (to != -1) {
            to = in.nextInt();
            switch (to) {
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                    System.out.println(2);
                    break;

            }
        }

    }
}