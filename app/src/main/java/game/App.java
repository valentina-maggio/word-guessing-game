package game;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to hangman game!");
        System.out.println(" ");
        System.out.println("Enter name for player 1");
        String player1Name = scan.nextLine();
        System.out.println("Enter name for player 2");
        String player2Name = scan.nextLine();
        System.out.println(" ");

        WordChoser wordChoser = new WordChoser();
        Masker masker = new Masker();

        Game game1 = new Game(wordChoser, masker, player1Name);
        Game game2 = new Game(wordChoser, masker, player2Name);
        ArrayList<Game> players = new ArrayList<>(Arrays.asList(game1, game2));

        Random rand = new Random();
        int randomNumber = rand.nextInt(players.size());
        Game player1 = players.get(randomNumber);
        Game player2 = players.get(1 - randomNumber);

        System.out.println("The word to guess is:");
        System.out.println(player1.name + ": " + player1.getWordToGuess());
        System.out.println(player2.name + ": " + player2.getWordToGuess());
        System.out.println(" ");

        do {

            int counter = 1;

            if (counter % 2 != 0) {
                System.out.println(player1.name + ": Guess a letter! " + "(" + player1.getRemainingAttempts()
                        + " attempts remaining)");

                Character input1 = scan.nextLine().charAt(0);
                String result1 = player1.guessLetter(input1);

                if (result1 == "correct") {
                    if (player1.isGameWon()) {
                        System.out.println("Right! " + player1.name + " won!");
                        System.out.println(player1.getWordToGuess());
                        break;
                    } else {
                        System.out.println("Right!");
                        System.out.println(player1.getWordToGuess());
                        counter++;
                    }
                } else if (result1 == "repeated") {
                    System.out.println("You have already guessed this letter. Pick another one!");
                } else {
                    if (player1.isGameLost()) {
                        System.out.println("Wrong! " + player2.name + " won!");
                        break;
                    } else {
                        System.out.println("Wrong!");
                        System.out.println(player1.getWordToGuess());
                        counter++;
                    }
                }
            }

            if (counter % 2 == 0) {
                System.out.println(player2.name + ": Guess a letter! " + "(" + player2.getRemainingAttempts()
                        + " attempts remaining)");

                Character input2 = scan.nextLine().charAt(0);
                String result2 = player2.guessLetter(input2);

                if (result2 == "correct") {
                    if (player2.isGameWon()) {
                        System.out.println("Right! " + player2.name + " won!");
                        System.out.println(player2.getWordToGuess());
                        break;
                    } else {
                        System.out.println("Right!");
                        System.out.println(player2.getWordToGuess());
                        counter++;
                    }
                } else if (result2 == "repeated") {
                    System.out.println("You have already guessed this letter. Pick another one!");
                } else {
                    if (player2.isGameLost()) {
                        System.out.println("Wrong! " + player2.name + " won!");
                        break;
                    } else {
                        System.out.println("Wrong!");
                        System.out.println(player2.getWordToGuess());
                        counter++;
                    }
                }
            }
        } while ((player1.getWordToGuess().contains("_") && player1.getRemainingAttempts() > 0)
                || (player2.getWordToGuess().contains("_") && player2.getRemainingAttempts() > 0));
    }
}
