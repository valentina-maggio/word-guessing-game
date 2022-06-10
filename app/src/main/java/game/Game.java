package game;

import java.util.ArrayList;

public class Game {
  public String word;
  private Integer remainingAttempts = 10;
  public WordChoser wordChoser;
  private Masker masker;
  public ArrayList<Character> guessedLetters = new ArrayList<Character>();

  public Game(WordChoser wordChoser, Masker masker) {
    this.word = wordChoser.getRandomWordFromDictionary();
    this.masker = masker;
  }

  // public String getWordToGuess() {
  // StringBuilder sb = new StringBuilder();

  // for (int i = 0; i < word.length(); i++) {
  // Character letter = word.charAt(i);
  // if (i == 0) {
  // sb.append(letter);
  // } else {
  // if (guessedLetters.indexOf(letter) != -1) {
  // sb.append(letter);
  // } else {
  // sb.append("_");
  // }
  // }
  // }

  // return sb.toString();
  // }

  public String getWordToGuess() {
    return this.masker.getInitialMaskedWord(this.word);
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
