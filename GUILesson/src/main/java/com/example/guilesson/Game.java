package com.example.guilesson;

public class Game {
    public int dice1;
    public int dice2;
    public boolean bet;
    public int points;

    Game(){
        points = 1000;
    }
    public int getDice1(){
        return dice1;
    }

    public void setDice1(int a){
        this.dice1 = a;
    }

    public int getDice2(){
        return dice2;
    }

    public void setDice2(int a){
        this.dice2 = a;
    }

    public boolean getBet(){
        return bet;
    }

    public void setBet(boolean a){
        this.bet = a;
    }

    public int getPoints(){
        return points;
    }

    public void setWinPoints(){
        points = points + 100;
    }

    public void setLosePoints(){
        points = points - 100;
    }

    public void clearDie() {
       setDice1(0);
       setDice2(0);
    }
}
