package com.nugge;

import java.util.*;

class Win {

    double wins(ArrayList<Card> hand) {

        // kortvarden used for straight, kortsuits for flushes //
        int[] kortvarden = {hand.get(0).values, hand.get(1).values, hand.get(2).values, hand.get(3).values, hand.get(4).values};
        String[] kortsuits = {hand.get(0).color, hand.get(1).color, hand.get(2).color, hand.get(3).color, hand.get(4).color};

        Arrays.sort(kortvarden);
        Arrays.sort(kortsuits);// Joker will always end up at position 0++;
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

        prize += getFiveOfAKind(x, kortsuits);
        if (prize == 0) {
            prize += getQuads(x, y, kortsuits);
        }
        if (prize == 0) {
            prize += getStraightAndFlushes(kortvarden, kortsuits, x);
        }
        if (prize == 0) {
            prize += getFullHouse(x, y, kortsuits);
        }
        if (prize == 0) {
            prize += getThreeOfAKind(x, y, kortsuits);
        }
        if (prize == 0) {
            prize += getTwoPairs(x, y);
        }
        if (prize == 0) {
            prize += getPair(x, y, kortsuits);
        }


        //exception to find ace high if all else fails, this was the easiest way of doing this wihtout makinga a bunch of conditions for the if statement to find a hand with only ace high //
        if (prize == 0) {
            prize += getAceHigh(kortvarden, x);

            if (prize == 0) {
                System.out.println("No Winnings this round");
            }
        }
        return prize;
    }

    // methods for each winning condtion lie here //

    private double getFiveOfAKind(int x, String[] kortsuits) {
        if (kortsuits[0].equals("J") && x == 4) {
            System.out.println("Five of a kind! == 1000 Bang Bucks");
            return 1000;
        }
        if (kortsuits[0].equals("J") && kortsuits[1].equals("J") && x == 3) {
            System.out.println("Five of a kind! == 1000 Bang Bucks");
            return 1000;
        }
        return 0;
    }

    private double getQuads(int x, int y, String[] kortsuits) {
        if (kortsuits[0].equals("J") && x == 3) {
            System.out.println("Four of a kind! == 12 Bang Bucks");
            return 12;
        }
        if (kortsuits[0].equals("J") && kortsuits[1].equals("J") && y == 2) {
            System.out.println("Four of a kind! == 12 Bang Bucks");
            return 12;
        }
        if (x == 4) {
            System.out.println("Four of a kind! == 12 Bang Bucks");
            return 12;
        }
        return 0;
    }

    private double getFullHouse(int x, int y, String[] kortsuits) {
        if (kortsuits[0].equals("J") && x == 2 && y == 2) {
            System.out.println("Full House! == 8 Bang Bucks");
            return 8;
        }
        if (x == 3 && y == 2) {
            System.out.println("Full House! == 8 Bang Bucks");
            return 8;
        }
        return 0;
    }

    private double getThreeOfAKind(int x, int y, String[] kortsuits) {
        if (x == 1 && kortsuits[0].equals("J") && kortsuits[1].equals("J")) {
            System.out.println("Three of a kind! == 6 Bang Bucks");
            return 6;
        }
        if (x == 2 && kortsuits[0].equals("J")) {
            System.out.println("Three of a kind! == 6 Bang Bucks");
            return 6;
        }
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

    private double getPair(int x, int y, String[] kortsuits) {
        if (x == 1 && kortsuits[0].equals("J") || x == 2 && y == 1) {
            System.out.println("Pair! == 2 Bang Bucks");
            return 2;
        }
        /*
        if (x == 2 && y == 1) {
            System.out.println("Pair! == 2 Bang Bucks");
            return 2;
        }*/
        return 0;
    }

    private double getAceHigh(int[] kortvarden, int x) {
        if (kortvarden[0] == 1 && x == 1) {
            System.out.println("Ace High Up In This House!! == 1 Bang Buck");
            return 1;
        }
        return 0;
    }

    // This condition took some doing, use math to generate booleans to first test the hand and then use the booleans for identifying the hand //
    private double getStraightAndFlushes(int[] kortvarden, String[] kortsuits, int x) {

        boolean flush = false;
        boolean straight = false;
        boolean royal = false;
        // Check for flush without jokers//
        if (kortsuits[0].equals(kortsuits[1]) && kortsuits[1].equals(kortsuits[2]) && kortsuits[2].equals(kortsuits[3]) && kortsuits[3].equals(kortsuits[4])) {
            flush = true;
        }
        //  Check for straight without jokers //
        if (kortvarden[4] - kortvarden[3] == 1 && kortvarden[3] - kortvarden[2] == 1 && kortvarden[2] - kortvarden[1] == 1 && kortvarden[1] - kortvarden[0] == 1) {
            straight = true;
        }
        // Check for royal straight without jokers //
        if (kortvarden[4] - kortvarden[0] == 12 && kortvarden[4] - kortvarden[3] == 1 && kortvarden[3] - kortvarden[2] == 1 && kortvarden[2] - kortvarden[1] == 1) {
            royal = true;
        }
        // Check for flush with two jokers //
        if (kortsuits[0].equals("J") && kortsuits[1].equals("J") && kortsuits[2].equals(kortsuits[3]) && kortsuits[3].equals(kortsuits[4])) {
            flush = true;
        }
        // Check for flush with one joker //
        if (kortsuits[0].equals("J") && kortsuits[1].equals(kortsuits[2]) && kortsuits[2].equals(kortsuits[3]) && kortsuits[3].equals(kortsuits[4])) {
            flush = true;
        }

        // Straight with two jokers //

        // new implementation //
        if (kortvarden[0] == 0 && kortvarden[1] == 0 && x == 1 && kortvarden[4] - kortvarden[2] == 4 || kortvarden[4] - kortvarden[2] == 3 || kortvarden[4] - kortvarden[2] == 2) {
            straight = true;
        }
        // Straight with one joker //
        if (kortvarden[0] == 0 && x == 1 && kortvarden[4] - kortvarden[1] == 3 || kortvarden[4] - kortvarden[1] == 4) {
            straight = true;
        }

        // Royal straight without Aces and one joker//
        if (kortvarden[1] != 1) {
            if (kortvarden[0] == 0 && kortvarden[1] > 9 && kortvarden[4] - kortvarden[3] > 0 && kortvarden[3] - kortvarden[2] > 0 && kortvarden[2] - kortvarden[1] > 0) {
                royal = true;
            }
        }
        // Royal Straight with aces and one joker //
        if (kortvarden[0] == 0 && kortvarden[1] == 1 && kortvarden[2] > 9 && kortvarden[4] - kortvarden[3] > 0 && kortvarden[3] - kortvarden[2] > 0) {
            royal = true;
        }
        // royal straight two jokers and an ace//
        if (kortvarden[0] == 0 && kortvarden[1] == 0 && kortvarden[2] == 1 && kortvarden[3] > 9 && kortvarden[4] - kortvarden[3] > 0) {
            royal = true;
        }
        // royal straight two jokers without an ace //
        if (kortvarden[0] == 0 && kortvarden[1] == 0 && kortvarden[2] > 9 && kortvarden[4] - kortvarden[3] > 0 && kortvarden[3] - kortvarden[2] > 0) {
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


