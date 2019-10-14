package com.nugge;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Main {
    static Scanner input = new Scanner(System.in);
/// TEST //

    public static void main(String[] args) {
        double mymoney = 10;
        Win mywin = new Win();
        System.out.println("testtestsetset");
        Player myplayer = new Player();

        System.out.println("Welcome to the Poker game \n One game costs 2 Bang Bucks\n  ");
        System.out.println("WINNING HANDS \n ♥1  ♥13 ♥12 ♥11 ♥10    Royal Flush 100 \n ♦8  ♦7  ♦6  ♦5  ♦4     Straight Flush 50 \n ♦10 ♥10 ♣10 ♠10 ♣5     Four of a Kind 12 \n ♦7  ♥7  ♣1  ♠1  ♥1     Full House 10 \n ♦3  ♦8  ♦9  ♦11 ♦13    Flush 12 \n ♦10 ♥9  ♣8  ♠7  ♣6     Straight 10 \n ♦5  ♥5  ♣5  ♠2  ♣9     Three of a kind 6 \n ♦10 ♥10 ♣8  ♠8  ♣6     Two Pairs 4 \n ♦9  ♥9  ♣10 ♠7  ♣6     Pair 2\n ♦1  ♣8  ♠7  ♥9  ♣6     Ace High 1   ");
        System.out.println(" Do you want to play? Yes / No \n (We were kind enough to give you 10 Bang Bucks)");
        char play = toUpperCase(input.next().charAt(0));
        while (play == 'Y') {
            int i = 0;
            int cc = 1;
            mymoney -= 2;
            Deck mydeck = new Deck(Cardgenerator.getNewDeck());
            ArrayList<Card> current;
            current = mydeck.firstdeal();
            System.out.println(current);

            while (cc != 0 && i < 100) {

                System.out.println("How many cards do you want to change? [0-5]");
                for (int k = 0; k < 1; k++) {
                    char inputchar = input.next().charAt(0);
                    if (inputchar != '0' && inputchar != '1' && inputchar != '2' && inputchar != '3' && inputchar != '4' && inputchar != '5') {
                        System.out.println("Not a valid number");
                        k--;
                    }
                    cc = Character.getNumericValue(inputchar);
                }
                for (int j = 0; j < cc; j++) {

                    int change = myplayer.changecard();

                    if (change == -1) cc = j;
                    if (change > -1) {
                        current.set(change, mydeck.deck.remove(0));
                    }
                }
                System.out.println(current);
                i++;
            }

            //Doubling functionality from Player.Java. temp stores the winnings untill player decides to end doubling.
            double temp = mywin.wins(current);
            if (temp > 0) {
                System.out.println("Do you want to double? Yes / No");
                char d = toUpperCase(input.next().charAt(0));
                for (int l = 0; l < 1; l++) {
                    if (d == 'Y') {
                        temp = myplayer.doubler(temp);
                        if (temp > 0) {
                            System.out.println("Do you want to double again? Yes / No");
                            d = toUpperCase(input.next().charAt(0));
                            if (d == 'Y') l--;
                        }
                    }
                }
                mymoney += temp;
            }
            System.out.println("You have: " + mymoney + " Bang Bucks in the bank");

            if (mymoney < 2) {
                System.out.println("You can't afford to play!");
                return;
            }
            System.out.println("\nDo you want to continue playing? Yes / No ");
            for (int z = 0; z < 1; z++) {
                play = toUpperCase(input.next().charAt(0));
                if (play != 'Y' && play != 'N') {
                    System.out.println("Please enter either Yes or No you cheeky scrub");
                    z--;
                }
            }
        }
        System.out.println("Sad to see you go, you cash out a total of: " + mymoney + " Bang Bucks");
    }
}
