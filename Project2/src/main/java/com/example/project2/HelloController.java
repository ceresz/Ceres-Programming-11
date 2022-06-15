package com.example.project2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class HelloController {
    public TextField getUsername;
    public Button btnStart;
    public Label compCard1;
    public Label compCard2;
    public Label userCard1;
    public Label userCard2;
    public ListView<Player> playerList = new ListView<>();
    public TextField playerName;
    public Label txtResults;
    public ArrayList<Card> computersHand = new ArrayList<>();
    public ArrayList<Card> usersHand = new ArrayList<>();
    public Deck deck = new Deck();
    public int computersHandTotal = 0;
    public int usersHandTotal = 0;
    public Label compCard3;
    public Label userCard3;
    public Label compCard4;
    public Label userCard4;
    public Label compCard5;
    public Label userCard5;
    public Label compCard6;
    public Label userCard6;
    public int lastComputerCardIndex;
    public int lastUserCardIndex;

    public void startGame(MouseEvent mouseEvent) {

        //randomly generates computer/dealer's first two cards
        computersHand.add(0, deck.getRandom());
        compCard1.setText(computersHand.get(0).face);
        computersHand.add(1, deck.getRandom());
        compCard2.setText(computersHand.get(1).face);

        //randomly generates user's first two cards
        usersHand.add(0, deck.getRandom());
        userCard1.setText(usersHand.get(0).face);
        usersHand.add(1, deck.getRandom());
        userCard2.setText(usersHand.get(1).face);

        //add values of each hand
        computersHandTotal = deck.addCards(computersHand);
        usersHandTotal = deck.addCards(usersHand);

        //whoever gets 21 first wins
        if ((computersHand.get(0).value + computersHand.get(1).value) == 21) {
            txtResults.setText("Computer got 21! You Lose!");
            compCard1.setVisible(true);
        } else if( computersHandTotal < 21 && usersHandTotal == 21) {
            txtResults.setText("Blackjack! You Win!");
            compCard1.setVisible(true);
        }
    }



    public void enterUsername(MouseEvent mouseEvent) throws IOException {
        String username = getUsername.getText();
        Player player = new Player(username);
        playerList.getItems().add(player);

        //data persistence
        ObservableList<Player> myList = playerList.getItems();
        for (Player p : myList){
            p.writeToFile(getUsername.getText());
        }
        getUsername.clear();
    }

    public void deletePlayer(ActionEvent mouseEvent) {
        //removes selected player
        Player player;
        player = playerList.getSelectionModel().getSelectedItem();
        playerList.getItems().remove(player);
    }

    public void searchPlayer(MouseEvent mouseEvent) throws IOException {
        //search for player in txt files
        playerList.getItems().clear();
        ArrayList<Player> players = PlayerList.createPlayers(playerName.getText());
        for(Player p : players){
            playerList.getItems().add(p);
        }
        playerName.clear();

    }

    public void clearScoreboard(ActionEvent actionEvent) {
        //clear all players
        playerList.getItems().clear();
    }

    public void btnHit(ActionEvent actionEvent) {
        //check number of cards
        lastUserCardIndex = usersHand.size()-1;
        lastComputerCardIndex = computersHand.size()-1;
        int nextIndex;

        if (lastUserCardIndex == 5){
            //no more turns
            txtResults.setText("Out of hits. Better luck next time!");
            compCard1.setVisible(true);
        }else{

        //computers hand
        if (computersHandTotal < 16) {


            //add a card to computers hand
            nextIndex = lastComputerCardIndex+1;
            computersHand.add(nextIndex, deck.getRandom());
            //System.out.println(nextIndex);
            if (nextIndex == 2) {
                compCard3.setText(computersHand.get(lastUserCardIndex+1).face);
            } else if (nextIndex == 3) {
                compCard4.setText(computersHand.get(nextIndex).face);
            } else if (nextIndex == 4) {
                compCard5.setText(computersHand.get(nextIndex).face);
            } else if (nextIndex == 5) {
                compCard6.setText(computersHand.get(nextIndex).face);
            }
            computersHandTotal += computersHand.get(nextIndex).value;
        }

            //add a card to users hand
            nextIndex = lastUserCardIndex+1;
            usersHand.add(nextIndex, deck.getRandom());
            //System.out.println(nextIndex);
            if (nextIndex == 2) {
                userCard3.setText(usersHand.get(nextIndex).face);
            }else if (nextIndex == 3) {
                userCard4.setText(usersHand.get(nextIndex).face);
            }else if (nextIndex == 4) {
                userCard5.setText(usersHand.get(nextIndex).face);
            }else if (nextIndex == 5) {
                userCard6.setText(usersHand.get(nextIndex).face);
            }
            //add total
            usersHandTotal += usersHand.get(nextIndex).value;

        //compare Computers Hand with Users Hand
            if (computersHandTotal == 21) {
                txtResults.setText("Computer got 21! You Lose!");
                compCard1.setVisible(true);
            }else if ((computersHandTotal < 21 && usersHandTotal == 21)) {
                txtResults.setText("Blackjack! You win!");
                compCard1.setVisible(true);
            } else if (computersHandTotal > 21 ){
                txtResults.setText("Computer busted. You win!");
                compCard1.setVisible(true);
            } else if (usersHandTotal > 21 && computersHandTotal < 21){
                txtResults.setText("You busted. You lose!");
                compCard1.setVisible(true);
            }
        }
    }

    public void btnStand(ActionEvent actionEvent) {
        //check number of cards
        lastComputerCardIndex = computersHand.size()-1;
        int nextIndex;

        //computers hand
        if (computersHandTotal < 16) {

            //add a card to computers hand
            nextIndex = lastComputerCardIndex+1;
            computersHand.add(nextIndex, deck.getRandom());
            if (nextIndex == 2) {
                compCard3.setText(computersHand.get(lastUserCardIndex+1).face);
            } else if (nextIndex == 3) {
                compCard4.setText(computersHand.get(nextIndex).face);
            } else if (nextIndex == 4) {
                compCard5.setText(computersHand.get(nextIndex).face);
            } else if (nextIndex == 5) {
                compCard6.setText(computersHand.get(nextIndex).face);
            }
            computersHandTotal += computersHand.get(nextIndex).value;


        }
        //compare Computers Hand with Users Hand
        if (computersHandTotal == 21) {
            txtResults.setText("Computer got 21! You Lose!");
            compCard1.setVisible(true);
        }else if ((computersHandTotal < 21 && usersHandTotal == 21)) {
            txtResults.setText("Blackjack! You win!");
            compCard1.setVisible(true);
        } else if (computersHandTotal > 21 ){
            txtResults.setText("Computer busted. You win!");
            compCard1.setVisible(true);
        } else if (usersHandTotal > 21 && computersHandTotal < 21){
            txtResults.setText("You busted. You lose!");
            compCard1.setVisible(true);
        } else if (usersHandTotal < 21 && computersHandTotal < 21) {
                if (computersHandTotal >= usersHandTotal){
                    txtResults.setText("Computer's hand is closer to 21. You Lose!");
                }
                else{
                    txtResults.setText("Your hand is closer to 21. You Win!");
                }
            compCard1.setVisible(true);
        }
    }

    public void playAgain(ActionEvent actionEvent) {
        //clear everything to play again
        compCard1.setText("");
        compCard2.setText("");
        compCard3.setText("");
        compCard4.setText("");
        compCard5.setText("");
        compCard6.setText("");
        userCard1.setText("");
        userCard2.setText("");
        userCard3.setText("");
        userCard4.setText("");
        userCard5.setText("");
        userCard6.setText("");
        txtResults.setText("");
        computersHand.clear();
        usersHand.clear();
    }
}