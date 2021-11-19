package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class GameTest {
  @Test public void testGetsWordToGuess() {
    WordChoser mockedChoser = mock(WordChoser.class);
    Game game = new Game(mockedChoser);
    assertTrue(game.getWordToGuess() instanceof String);
  }
  @Test public void initialGetRemainingAttemps(){
    WordChoser mockedChoser = mock(WordChoser.class);
    Game game = new Game(mockedChoser);
    assertEquals(10, game.getRemainingAttemps());
  }
  @Test public void getRandomWordFromDictionay(){
    // We could check we get a string back?
  }
  @Test public void testWordChoser(){
    WordChoser choser = new WordChoser();
    assertTrue(choser.getRandomWordFromDictionary() instanceof String);
  }
  @Test public void testGetsWordToGuessWithRandomWord() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);

    assertEquals(game.getWordToGuess(), "D________");
  }
  @Test public void testGuessLetterTrue() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    
    Game game = new Game(mockedChoser);

    assertTrue(game.guessLetter('K'));
  }
  @Test public void testGuessLetterFalse() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    
    Game game = new Game(mockedChoser);

    assertFalse(game.guessLetter('O'));
    assertEquals(game.getRemainingAttemps(), 9);
  }
  @Test public void testGuessLetterRightAndDisplayGuessedLetter() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);

    assertTrue(game.guessLetter('L'));
    assertEquals(game.getWordToGuess(), "D___L____");
  }

  @Test public void testGuessLetterWrong() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertEquals(game.guessLetter('A'), false);
    assertEquals(game.getWordToGuess(), "D________");
  }
}
