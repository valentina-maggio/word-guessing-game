package game;

import java.util.ArrayList;

public class Game {
  private String word;
  private Integer remainingAttempts = 10;
  private WordChoser wordChoser = new WordChoser();
  private ArrayList<Character> guessedLetters = new ArrayList<>();

  public Game(WordChoser wordChoser) {
    word = wordChoser.getRandomWordFromDictionary();
  }

  public String getWordToGuess() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
      Character letter = word.charAt(i);
      if (i == 0) {
        sb.append(letter);
      } else {
        if (guessedLetters.indexOf(letter) != -1) {
          sb.append(letter);
        } else {
          sb.append("_");
        }
      }
    }

    return sb.toString();
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
    return guessedLetters.size() == getWordToGuess().length() - 1;
  }
}
