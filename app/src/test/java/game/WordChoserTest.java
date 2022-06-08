package game;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordChoserTest {
  @Test
  public void testGetsRandomMakersWordToGuess() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    mockedWordChoser.getRandomWordFromDictionary();

    verify(mockedWordChoser).getRandomWordFromDictionary();

    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    System.out.println(mockedWordChoser.getRandomWordFromDictionary());
    assertEquals(mockedWordChoser.getRandomWordFromDictionary(), "MAKERS");
  }

  @Test
  public void testGetsRandomCandiesWordToGuess() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    mockedWordChoser.getRandomWordFromDictionary();

    verify(mockedWordChoser).getRandomWordFromDictionary();

    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("CANDIES");

    System.out.println(mockedWordChoser.getRandomWordFromDictionary());
    assertEquals(mockedWordChoser.getRandomWordFromDictionary(), "CANDIES");
  }

  @Test
  public void testGetsRandomDeveloperWordToGuess() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    mockedWordChoser.getRandomWordFromDictionary();

    verify(mockedWordChoser).getRandomWordFromDictionary();

    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    System.out.println(mockedWordChoser.getRandomWordFromDictionary());
    assertEquals(mockedWordChoser.getRandomWordFromDictionary(), "DEVELOPER");
  }

  @Test
  public void testGetsRandomLondonWordToGuess() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    mockedWordChoser.getRandomWordFromDictionary();

    verify(mockedWordChoser).getRandomWordFromDictionary();

    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("LONDON");

    System.out.println(mockedWordChoser.getRandomWordFromDictionary());
    assertEquals(mockedWordChoser.getRandomWordFromDictionary(), "LONDON");
  }
}
