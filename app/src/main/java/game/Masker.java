package game;

import java.util.ArrayList;

public class Masker {
  private String word;
  private WordChoser wordChoser = new WordChoser();
  private ArrayList<Character> guessedLetters = new ArrayList<>();

  public Masker(WordChoser wordChoser) {
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
}
