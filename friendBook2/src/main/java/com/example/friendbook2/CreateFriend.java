package com.example.friendbook2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String firstname;
    private static Integer age;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList createAllFriends(String fileName) throws IOException{
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while((line = br.readLine())!= null){

            if (!line.equals(";")){
                friendString += line;
            }
            else{
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;

    }

    private static void parseFriend(String string){
        int pos = 0;
        String firstname = "";
        int age = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ','){
                pos = i;
                firstname = string.substring(0, pos);
                age = Integer.parseInt(string.substring(pos + 1));
            }
        }
        Friend newFriend = new Friend(firstname,age);
        boolean dupe = false;

        for (int i = 0; i < friends.size(); i++) {
            if (newFriend.compareFriend(friends.get(i))){
                dupe = true;
            }
        }
        if (!dupe){
            friends.add(newFriend);
        }
    }



}
