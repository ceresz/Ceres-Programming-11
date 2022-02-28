import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        int i = word.length();

        String LastLetter = word.substring(i-1, i);
        String str = word.substring(0,i-1) + "ay";

        System.out.println("encrypted: " + LastLetter + str);
        System.out.println("translated: " + word);

    }
}

