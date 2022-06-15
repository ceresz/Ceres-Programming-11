package com.example.project2;

import java.io.*;

public class Player {
    public String username;

    public Player(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "Name: " + username;
    }

    public void writeToFile(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(username + ",\r");
        bw.write(";\r");
        bw.close();
    }

    public boolean comparePlayer(Player p) {
        return this.username.equals(p.username);
    }
}

