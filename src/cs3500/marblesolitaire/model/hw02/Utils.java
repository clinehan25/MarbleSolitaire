package cs3500.marblesolitaire.model.hw02;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;


/**
 * This class represents an Utils class for Marble Solitaire
 * model. This class is used to handle functionality that does not pertain
 * the model itself.
 */

public class Utils {

  /**
   * Checks if the given row and column are valid in a board of the given arm thickness.
   *
   * @param slot  the enum that represents the state of a cell
   *
   * @return the String representation of the enum
   */

  public static String slotToString(MarbleSolitaireModelState.SlotState slot) {
    String toReturn = "";

    switch (slot) {
      case Invalid:
        toReturn = " ";
        break;
      case Marble:
        toReturn = "O";
        break;
      case Empty:
        toReturn = "_";
        break;
      default:
        throw new IllegalArgumentException("Not a valid state");
    }

    return toReturn;
  }

  /**
   * Checks if the given row and column are valid in a board of the given arm thickness.
   *
   * @param a  an appendable object
   * @param s  a String to append to the appendable object
   *
   */

  public static void write(Appendable a, String s) {
    try {
      a.append(s);
    } catch (IOException e) {
      throw new IllegalStateException("Something went wrong while constructing the String output");
    }
  }

}
