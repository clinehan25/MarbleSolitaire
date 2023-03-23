package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;

/**
 * Testing methods for the EnglishSolitaireModel class.
 */
public class EnglishSolitaireModelTest {

  /**
   * Testing for the move method (down, up, right, then left).
   */
  @Test
  public void moveTest() {
    MarbleSolitaireModel m1 = new EnglishSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(6, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(6, 8));
    m1.move(6, 8, 6, 6);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(6, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(6, 8));


    MarbleSolitaireModel m2 = new EnglishSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(6, 4));
    m2.move(6, 4, 6, 6);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m2.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(6, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m2.getSlotAt(6, 4));


    MarbleSolitaireModel m3 = new EnglishSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m3.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m3.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m3.getSlotAt(4, 6));
    m3.move(4, 6, 6, 6);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m3.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m3.getSlotAt(5, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m3.getSlotAt(4, 6));


    MarbleSolitaireModel m4 = new EnglishSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m4.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m4.getSlotAt(7, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m4.getSlotAt(8, 6));
    m4.move(8, 6, 6, 6);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m4.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m4.getSlotAt(7, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m4.getSlotAt(8, 6));
  }

  /**
   * Tests for isGameOver method.
   */
  @Test
  public void testIsGameOver() {
    MarbleSolitaireModel m1 = new EnglishSolitaireModel(3);
    assertEquals(false, m1.isGameOver());
  }

  /**
   * Tests the getBoardSize method.
   */
  @Test
  public void testGetBoardSize() {
    MarbleSolitaireModel m1 = new EnglishSolitaireModel(3);
    assertEquals(7, m1.getBoardSize());
    MarbleSolitaireModel m2 = new EnglishSolitaireModel(11);
    assertEquals(31, m2.getBoardSize());
  }

  /**
   * Tests the getSlotAt method.
   */
  @Test
  public void testGetSlotAt() {
    MarbleSolitaireModel m1 = new EnglishSolitaireModel(3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, m1.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, m1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, m1.getSlotAt(4,3));
  }

  /**
   * Tests the getScore method.
   */
  @Test
  public void testGetScore() {
    MarbleSolitaireModel m1 = new EnglishSolitaireModel(5);
    assertEquals(104, m1.getScore());
    MarbleSolitaireModel m2 = new EnglishSolitaireModel(3);
    assertEquals(32, m2.getScore());
  }
}