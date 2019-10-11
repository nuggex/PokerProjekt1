package com.nugge;

import java.util.*;

class Win {

    double wins(ArrayList<Card> hand) {

        // kortvarden used for straight, kortsuits for flushes //
        int[] kortvarden = {hand.get(0).values, hand.get(1).values, hand.get(2).values, hand.get(3).values, hand.get(4).values};
        String[] kortsuits = {hand.get(0).color, hand.get(1).color, hand.get(2).color, hand.get(3).color, hand.get(4).color};

        Arrays.sort(kortvarden);

        double prize = 0;
        int[] lista = new int[18]; //for reasons currently unknow lista has to be 17 or higher for everything to work. It's size really doesn't matter thou.

        // this is for finding pairs, triples or quads //
        // adds 1 to the position in the lista array of the value of the card in the hand  used for pairs, triples, quads, full house and ace high/ /
        for (int i = 0; i < 5; i++) lista[kortvarden[i]]++;

        // x = highest card, y = next highest card //
        Arrays.sort(lista);
        int x = lista[lista.length - 1];
        int y = lista[lista.length - 2];

        // run all methods for checking the hand for wins //
        prize += getQuads(x, y);
        prize += getFullHouse(x, y);
        prize += getThreeOfAKind(x, y);
        prize += getTwoPairs(x, y);
        prize += getPair(x, y);
        prize += getStraightAndFlushes(kortvarden, kortsuits);


        //exception to find ace high if all else fails, this was the easiest way of doing this wihtout makinga a bunch of conditions for the if statement to find a hand with only ace high //
        if (prize == 0) {
            prize += getAceHigh(kortvarden, x, y);

            if (prize == 0) {
                System.out.println("No Winnings this round");
            }
        }
        return prize;
    }

    // methods for each winning condtion lie here //
    private double getQuads(int x, int y) {
        if (x == 4) {
            System.out.println("Four of a kind! == 12 Bang Bucks");
            return 12;
        }
        return 0;
    }

    private double getFullHouse(int x, int y) {
        if (x == 3 && y == 2) {
            System.out.println("Full House! == 8 Bang Bucks");
            return 8;
        }
        return 0;
    }

    private double getThreeOfAKind(int x, int y) {
        if (x == 3 && y == 1) {
            System.out.println("Three of a kind! == 6 Bang Bucks");
            return 6;
        }
        return 0;
    }

    private double getTwoPairs(int x, int y) {
        if (x == 2 && y == 2) {
            System.out.println("Two pairs! == 4 Bang Bucks");
            return 4;
        }
        return 0;
    }

    private double getPair(int x, int y) {
        if (x == 2 && y == 1) {
            System.out.println("Pair! == 2 Bang Bucks");
            return 2;
        }
        return 0;
    }

    private double getAceHigh(int[] kortvarden, int x, int y) {
        if (kortvarden[0] == 1 && x == 1) {
            System.out.println("Ace High Up In This House!! == 1 Bang Buck");
            return 1;
        }
        return 0;
    }

    // This condition took some doing, use math to generate booleans to first test the hand and then use the booleans for identifying the hand //
    private double getStraightAndFlushes(int[] kortvarden, String[] kortsuits) {

        boolean flush = false;
        boolean straight = false;
        boolean royal = false;
        if (kortsuits[0].equals(kortsuits[1]) && kortsuits[1].equals(kortsuits[2]) && kortsuits[2].equals(kortsuits[3]) && kortsuits[3].equals(kortsuits[4])) {
            flush = true;
        }
        if (kortvarden[4] - kortvarden[3] == 1 && kortvarden[3] - kortvarden[2] == 1 && kortvarden[2] - kortvarden[1] == 1 && kortvarden[1] - kortvarden[0] == 1) {
            straight = true;
        }
        if (kortvarden[4] - kortvarden[0] == 12 && kortvarden[4] - kortvarden[3] == 1 && kortvarden[3] - kortvarden[2] == 1 && kortvarden[2] - kortvarden[1] == 1) {
            royal = true;
        }
        if (flush && royal) {
            System.out.println("Royal Straight Flush! == 100 Bang Bucks");
            return 100;
        }
        if (flush && !straight) {
            System.out.println("Flush! == 12 Bang Bucks");
            return 12;
        }
        if (!flush && straight || royal) {
            System.out.println("Straight! == 10 Bang Bucks");
            return 10;
        }

        if (flush) {
            System.out.println("Straight Flush! == 50 Bang Bucks");
            return 50;
        }

        return 0;
    }

}


