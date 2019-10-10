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
    private static String[] color = {"♦", "♥", "♣", "♠"};

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
        Collections.shuffle(deck);
        return deck;
    }
}

class Deck {

    ArrayList<Card> deck;

    Deck(ArrayList<Card> freshd) {
        deck = freshd;
    }

    ArrayList<Card> firstdeal() {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.remove(0));
        }
        return hand;
    }
}
