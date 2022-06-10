package game;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Test;

public class GameTest {
  @Test
  public void testGetsInitialRemainingAttempts() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");
    Masker mockedMasker = mock(Masker.class);

    Game game = new Game(mockedWordChoser, mockedMasker);

    assertEquals(Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test
  public void testDisplaysMaskedWordToGuess() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Masker mockedMasker = mock(Masker.class);
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    when(mockedMasker.getMaskedWord("MAKERS", guessedLetters)).thenReturn("M_____");

    Game game = new Game(mockedWordChoser, mockedMasker);
    assertEquals("M_____", game.getWordToGuess());
  }

  @Test
  public void testGuessWrongLetter() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");
    Masker mockedMasker = mock(Masker.class);

    Game game = new Game(mockedWordChoser, mockedMasker);

    assertEquals(false, game.guessLetter('I'));
  }

  @Test
  public void testGuessRightLetter() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");
    Masker mockedMasker = mock(Masker.class);

    Game game = new Game(mockedWordChoser, mockedMasker);

    assertEquals(true, game.guessLetter('N'));
  }

  @Test
  public void testGuessRightLetterAndDisplayIt() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");
    Masker mockedMasker = mock(Masker.class);
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    when(mockedMasker.getMaskedWord("DEVELOPER", guessedLetters)).thenReturn("DE_E___E_");

    Game game = new Game(mockedWordChoser, mockedMasker);

    assertEquals("DE_E___E_", game.getWordToGuess());
  }

  @Test
  public void testTheGameIsLost() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("CANDIES");
    Masker mockedMasker = mock(Masker.class);
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    when(mockedMasker.getMaskedWord("CANDIES", guessedLetters)).thenReturn("C______");

    Game game = new Game(mockedWordChoser, mockedMasker);
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
    Masker mockedMasker = mock(Masker.class);

    Game game = new Game(mockedWordChoser, mockedMasker);
    game.guessLetter('K');
    game.guessLetter('A');
    game.guessLetter('N');
    game.guessLetter('G');
    game.guessLetter('S');
    game.guessLetter('I');
    game.guessLetter('E');
    game.guessLetter('D');

    assertEquals(true, game.isGameWon());
  }

  @Test
  public void testTheGameIsWonWordWithSameOccurrences() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");
    Masker mockedMasker = mock(Masker.class);

    Game game = new Game(mockedWordChoser, mockedMasker);
    game.guessLetter('K');
    game.guessLetter('E');
    game.guessLetter('N');
    game.guessLetter('V');
    game.guessLetter('R');
    game.guessLetter('O');
    game.guessLetter('L');
    game.guessLetter('P');

    assertEquals(true, game.isGameWon());
  }

  @Test
  public void testGuessWrongWhenOnlyOneOccurenceOfFirstLetter() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");
    Masker mockedMasker = mock(Masker.class);

    Game game = new Game(mockedWordChoser, mockedMasker);

    assertEquals(false, game.guessLetter('D'));
  }
}
