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

    assertEquals("M_____", game.getWordToGuess());
  }

  @Test
  public void testGetsWordToGuessCandies() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("CANDIES");

    Game game = new Game(mockedWordChoser);

    assertEquals("C______", game.getWordToGuess());
  }

  @Test
  public void testGetsInitialRemainingAttempts() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

    Game game = new Game(mockedWordChoser);

    assertEquals(Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test
  public void testGuessWrongLetter() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

    Game game = new Game(mockedWordChoser);

    assertEquals(false, game.guessLetter('I'));
  }

  @Test
  public void testGuessRightLetter() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

    Game game = new Game(mockedWordChoser);

    assertEquals(true, game.guessLetter('N'));
  }

  @Test
  public void testGuessRightLetterAndDisplayIt() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedWordChoser);

    assertEquals("D________", game.getWordToGuess());
    assertEquals(true, game.guessLetter('E'));
    assertEquals("DE_E___E_", game.getWordToGuess());
  }

  @Test
  public void testTheGameIsLost() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("CANDIES");

    Game game = new Game(mockedWordChoser);
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');
    game.guessLetter('F');

    assertEquals(true, game.isGameLost());
  }

  @Test
  public void testTheGameIsWon() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("CANDIES");

    Game game = new Game(mockedWordChoser);
    game.guessLetter('K');
    game.guessLetter('A');
    game.guessLetter('N');
    game.guessLetter('G');
    game.guessLetter('S');
    game.guessLetter('I');
    game.guessLetter('E');
    game.guessLetter('D');
    System.out.println(game.getLetters());
    System.out.println(game.getWordToGuess());

    assertEquals(true, game.isGameWon());
  }

  @Test
  public void testTheGameIsWonWordWithSameOccurrences() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedWordChoser);
    game.guessLetter('K');
    game.guessLetter('E');
    game.guessLetter('N');
    game.guessLetter('V');
    game.guessLetter('R');
    game.guessLetter('O');
    game.guessLetter('L');
    game.guessLetter('P');
    System.out.println(game.getLetters());
    System.out.println(game.getWordToGuess());

    assertEquals(true, game.isGameWon());
  }
}
