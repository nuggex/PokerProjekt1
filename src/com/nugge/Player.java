package com.nugge;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    int changecard (){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which card you want to change 1-5 (0 for none): ");
        return input.nextInt()-1;
        }

}


