package com.example.guilesson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class HelloController {
    public Label lblpoints;
    public Label lbldice1;
    public Label lbldice2;
    public Game myGame = new Game();
    public Label lblresults;
    public Button btnhigher;
    public Button btnlower;
    public Button btnplayAgain;
    public Button btnroll1;


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void displayDice1(MouseEvent mouseEvent) {
        int min = 1;
        int max = 5;
        Random random = new Random();
        int value = random.nextInt(max + min) + min;
        lbldice1.setText(Integer.toString(value));
        myGame.setDice1(value);

        btnhigher.setDisable(false);
        btnlower.setDisable(false);
        btnplayAgain.setDisable(false);

    }

    public void displayDice2(MouseEvent mouseEvent) {
        int min = 1;
        int max = 5;
        Random random = new Random();
        int value = random.nextInt(max + min) + min;
        lbldice2.setText(Integer.toString(value));
        myGame.setDice2(value);
    }

    public void displayPoints(MouseEvent mouseEvent) {
    }

    public void betHigher(MouseEvent mouseEvent) {
        btnlower.setDisable(true);
        btnhigher.setDisable(true);
        btnroll1.setDisable(true);
        if (myGame.getPoints() >= 100 && myGame.getDice1() > 0) {
            int min = 1;
            int max = 5;
            Random random = new Random();
            int value = random.nextInt(max + min) + min;
            lbldice2.setText(Integer.toString(value));
            myGame.setDice2(value);
            if (myGame.getDice2() > myGame.getDice1()) {
                lblresults.setText("You Win!");
                myGame.setWinPoints();
                lblpoints.setText(Integer.toString(myGame.getPoints()));
            } else {
                lblresults.setText("You Lose!");
                myGame.setLosePoints();
                lblpoints.setText(Integer.toString(myGame.getPoints()));
            }
        }
        else {
            if (myGame.getPoints() < 100) {
                lblresults.setText("No points left to bet!!!");
            }
            else {
                lblresults.setText("Please roll dice #1 first");
            }
        }
    }

    public void betLower(MouseEvent mouseEvent) {
        btnlower.setDisable(true);
        btnhigher.setDisable(true);
        btnroll1.setDisable(true);
        if (myGame.getPoints() >= 100 && myGame.getDice1() > 0) {
            int min = 1;
            int max = 5;
            Random random = new Random();
            int value = random.nextInt(max + min) + min;
            lbldice2.setText(Integer.toString(value));
            myGame.setDice2(value);
            if (myGame.getDice2() < myGame.getDice1()) {
                lblresults.setText("You Win!");
                myGame.setWinPoints();
                lblpoints.setText(Integer.toString(myGame.getPoints()));
            } else {
                lblresults.setText("You Lose!");
                myGame.setLosePoints();
                lblpoints.setText(Integer.toString(myGame.getPoints()));
            }
        }
        else {
            if (myGame.getPoints() < 100) {
                lblresults.setText("No points left to bet!!!");
            }
            else {
                lblresults.setText("Please roll dice #1 first");
            }
        }
    }

    public void playAgain(MouseEvent mouseEvent) {
        lbldice1.setText(" ");
        lbldice2.setText(" ");
        lblresults.setText(" ");

        btnroll1.setDisable(false);
        btnhigher.setDisable(true);
        btnlower.setDisable(true);
        btnplayAgain.setDisable(true);
    }

    public void btnplayAgain(ActionEvent actionEvent) {
    }
}


