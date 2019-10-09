package com.nugge;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;


public class Win {


    double wins(ArrayList<Card> hand) {

        int b = hand.get(1).values;

        int[] kortvarden = {hand.get(0).values,hand.get(1).values,hand.get(2).values,hand.get(3).values,hand.get(4).values};
        Arrays.sort(kortvarden);
        double prize = 0;
        final int[] lista = new int[13];

        // this is for finding pairs, triples or quads //
        for (Card v  : hand
             ) {

            lista[v.values]++;
        }
        Arrays.sort(lista);
        int x = lista[lista.length-1];
        int y = lista[lista.length-2];
        int z = lista[lista.length-3];
        int t = lista[lista.length-4];
        int v = lista[lista.length-5];
        if(x ==4){
            System.out.println("You have for of a kind!! ");
            prize = 12;
        }
        if(x ==3 && y ==2){
            System.out.println("You have a full house!! ");
            prize = 8;
        }
        if(x ==3 && y == 1){
            System.out.println("You have three of a kind!! ");
            prize = 6;
        }

        if(x ==2 && y == 2){
            System.out.println("You have two pairs !! ");
            prize = 4;
        }
        if(x ==2 && y == 1){
            System.out.println("You have a pair !! ");
            prize = 2;
        }
        if(kortvarden[4]-kortvarden[3] == 1 && kortvarden[3]-kortvarden[2]==1 && kortvarden[2]-kortvarden[1]==1 && kortvarden[1]-kortvarden[0]==1) {
            System.out.println("Du har en straight!!");
            prize = 12;
        }
        return prize;



        }


    }


