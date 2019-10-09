package com.nugge;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class Win {

    double wins(ArrayList<Card> hand) {

        int b = hand.get(1).values;

        double prize = 0;
        int[] lista = new int[12];
        for (Card v  : hand
             ) {

            lista[v.values]++;
        }
        return prize;



        }


    }


