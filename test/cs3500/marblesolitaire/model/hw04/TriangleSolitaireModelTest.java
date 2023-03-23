package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Triangle Solitaire Model.
 */
public class TriangleSolitaireModelTest {

  /**
   * Tests constrictor exceptions for triangle model.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalMethod() {
    MarbleSolitaireModel m1 = new TriangleSolitaireModel(0);
    MarbleSolitaireModel m2 = new TriangleSolitaireModel(1);
  }

  /**
   * Tests move method for the Triangle model.
   */
  @Test
  public void move() {
    MarbleSolitaireModel m1 = new TriangleSolitaireModel(5, 4,4);
    MarbleSolitaireView mv1 = new TriangleSolitaireTextView(m1);
    m1.move(4,2,4,4);
    assertEquals("    O\n"
            + "   O O\n"
            + "  O O O\n"
            + " O O O O\n"
            + "O O _ _ O", mv1.toString());
  }

  /**
   * Tests for constructor exceptions for triangle.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveIllegal() {
    MarbleSolitaireModel m1 = new TriangleSolitaireModel(3);
    MarbleSolitaireView mv1 = new TriangleSolitaireTextView(m1);
    m1.move(2,1,2,2);
    m1.move(0, 0, 0, 0);
    m1.move(1, 1, 0, 0);
  }

  /**
   * Tests game over for triangle.
   */
  @Test
  public void testGameOver() {
    MarbleSolitaireModel m1 = new TriangleSolitaireModel(3);
    MarbleSolitaireView mv1 = new TriangleSolitaireTextView(m1);

    m1.move(2,2,0,0);
    m1.move(2,0,2,2);
    m1.move(0,0,2,0);

    assertEquals(true, m1.isGameOver());
  }

  /**
   * Tests get score method for triangle.
   */
  @Test
  public void testGetScore() {
    MarbleSolitaireModel m1 = new TriangleSolitaireModel(5);
    MarbleSolitaireView mv1 = new TriangleSolitaireTextView(m1);
    assertEquals(14, m1.getScore());

    m1.move(2,2,0,0);
    assertEquals(13, m1.getScore());
  }

  /**
   * Tests board size method for triangle.
   */
  @Test
  public void testGetBoardSize() {
    MarbleSolitaireModel m1 = new TriangleSolitaireModel(7);
    assertEquals(7, m1.getBoardSize());
  }
}