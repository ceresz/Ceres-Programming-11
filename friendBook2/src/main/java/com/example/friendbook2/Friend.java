package com.example.friendbook2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    public String firstName;
    public int age;

    public Friend(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "Name: " + firstName + "\tAge: " + age;
    }

    public void writeToFile(String filename) throws IOException{
        FileWriter fw = new FileWriter(filename,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(firstName + ",\r");
        bw.write(age + "\r");
        bw.write(";\r");
        bw.close();
    }

    public boolean compareFriend(Friend p){
        return this.firstName.equals(p.firstName);
    }
}