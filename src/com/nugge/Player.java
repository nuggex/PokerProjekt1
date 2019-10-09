package com.nugge;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    int changecard() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which card you want to change 1-5 (0 for none): ");
        int test = 0;
        for (int i = 0; i < 1; i++) {
            test = input.nextInt();
            if (test <= 0 || test >5) {
                System.out.println("Not a valid number please try again!");
                i--;
            }
        }
        return test - 1;

    }
}

