package com.nugge;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

// This method is only for taking in and validating the number for the card to be changed  card since the all actual deck functionality lies in Deck //
class Player {
    int changecard() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which card you want to change 1-5 (0 for none): ");
        char test;
        int change = 0;
        for (int i = 0; i < 1; i++) {
            test = input.next().charAt(0);
            if (test != '0' && test != '1' && test != '2' && test != '3' && test != '4' && test != '5') {
                System.out.println("Not a valid number please try again!");
                i--;
            }
            change = Character.getNumericValue(test);

        }
        return change - 1;

    }

    // The doubler generates a new deck and then compares the card at position 1 to the guess of the user //
    double doubler(double temp) {
        Scanner input = new Scanner(System.in);
        System.out.println("Make a guess H(8-13) or L(1-6)");
        char guess = 'a';
        for (int i = 0; i < 1; i++) {
            guess = toUpperCase(input.next().charAt(0));
            if (guess != 'H' && guess != 'L') {
                System.out.println("That is not H or L!");
                i--;
            }
        }
        int gg = 0;
        if (guess == 'H') {
            gg = 8;
        }
        if (guess == 'L') {
            gg = 6;
        }
        ArrayList<Card> card = Cardgenerator.getNewDeck();
        int f = card.get(0).values;
        System.out.println("Your guess was " + guess + " And the card was " + card.get(0));
        if (f == 7) {
            System.out.println("That's a 7 and you lost your bet!");
            return 0;
        }
        if (f < 7 && gg < 7) {
            System.out.println("Winner Winner, Chicken Dinner! " + temp * 2);
            return temp * 2;
        }
        if (f > 7 && gg > 7) {
            System.out.println("Winner Winner, Chicken Dinner! " + temp * 2);
            return temp * 2;
        }
        System.out.println("Your guess is potato");
        return 0;
    }
}

