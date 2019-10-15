package com.nugge;

import java.util.ArrayList;
import java.util.Collections;

class Card {
    String color;
    int values;

    @Override
    public String toString() {
        return color + "" + values;
    }
}


class Cardgenerator {
    private static String[] color = {"\u2666", "\u2665", "\u2663", "\u2660"};

    // Populate the deck and shuffle it //
    static ArrayList<Card> getNewDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                Card Card = new Card();
                Card.color = color[j];
                Card.values = i;
                deck.add(Card);
            }
        }
        for (int i = 0; i < 2; i++) {
            Card Card = new Card();
            Card.color = "J";
            Card.values = 0;
            deck.add(Card);
        }
        Collections.shuffle(deck);
        return deck;
    }
}

class Deck {
    // Create the empty deck //
    ArrayList<Card> deck;

    Deck(ArrayList<Card> freshd) {
        deck = freshd;
    }

    // Deal the first hand //
    ArrayList<Card> firstdeal() {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.remove(0));
        }
        return hand;
    }

    static void print(ArrayList<Card> hand) {
        String[] cardvaluseaschars = new String[10];
        String[] cardsuits = new String[5];
        for (int i = 0; i < 5; i++) {
            if (hand.get(i).values == 13) {
                cardvaluseaschars[i] = "K ";
                cardvaluseaschars[i + 5] = " K";
            }
            if (hand.get(i).values == 12) {
                cardvaluseaschars[i] = "Q ";
                cardvaluseaschars[i + 5] = " Q";
            }
            if (hand.get(i).values == 11) {
                cardvaluseaschars[i] = "J ";
                cardvaluseaschars[i + 5] = " J";
            }
            if (hand.get(i).values == 10) {
                cardvaluseaschars[i] = "10";
                cardvaluseaschars[i + 5] = "10";
            }
            if (hand.get(i).values == 1) {
                cardvaluseaschars[i] = "A ";
                cardvaluseaschars[i + 5] = " A";
            }
            if (hand.get(i).values == 0) {
                cardvaluseaschars[i] = "* ";
                cardvaluseaschars[i + 5] = " *";
            }
            if (hand.get(i).values < 10 && hand.get(i).values > 1) {
                cardvaluseaschars[i] = hand.get(i).values + " ";
                cardvaluseaschars[i + 5] = " " + hand.get(i).values;

            }
            if (hand.get(i).color.equals("J")) {
                cardsuits[i] = "JOKER";
            }
            if (!hand.get(i).color.equals("J")) {
                cardsuits[i] = "  " + hand.get(i).color + "  ";
            }


        }
        System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2557 " + "\u2554\u2550\u2550\u2550\u2550\u2550\u2557 " + "\u2554\u2550\u2550\u2550\u2550\u2550\u2557 " + "\u2554\u2550\u2550\u2550\u2550\u2550\u2557 " + "\u2554\u2550\u2550\u2550\u2550\u2550\u2557 ");
        System.out.println("\u2551" + cardvaluseaschars[0] + "   \u2551 " + "\u2551" + cardvaluseaschars[1] + "   \u2551 " + "\u2551" + cardvaluseaschars[2] + "   \u2551 " + "\u2551" + cardvaluseaschars[3] + "   \u2551 " + "\u2551" + cardvaluseaschars[4] + "   \u2551 ");
        System.out.println("\u2551" + cardsuits[0] + "\u2551 " + "\u2551" + cardsuits[1] + "\u2551 " + "\u2551" + cardsuits[2] + "\u2551 " + "\u2551" + cardsuits[3] + "\u2551 " + "\u2551" + cardsuits[4] + "\u2551 ");
        System.out.println("\u2551   " + cardvaluseaschars[5] + "\u2551 " + "\u2551   " + cardvaluseaschars[6] + "\u2551 " + "\u2551   " + cardvaluseaschars[7] + "\u2551 " + "\u2551   " + cardvaluseaschars[8] + "\u2551 " + "\u2551   " + cardvaluseaschars[9] + "\u2551 ");
        System.out.println("\u255A\u2550\u2550\u2550\u2550\u2550\u255D " + "\u255A\u2550\u2550\u2550\u2550\u2550\u255D " + "\u255A\u2550\u2550\u2550\u2550\u2550\u255D " + "\u255A\u2550\u2550\u2550\u2550\u2550\u255D " + "\u255A\u2550\u2550\u2550\u2550\u2550\u255D ");
    }

    static void printOne(ArrayList<Card> onecard) {
        String[] cardvaluseaschars = new String[1];
        for (int i = 0; i < 1; i++) {
            if (onecard.get(i).values == 13) {
                cardvaluseaschars[i] = "K";
            }
            if (onecard.get(i).values == 12) {
                cardvaluseaschars[i] = "Q";
            }
            if (onecard.get(i).values == 11) {
                cardvaluseaschars[i] = "J";
            }
            if (onecard.get(i).values == 10) {
                cardvaluseaschars[i] = "T";
            }
            if (onecard.get(i).values == 1) {
                cardvaluseaschars[i] = "A";
            }
            if (onecard.get(i).values == 0) {
                cardvaluseaschars[i] = "*";
            }
            if (onecard.get(i).values < 10 && onecard.get(i).values > 1) {
                cardvaluseaschars[i] = String.valueOf(onecard.get(i).values);
            }
            System.out.println("\u2554\u2550\u2550\u2550\u2550\u2550\u2557");
            System.out.println("\u2551" + cardvaluseaschars[0] + "    \u2551");
            System.out.println("\u2551  " + onecard.get(0).color + "  \u2551");
            System.out.println("\u2551    " + cardvaluseaschars[0] + "\u2551");
            System.out.println("\u255A\u2550\u2550\u2550\u2550\u2550\u255D");


        }
    }
}
