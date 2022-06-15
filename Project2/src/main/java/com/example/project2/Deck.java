package com.example.project2;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();


    public Deck (){
        //set deck with face and value
        this.deck.add(new Card(0,"Ace",11));
        this.deck.add(new Card(1,"Two",2));
        this.deck.add(new Card(2,"Three",3));
        this.deck.add(new Card(3,"Four",4));
        this.deck.add(new Card(4,"Five",5));
        this.deck.add(new Card(5,"Six",6));
        this.deck.add(new Card(6,"Seven",7));
        this.deck.add(new Card(7,"Eight",8));
        this.deck.add(new Card(8,"Nine",9));
        this.deck.add(new Card(9,"Ten",10));
        this.deck.add(new Card(10,"Jack",10));
        this.deck.add(new Card(11,"Queen",10));
        this.deck.add(new Card(12,"King",10));
    }

    public Card getRandom (){
    //randomizer for dealing cards
        Random random = new Random();
        int max = 12;
        int min = 0;
        int value = random.nextInt(max + min);
        return this.deck.get(value);
    }

    //method for adding cards in player's hand
    public int addCards (ArrayList<Card> list){
        int totalValue = 0;
        for(int i=0; i<list.size(); i++){
            totalValue += list.get(i).value;
        }
        return totalValue;
    }

    public boolean contains (Card card){
        return deck.contains(card);
    }
}
