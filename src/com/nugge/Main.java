package com.nugge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double mymoney =10;
        Win mywin  = new Win();


        Player myplayer = new Player();
        //System.out.println(mydeck.deck);




        //System.out.println(mydeck.deck);
        int i = 0;
        int cc = 1;
        System.out.println("Welcome to the Poker game \n One game costs 2 dollars\n Input 1 to start. (We were kind enough to give you 10 dollars)");
        int play = input.nextInt();
        while(play==1){
            i=0;
            cc=1;
            mymoney -= 2;
            Deck mydeck = new Deck(Cardgenerator.getNewDeck());
            ArrayList<Card> current;
            current = mydeck.firstdeal();
            System.out.println(current);


        while (cc != 0 && i < 2) {

            System.out.println("Hur många kort vill du byta? [0-5]");
            for(int k = 0; k <1; k++) {
                cc = input.nextInt();

                if (cc < 0 || cc > 5){
                    System.out.println("That is not between 0 and 5");
                    k--;
                }
            }
            for (int j = 0; j < cc; j++) {


                int change = myplayer.changecard();
                if(change == -1) cc = j;
                current.set(change, mydeck.deck.remove(0));



            }

            System.out.println(current);
            i++;

        }
        //System.out.println(current);
        //System.out.println(mywin.wins(current));

        //mymoney += mywin.wins(current);

        //OUBLING FUNCTIONALITY GOES HERE ->> Player.java needs to shuffle a new deck
        double temp = mywin.wins(current);
        if(temp>0) {
            System.out.println("Do you want to double? Y / N");
            char d = input.next().charAt(0);
            for(int l = 0; l<1; l++) {
                if (d == 'Y') {
                    temp = myplayer.doubler(temp);
                    if(temp > 0){
                        System.out.println("Do you want to double again? Y / N");
                        d = input.next().charAt(0);
                        if(d == 'Y') l--;
                    }
                }
                if (d == 'N') {
                    mymoney += temp;
                }
            }
        }
        System.out.println("You have: " + mymoney +" dollars in the bank");

            if(mymoney<2){
                System.out.println("You can't afford to play");
                return;
            }
            System.out.println("\nDo you want to continue playing? Yes = 1 , No = 0");
            play = input.nextInt();

        }
        System.out.println("Sad to see you go");
    }
}
