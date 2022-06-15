package com.example.project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerList {
    public static String username;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Player> players = new ArrayList<>();

    public static ArrayList createPlayers(String fileName) throws IOException{
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String playerString = "";
        while((line = br.readLine())!= null){

            if (!line.equals(";")){
                playerString += line;
            }
            else{
                parsePlayer(playerString);
                playerString = "";
            }
        }
        return players;

    }
    private static void parsePlayer(String string){
        int pos = 0;
        String username = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ','){
                pos = i;
                username = string.substring(0, pos);
            }
        }
        Player newPlayer = new Player(username);
        boolean dupe = false;

        for (int i = 0; i < players.size(); i++) {
            if (newPlayer.comparePlayer(players.get(i))){
                dupe = true;
            }
        }
        if (!dupe){
            players.add(newPlayer);
        }
    }


}

