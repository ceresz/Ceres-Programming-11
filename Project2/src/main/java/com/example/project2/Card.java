package com.example.project2;

public class Card {

    String face;
    int value;

    public Card(){
    }

    public Card(int index, String face, int value){
        this.face = face;
        this.value = value;
    }
    //setter
    public void setValue(int v){
        this.value = v;
    }

    //getter
    public int getValue(){
        return this.value;
    }

    //setter
    public void setFace(String f){
        this.face = f;
    }

    //getter
    public String getFace(){
        return this.face;
    }
}
