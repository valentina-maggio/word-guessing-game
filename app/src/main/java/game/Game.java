package game;

import java.util.Random;

public class Game {
  private String word;
  private Integer remainingAttempts = 10;

  private static final String[] DICTIONARY = { "MAKERS", "CANDIES", "DEVELOPER", "LONDON" };

  public Game(String string) {
    word = string;
  }

  public String getWordToGuess() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
      if (i == 0) {
        Character letter = word.charAt(0);
        sb.append(letter);
      } else {
        sb.append("_");
      }
    }

    return sb.toString();
  }

  public Integer getRemainingAttempts() {
    return remainingAttempts;
  }

  public String getRandomWordFromDictionary() {
    Random rand = new Random();
    int randomNumber = rand.nextInt(DICTIONARY.length);
    return DICTIONARY[randomNumber];
  }
}
