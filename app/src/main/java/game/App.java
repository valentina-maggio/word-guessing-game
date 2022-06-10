/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package game;

import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        WordChoser choser = new WordChoser();
        Masker masker = new Masker();
        Game game = new Game(choser, masker);
        System.out.println("Welcome! The word to guess is:");
        System.out.println(game.getWordToGuess());

        do {
        System.out.println(game.getWordToGuess());
        System.out.println("Guess a letter! " + "(" + game.getRemainingAttempts() + "
        attempts remaining)");

        Scanner scan = new Scanner(System.in);
        Character input = scan.nextLine().charAt(0);
        Boolean result = game.guessLetter(input);

        if (result) {
        if (game.isGameWon()) {
        System.out.println("Right! You won!");
        System.out.println(game.getWordToGuess());
        } else {
        System.out.println("Right!");
        }

        } else {
        if (game.isGameLost()) {
        System.out.println("Wrong! You lost");
        } else {
        System.out.println("Wrong!");
        }
        }

        } while (game.getWordToGuess().contains("_") && game.getRemainingAttempts() >
        0);
    }
}
