package game;

import java.util.ArrayList;

public class Masker {

  public String getMaskedWord(String word, ArrayList<Character> guessedLetters) {
    StringBuilder maskedWord = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
      Character letter = word.charAt(i);
      if (i == 0) {
        maskedWord.append(letter);
      } else {
        if (guessedLetters.indexOf(letter) != -1) {
          maskedWord.append(letter);
        } else {
          maskedWord.append("_");
        }
      }
    }

    return maskedWord.toString();
  }
}
