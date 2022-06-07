package game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
  @Test
  public void testGetsWordToGuess() {
    Game game = new Game();

    assertEquals(game.getWordToGuess(), "B_____");
  }
}
