package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * A triangle solitaire view made from a triangle model.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * Constructor for triangle that takes in a game state.
   *
   * @param game a Triangle model
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game) {
    super(game);
  }

  /**
   * Constructor for triangle that takes in a games state and the output.
   *
   * @param game a TriangleSolitaireModel
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game, Appendable output) {
    super(game, output);
  }

  /**
   * Turns the triangle board into a string for the view.
   *
   * @return A String of the board.
   */
  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < (this.game.getBoardSize()); i++) {
      for (int x = 0; x < (this.game.getBoardSize()) - i - 1; x++) {
        ret.append(" ");
      }
      for (int j = 0; j < (this.game.getBoardSize()); j++) {
        String current = (j == 0) ? "" : " ";
        if ((this.game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid)) {
          ret.append("");
        } else if ((this.game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty)) {
          ret.append(current + "_");
        } else {
          ret.append(current + "O");
        }
      }
      if (i != this.game.getBoardSize() - 1) {
        ret.append("\n");
      }
    }
    return ret.toString();
  }
}
