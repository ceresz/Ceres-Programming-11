import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Welcome to a game of rock, paper, scissors.
        User enters their move by typing 'R' for rock, 'P' for paper, or 'S' for scissors.
        Computer randomly generates a number between 1 and 3 to determine their move:
        1 is rock, 2 is paper and 3 is scissors.
        The results are then compared to determine the winner.
         */

        game();
        //run game
    }

    public static void game() {

        //Scans for user input
        Scanner scan = new Scanner(System.in);
        //Game begins
        System.out.println("Welcome to a game of Rock, Paper, Scissors!");
        System.out.println("To make your move, enter 'R' for rock, 'P' for paper, or 'S' for scissors.");

        //Computer generate random number from 1 to 3 to determine their move.
        int min = 1;
        int max = 3;
        int random = (int) Math.floor(Math.random() * (max - min + 1) + min);

        //User input is taken and compared to the computer's outcome to determine the winner.
        //Goes through if statements until reaching the situation of both outcomes.
        //Output reads out the computer's and user's moves and states the winner.
        String move = scan.next();
        if (Objects.equals(move, "R")) {
            String userSelect = "Rock";
            if (random == 1) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Rock.");
                System.out.println("You Tied!");
            }
            if (random == 2) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Paper.");
                System.out.println("You Lost!");
            }
            if (random == 3) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Scissors.");
                System.out.println("You Win!");
            }
        }
        else if (Objects.equals(move, "P")) {
            String userSelect = "Paper";
            if (random == 1) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Rock.");
                System.out.println("You Win!");
            }
            if (random == 2) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Paper.");
                System.out.println("You Tied!");
            }
            if (random == 3) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Scissors.");
                System.out.println("You Lose!");
            }
        }
        else if (Objects.equals(move, "S")) {
            String userSelect = "Scissors";
            if (random == 1) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Rock.");
                System.out.println("You Lose!");
            }
            if (random == 2) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Paper.");
                System.out.println("You Win!");
            }
            if (random == 3) {
                System.out.println("Player choice: " + userSelect + ". Computer choice: Scissors.");
                System.out.println("You Tied!");
            }
        }
        //Else statement deals with incorrect letter and numbers.
        else {
            System.out.println("Invalid move. Please enter the letter R, P, or S to play.");
        }

    }
}