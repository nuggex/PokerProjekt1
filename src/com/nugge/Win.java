package com.nugge;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;


class Win {


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
        int[] lista = new int[18];

        // this is for finding pairs, triples or quads //

        for (int i = 0; i < 5; i++) lista[kortvarden[i]]++;

       /* for (Card v : hand
        ) {

            lista[v.values]++;
        }*/
        Arrays.sort(lista);
        int x = lista[lista.length - 1];
        int y = lista[lista.length - 2];
        boolean flush = false;
        boolean straight = false;
        boolean king = false;

        if (kortvarden[4] == 13) king = true;
        if (x == 4) {
            System.out.println("Four of a kind! == 12 Dollars");
            return 12;
        }
        if (x == 3 && y == 2) {
            System.out.println("Full House! == 8 Dollars");
            return 8;
        }
        if (x == 3 && y == 1) {
            System.out.println("Three of a kind! == 6 Dollars");
            return 6;
        }

        if (x == 2 && y == 2) {
            System.out.println("Two pairs! == 4 Dollars");
            return 4;
        }
        if (x == 2 && y == 1) {
            System.out.println("Pair! == 2 Dollars");
            return 2;
        }
        if (kortsuits[0].equals(kortsuits[1]) && kortsuits[1].equals(kortsuits[2]) && kortsuits[2].equals(kortsuits[3]) && kortsuits[3].equals(kortsuits[4])) {
            flush = true;
        }
        if (kortvarden[4] - kortvarden[3] == 1 && kortvarden[3] - kortvarden[2] == 1 && kortvarden[2] - kortvarden[1] == 1 && kortvarden[1] - kortvarden[0] == 1) {
            straight = true;
        }
        if (kortvarden[4] - kortvarden[0] == 12 && kortvarden[4] - kortvarden[3] == 1 && kortvarden[3] - kortvarden[2] == 1 && kortvarden[2] - kortvarden[1] == 1) {
            straight = true;
    }
        if (flush && !straight) {
            System.out.println("Flush! == 12 Dollars");
            return 12;
        }
        if (!flush && straight) {
            System.out.println("Straight! == 10 Dollars");
            return 10;
        }
        if (flush && !king) {
            System.out.println("Straight Flush! == 50 Dollars");
            return 50;
        }
        if (flush){
            System.out.println("Royal Straight Flush! == 100 Dollars");
            return 100;
        }
        System.out.println("No winning this round!");
        return prize;

    }


}


