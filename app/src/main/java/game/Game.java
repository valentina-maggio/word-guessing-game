package game;

import java.util.ArrayList;

public class Game {
  private String word;
  private Integer remainingAttempts = 10;
  private WordChoser wordChoser;
  private Masker masker;
  private ArrayList<Character> guessedLetters = new ArrayList<Character>();

  public Game(WordChoser wordChoser, Masker masker) {
    this.word = wordChoser.getRandomWordFromDictionary();
    this.masker = masker;
  }

  public String getWordToGuess() {
    return this.masker.getMaskedWord(this.word, guessedLetters);
  }

  public Integer getRemainingAttempts() {
    return this.remainingAttempts;
  }

  public String guessLetter(Character letter) {
    String wordToCheck = this.word.substring(1);
    if (wordToCheck.indexOf(letter) == -1) {
      this.remainingAttempts -= 1;
      return "wrong";
    } else if (wordToCheck.indexOf(letter) != -1 && guessedLetters.contains(letter)) {
      return "repeated";
    } else {
      this.guessedLetters.add(letter);
      return "correct";
    }
  }

  public ArrayList<Character> getLetters() {
    return this.guessedLetters;
  }

  public Boolean isGameLost() {
    return getRemainingAttempts() <= 0 && this.guessedLetters.size() != getWordToGuess().length() - 1;
  }

  public Boolean isGameWon() {
    for (int i = 1; i < this.word.length(); i++) {
      Character letter = this.word.charAt(i);
      if (this.guessedLetters.indexOf(letter) == -1) {
        return false;
      }
    }

    return true;
  }
}
