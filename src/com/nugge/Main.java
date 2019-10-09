package com.nugge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double mymoney =0;
        Win mywin  = new Win();
        Deck mydeck = new Deck(Cardgenerator.getNewDeck());

        Player myplayer = new Player();
        //System.out.println(mydeck.deck);
        ArrayList<Card> current;
        current = mydeck.firstdeal();

        System.out.println(current);
        //System.out.println(mydeck.deck);
        int i = 0;
        int cc = 1;
        while (cc != 0 && i < 100) {

            System.out.println("Hur många kort vill du byta? [0-5]");
            cc = input.nextInt();

            for (int j = 0; j < cc; j++) {


                int change = myplayer.changecard();
                if(change == -1) cc = j;
                current.set(change, mydeck.deck.remove(0));
                System.out.println(current);


            }
            if(i == 0)System.out.println(current);
            i++;

        }
        //System.out.println(current);
        System.out.println(mywin.wins(current));
        mymoney += mywin.wins(current);
       // System.out.println("I have" + mymoney);

    }
}
