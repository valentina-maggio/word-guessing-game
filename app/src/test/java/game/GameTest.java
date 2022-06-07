package game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
  @Test
  public void testGetsWordToGuess() {
    Game game = new Game("MAKERS");

    assertEquals(game.getWordToGuess(), "M_____");
  }

  @Test
  public void testGetsSecondWordToGuess() {
    Game game = new Game("SUMMERTIME");

    assertEquals(game.getWordToGuess(), "S_________");
  }

  @Test
  public void testGetsInitialRemainingAttempts() {
    Game game = new Game("MAKERS");

    assertEquals(game.getAttempts(), Integer.valueOf(10));
  }
}
