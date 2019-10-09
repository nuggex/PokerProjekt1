package com.nugge;


import java.util.ArrayList;
import java.util.Collections;

class card {
    String color;
    int values;

    @Override
    public String toString() {
        return color + "" + values;
    }
}

class cardgenerator {
    private static int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static String[] color = {"♦", "♥", "♣", "♠"};

    static ArrayList<card> getNewDeck() {
        ArrayList<card> deck = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                card card = new card();
                card.color = color[j];
                card.values = values[i];
                deck.add(card);
            }
        }
        Collections.shuffle(deck);

        return deck;
    }
}

class Deck {

    ArrayList<card> deck;

    Deck(ArrayList<card> freshd) {
        deck = freshd;
    }


    ArrayList<card> firstdeal() {
        ArrayList<card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.remove(0));
        }
        return hand;

    }





}
