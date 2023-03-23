package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Class that implements the MarbleSolitaireView interface.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  public MarbleSolitaireModelState game;
  public Appendable output;

  /**
   * Constructor for the view for the MarbleSolitaireModel.
   *
   * @param game the MarbleSolitaireModel
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState game) {
    if (game == null) {
      throw new IllegalArgumentException("The model is null");
    }
    this.game = game;
    this.output = System.out;
  }

  /**
   * A second constructor that takes in Appendable.
   *
   * @param game the game in the view
   * @param output the output of the view
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState game, Appendable output) {
    if (game == null || output == null) {
      throw new IllegalArgumentException("Null error");
    }
    this.game = game;
    this.output = output;
  }

  /**
   * Turns the board into a String view.
   *
   * @return the board in String view
   */
  public String toString() {
    String ret = "";
    for (int i = 0; i < this.game.getBoardSize(); i++) {
      for (int j = 0; j < this.game.getBoardSize(); j++) {

        if (game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          ret = ret + "O";
        }
        if (game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          ret = ret + "_";
        }
        if (game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
          if (j > this.game.getBoardSize() / 2) {
            j = j + 100000;
          } else {
            ret = ret + "  ";
          }
        } else {
          try {
            if (!this.game.getSlotAt(i,
                    j + 1).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
              ret = ret + " ";
            }
          } catch (IllegalArgumentException e) {
            //nothing happens
          }
        }
      }
      if (i != game.getBoardSize() - 1) {
        ret = ret + "\n";
      }
    }
    return ret;
  }

  /**
   * Renders board to the output.
   *
   * @throws IOException if it cant transmit
   */
  @Override
  public void renderBoard() throws IOException {
    try {
      this.output.append(this.toString() + "\n");
    } catch (IOException e) {
      throw new IOException();
    }
  }

  /**
   * Renders message to the output.
   *
   * @throws IOException if it cant transmit
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.output.append(message);
    } catch (IOException e) {
      throw new IOException();
    }
  }
}