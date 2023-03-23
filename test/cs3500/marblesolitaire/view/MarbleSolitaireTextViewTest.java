package cs3500.marblesolitaire.view;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the MarbleSolitaireText class and its methods.
 */
public class MarbleSolitaireTextViewTest {

  /**
   * Tests the toString method for english model.
   */
  @Test
  public void testToStringEnglish() {
    MarbleSolitaireModelState m1 = new EnglishSolitaireModel(3);
    MarbleSolitaireView mv1 = new MarbleSolitaireTextView(m1);

    String board3 =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O _ O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O";

    assertEquals(board3, mv1.toString());

    MarbleSolitaireView mv2 = new MarbleSolitaireTextView(new EnglishSolitaireModel(9));
    String board9 = "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O _ O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O\n"
            + "                O O O O O O O O O";

    assertEquals(board9, mv2.toString());
  }

  /**
   * Tests the toString method for European model.
   */
  @Test
  public void testToStringEuropean() {
    MarbleSolitaireModelState m1 = new EuropeanSolitaireModel(3);
    MarbleSolitaireView mv1 = new MarbleSolitaireTextView(m1);
    String board3 = "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";

    assertEquals(board3, mv1.toString());

    MarbleSolitaireModelState m2 = new EuropeanSolitaireModel(5, 6, 7);
    MarbleSolitaireView mv2 = new MarbleSolitaireTextView(m2);
    String board5 = "        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O _ O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O";

    assertEquals(board5, mv2.toString());
  }
}