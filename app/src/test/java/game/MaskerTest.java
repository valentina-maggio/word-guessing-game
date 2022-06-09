package game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;

public class MaskerTest {
  @Test
  public void testGetsWordToGuessMakers() {
    Masker masker = new Masker();
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('E');
    guessedLetters.add('R');

    assertEquals("M__ER_", masker.getMaskedWord("MAKERS", guessedLetters));
  }
}
