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
}
