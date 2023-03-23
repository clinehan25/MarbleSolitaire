package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw02.Utils;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Utils class and its methods.
 */
public class UtilsTest {

  @Test
  public void slotToStringTest() {
    assertEquals(" ", new Utils().slotToString(MarbleSolitaireModelState.SlotState.Invalid));
    assertEquals("O", new Utils().slotToString(MarbleSolitaireModelState.SlotState.Marble));
    assertEquals("_", new Utils().slotToString(MarbleSolitaireModelState.SlotState.Empty));
  }

  @Test
  public void writeTest() {
    Appendable appendableExample = new StringBuilder();


    assertEquals("", appendableExample.toString());
    Utils.write(appendableExample, "hello");
    assertEquals("hello", appendableExample.toString());
    Utils.write(appendableExample, " world!");
    assertEquals("hello world!", appendableExample.toString());

  }

}