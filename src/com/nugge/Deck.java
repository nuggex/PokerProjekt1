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
    public static void print(ArrayList<Card> hand){
        String[] cardvaluseaschars = new String[5];
        for(int i = 0; i<5; i++){
            if(hand.get(i).values == 13){
                cardvaluseaschars[i] = "K";
            }
            if(hand.get(i).values == 12){
                cardvaluseaschars[i] = "Q";
            }
            if(hand.get(i).values == 11){
                cardvaluseaschars[i] = "J";
            }
            if(hand.get(i).values == 10){
                cardvaluseaschars[i] = "T";
            }
            if(hand.get(i).values == 1){
                cardvaluseaschars[i] = "A";
            }if(hand.get(i).values == 0){
                cardvaluseaschars[i] = "J";
            }
            if(hand.get(i).values <10 && hand.get(i).values >1){
                cardvaluseaschars[i] = String.valueOf(hand.get(i).values);
            }


        }
        System.out.println("╔═════╗ "+"╔═════╗ "+"╔═════╗ "+"╔═════╗ "+"╔═════╗ ");
        System.out.println("║"+cardvaluseaschars[0]+"    ║ "+"║"+cardvaluseaschars[1]+"    ║ "+"║"+cardvaluseaschars[2]+"    ║ "+"║"+cardvaluseaschars[3]+"    ║ "+"║"+cardvaluseaschars[4]+"    ║ ");
        System.out.println("║  "+hand.get(0).color+"  ║ "+"║  "+hand.get(1).color+"  ║ "+"║  "+hand.get(2).color+"  ║ "+"║  "+hand.get(3).color+"  ║ "+"║  "+hand.get(4).color+"  ║ ");
        System.out.println("║    "+cardvaluseaschars[0]+"║ "+"║    "+cardvaluseaschars[1]+"║ "+"║    "+cardvaluseaschars[2]+"║ "+"║    "+cardvaluseaschars[3]+"║ "+"║    "+cardvaluseaschars[4]+"║ ");
        System.out.println("╚═════╝ "+"╚═════╝ "+"╚═════╝ "+"╚═════╝ "+"╚═════╝ ");
    }
}
