package cs3500.marblesolitaire.view;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests the methods for the Triangle Solitaire.
 */
public class TriangleSolitaireTextViewTest {

  /**
   * Tests toString for the Triangle model.
   */
  @Test
  public void testToString() {
    MarbleSolitaireModel m1 = new TriangleSolitaireModel(5);
    MarbleSolitaireView mv1 = new TriangleSolitaireTextView(m1);
    String board3 = "    _\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O O O O";
    assertEquals(board3, mv1.toString());

    MarbleSolitaireModel m2 = new TriangleSolitaireModel(7,4,3);
    MarbleSolitaireView mv2 = new TriangleSolitaireTextView(m2);
    assertEquals("      O\n"
            + "     O O\n"
            + "    O O O\n"
            + "   O O O O\n"
            + "  O O O _ O\n"
            + " O O O O O O\n"
            + "O O O O O O O", mv2.toString());
  }
}