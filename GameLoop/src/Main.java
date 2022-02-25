import java.util.Scanner;

public class Main {
    public static int userScore = 0;
    public static int compScore = 0;

    public static void main(String[] args) {

        /*
        Welcome to a game of rock, paper, scissors.
        User enters their move by typing 'R' for rock, 'P' for paper, or 'S' for scissors.
        Computer randomly generates a number between 1 and 3 to determine their move:
        1 is rock, 2 is paper and 3 is scissors.
        The results are then compared to determine the winner.
         */

        System.out.println("Welcome to a game of Rock, Paper, Scissors!");
        game();
        //run game
    }

    public static void game() {

        //Scans for user input
        Scanner scan = new Scanner(System.in);
        //Game begins

        //Code inserts stars to separate each game
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("Enter 'R' for rock, 'P' for paper, or 'S' for scissors. Enter 'X' to exit.");


        //Computer generate random number from 1 to 3 to determine their move.
        int min = 1;
        int max = 3;
        int random = (int) Math.floor(Math.random() * (max - min + 1) + min);

        //User input is taken and compared to the computer's outcome to determine the winner.
        //Goes through if statements until reaching the situation of both outcomes.
        //Output reads out the computer's and user's moves and states the winner.
        String move = scan.next();

        if (move.equals("R")) {
                String userSelect = "Rock";
                if (random == 1) {
                    System.out.println("You Tied!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Rock.");
                    score();

                }
                if (random == 2) {
                    System.out.println("You Lose!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Paper.");
                    compScore++;
                    score();

                }
                if (random == 3) {
                    System.out.println("You Win!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Scissors.");
                    userScore++;
                    score();

                }
            }
        else if (move.equals("P")) {
                String userSelect = "Paper";
                if (random == 1) {
                    System.out.println("You Win!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Rock.");
                    userScore++;
                    score();
                }
                if (random == 2) {
                    System.out.println("You Tied!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Paper.");
                    score();

                }
                if (random == 3) {
                    System.out.println("You Lose!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Scissors.");
                    compScore++;
                    score();

                }
            }
       else if (move.equals("S")) {
                String userSelect = "Scissors";
                if (random == 1) {
                    System.out.println("You Lose!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Rock.");
                    compScore++;
                    score();

                }
                if (random == 2) {
                    System.out.println("You Win!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Paper.");
                    userScore++;
                    score();
                }
                if (random == 3) {
                    System.out.println("You Tied!");
                    System.out.println("Player choice: " + userSelect + ". Computer choice: Scissors.");
                    score();

                }
            }
       //if user enters 'x' code enters a function to stop game.
       else if (move.equals("X")) {
           exit();
        }
            //Else statement deals with incorrect letter and numbers.
       else {
                System.out.println("Invalid move. Please enter the letter R, P, or S to play.");
                game();
            }
        }
        //Function keeps track of user's and computer's score.
        public static void score () {
            for (int i = 0; i < 50; i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.println("Your score: " + userScore);
            System.out.println("Computer score: " + compScore);
            game();
        }
        //When user wants to exit game, break statement causes loop to end.
        public static void exit () {
            for(int i = 0;;){
                if(i == 0) break;
            }
        }

}
