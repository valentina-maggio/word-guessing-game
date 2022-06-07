package game;

public class Game {
  private String word;
  private Integer remainingAttempts = 10;

  public Game(String string) {
    word = string;
  }

  public String getWordToGuess() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.word.length(); i++) {
      if (i == 0) {
        Character letter = this.word.charAt(0);
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
}
