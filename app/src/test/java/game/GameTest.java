package game;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
  @Test
  public void testGetsWordToGuessMakers() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(mockedWordChoser);

    assertEquals(game.getWordToGuess(), "M_____");
  }

  @Test
  public void testGetsWordToGuessCandies() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("CANDIES");

    Game game = new Game(mockedWordChoser);

    assertEquals(game.getWordToGuess(), "C______");
  }

  @Test
  public void testGetsInitialRemainingAttempts() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

    Game game = new Game(mockedWordChoser);

    assertEquals(game.getRemainingAttempts(), Integer.valueOf(10));
  }

  @Test
  public void testGuessWrongLetter() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

    Game game = new Game(mockedWordChoser);

    assertEquals(game.guessLetter('I'), false);
  }

  @Test
  public void testGuessRightLetter() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

    Game game = new Game(mockedWordChoser);

    assertEquals(game.guessLetter('N'), true);
  }
}
