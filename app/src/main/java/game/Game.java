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
    return remainingAttempts;
  }

  public Boolean guessLetter(Character letter) {
    if (word.indexOf(letter) == -1) {
      remainingAttempts -= 1;
      return false;
    } else {
      guessedLetters.add(letter);
      return true;
    }
  }

  public ArrayList<Character> getLetters() {
    return guessedLetters;
  }

  public Boolean isGameLost() {
    return getRemainingAttempts() <= 0 && guessedLetters.size() != getWordToGuess().length() - 1;
  }

  public Boolean isGameWon() {
    for (int i = 1; i < word.length(); i++) {
      Character letter = word.charAt(i);
      if (guessedLetters.indexOf(letter) == -1) {
        return false;
      }
    }

    return true;
  }
}
