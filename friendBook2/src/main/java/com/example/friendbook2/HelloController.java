package com.example.friendbook2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    public TextField getFirstName;
    public TextField getAge;
    public Button createFriend;
    public ListView<Friend> friendList = new ListView<>();
    public Label IbIFirstName;
    public Label IbIAge;
    public Button deleteFriend;
    public TextField filenamer;





    public void addFriend(ActionEvent actionEvent){
        String firstName = getFirstName.getText();
        int age = Integer.parseInt(getAge.getText());
        Friend friend = new Friend(firstName,age);
        friendList.getItems().add(friend);
        getFirstName.clear();
        getAge.clear();

    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend friend;
        friend = friendList.getSelectionModel().getSelectedItem();
        IbIAge.setText(Integer.toString(friend.getAge()));
        IbIFirstName.setText(friend.firstName);
    }

    public void deleteFriend(ActionEvent mouseEvent) {
        Friend friend;
        friend = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(friend);
        IbIAge.setText("");
        IbIFirstName.setText("");
    }

    public void saveFriend(ActionEvent actionEvent) throws IOException{
        ObservableList<Friend> myList = friendList.getItems();
        for (Friend p : myList){
            p.writeToFile(filenamer.getText());
        }
        friendList.getItems().clear();
    }

    public void loadFriend(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends(filenamer.getText());
        for(Friend p : friends){
            friendList.getItems().add(p);
        }
        friends.clear();

    }


    public void clearList(ActionEvent actionEvent) {
        friendList.getItems().clear();
    }


}