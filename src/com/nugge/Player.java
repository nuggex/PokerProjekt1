package com.nugge;

import java.util.ArrayList;
import java.util.Scanner;

class Player {
    Deck mydeck = new Deck(Cardgenerator.getNewDeck());
    int changecard() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter which card you want to change 1-5 (0 for none): ");
        int test = 0;
        for (int i = 0; i < 1; i++) {
            test = input.nextInt();
            if (test <= 0 || test >5) {
                System.out.println("Not a valid number please try again!");
                i--;
            }
        }
        return test - 1;

    }
    double doubler(double temp){
        Scanner input = new Scanner(System.in);
        System.out.println("Make a guess H(8-13) or L(1-6)");
        char guess = input.next().charAt(0);
        int gg = 0;
        if(guess =='H'){
            gg = 8;
        }if(guess =='L'){
            gg = 6;
        }
        ArrayList<Card> card = Cardgenerator.getNewDeck();
        int f = card.get(0).values;
        System.out.println("Your guess was " +guess+" And the card was " +card.get(0));
        if(f ==7){
            System.out.println("No winnings");
            return 0;
        }if(f < 7 && gg < 7){
            System.out.println("Winner! "+temp*2);
            return temp * 2;
        }if(f > 7 && gg > 7){
            System.out.println("Winner! " +temp*2);
            return temp *2;
        }
        System.out.println("No winnings");
        return 0;
    }
}

