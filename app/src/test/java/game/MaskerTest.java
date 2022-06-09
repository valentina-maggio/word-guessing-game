package game;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaskerTest {
  @Test
  public void testGetsWordToGuessMakers() {
    WordChoser mockedWordChoser = mock(WordChoser.class);
    when(mockedWordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Masker masker = new Masker(mockedWordChoser);

    assertEquals("M_____", masker.getWordToGuess());
  }
}
