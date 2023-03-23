package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Test classes for the Marble Solitaire Controller tests.
 */
public class MarbleSolitaireControllerImplTest {
  MarbleSolitaireModel m1 = new EnglishSolitaireModel();
  Appendable a1 = new StringBuilder();
  MarbleSolitaireView mv1 = new MarbleSolitaireTextView(m1, a1);

  /**
   * Test for the playGame method when quitting.
   */
  @Test
  public void testPlayGameQuit() {
    Readable r1 = new StringReader("q Q 5 2");

    String ret = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n";

    MarbleSolitaireController game = new MarbleSolitaireControllerImpl(m1, mv1, r1);
    game.playGame();
    assertEquals(ret, a1.toString());
  }

  /**
   * Test for the playGame method when winning.
   */
  @Test
  public void testPlayGameWin() {
    Readable r1 = new StringReader("6 4 4 4 5 6 5 4 5 3 5 5 3 4 5 4 5 5 5 3 3 6 3 4 2 4 4 4 3"
            + " 2 3 4 1 3 3 3 1 5 1 3 4 4 2 4 2 5 2 3 7 5 5 5 5 2 5 4 5 5 5"
            + " 3 4 2 4 4 4 5 4 3 4 7 4 5 7 3 7 5 5 3 7 3 3 3 5 3 1 3 3 3");
    MarbleSolitaireController game = new MarbleSolitaireControllerImpl(m1, mv1, r1);
    game.playGame();
    assertEquals(true, a1.toString().contains("Score: 1"));
  }

  /**
   * Test for the playGame method when winning.
   */
  @Test
  public void testPlayGameMove() {
    String ret = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "    O _ O\n"
            + "    O O O\n"
            + "Score: 31\n";

    Readable r1 = new StringReader("6 4 4 4");
    MarbleSolitaireController game = new MarbleSolitaireControllerImpl(m1, mv1, r1);
    game.playGame();
    assertEquals(ret, a1.toString());
  }
}