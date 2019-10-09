package com.nugge;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;


public class Win {


    double wins(ArrayList<Card> hand) {

        int[] kortvarden = {hand.get(0).values, hand.get(1).values, hand.get(2).values, hand.get(3).values, hand.get(4).values};
        String[] kortsuits = {hand.get(0).color, hand.get(1).color, hand.get(2).color, hand.get(3).color, hand.get(4).color};
       /* String kort1 = hand.get(0).color;
        String kort2 = hand.get(1).color;
        String kort3 = hand.get(2).color;
        String kort4 = hand.get(3).color;
        String kort5 = hand.get(4).color;
        */

        Arrays.sort(kortvarden);

        double prize = 0;
        int[] lista = new int[13];

        // this is for finding pairs, triples or quads //

        for(int i = 0; i<5; i++){
            lista[kortvarden[i]]++;
        }

       /* for (Card v : hand
        ) {

            lista[v.values]++;
        }*/
        Arrays.sort(lista);
        int x = lista[lista.length - 1];
        int y = lista[lista.length - 2];
        if (x == 4) {
            System.out.println("You have for of a kind!! ");
            prize = 12;
        }
        if (x == 3 && y == 2) {
            System.out.println("You have a full house!! ");
            prize = 8;
        }
        if (x == 3 && y == 1) {
            System.out.println("You have three of a kind!! ");
            prize = 6;
        }

        if (x == 2 && y == 2) {
            System.out.println("You have two pairs !! ");
            prize = 4;
        }
        if (x == 2 && y == 1) {
            System.out.println("You have a pair !! ");
            prize = 2;
        }
        if (kortsuits[0].equals(kortsuits[1]) && kortsuits[1].equals(kortsuits[2]) && kortsuits[2].equals(kortsuits[3]) && kortsuits[3].equals(kortsuits[4])) {
            System.out.println("Du har en flush");
            prize = 12;
        }
        if (kortvarden[4] - kortvarden[3] == 1 && kortvarden[3] - kortvarden[2] == 1 && kortvarden[2] - kortvarden[1] == 1 && kortvarden[1] - kortvarden[0] == 1) {
            System.out.println("Du har en straight!!");
            prize = 12;
        }
        return prize;


    }


}


