package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * This class implements the MarbleSolitaireModel interface.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel implements MarbleSolitaireModel {
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  public EnglishSolitaireModel(int armThickness) {
    this(armThickness, (3 * armThickness - 2) / 2, (3 * armThickness - 2) / 2);
  }

  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructor that takes in a armThickness and a starting row and col.
   *
   * @param armThickness thickness of the arms of the solitaire
   * @param sRow         row of the entered starting space
   * @param sCol         col of the entered starting space
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
  }

  /**
   * Moves a marble to an empty space assuming the move passes.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0 || fromRow >= getBoardSize()
            || fromCol >= getBoardSize() || toRow >= getBoardSize() || toCol >= getBoardSize()) {
      throw new IllegalArgumentException("Selected position does not exists");
    }

    if (this.board[fromRow][fromCol] != SlotState.Marble
            || this.board[toRow][toCol] != SlotState.Empty) {
      throw new IllegalArgumentException("Invalid from and/or to board position");
    }

    if (!((fromRow == toRow && Math.abs(fromCol - toCol) == 2)
            || (fromCol == toCol && Math.abs(fromRow - toRow) == 2))) {
      throw new IllegalArgumentException("The two selected slots are not exactly"
              + " two squares away vertically or horizontally.");
    }

    if (this.board[(toRow + fromRow) / 2][(fromCol + toCol) / 2] != SlotState.Marble) {
      throw new IllegalArgumentException("Not a marble between from and to positions.");
    }

    this.board[(toRow + fromRow) / 2][(fromCol + toCol) / 2] = SlotState.Empty;
    this.board[toRow][toCol] = SlotState.Marble;
    this.board[fromRow][fromCol] = SlotState.Empty;
  }

  /**
   * Returns whether the game is over or not.
   *
   * @return whether the game is over or not
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (this.board[i][j] == SlotState.Marble) {
          if ((j - 1 >= 0 && this.board[i][j - 1] == SlotState.Marble)
                  && (j - 2 >= 0 && this.board[i][j - 2] == SlotState.Empty)) {
            return false;
          }
          if ((j + 1 < getBoardSize() && this.board[i][j + 1] == SlotState.Marble)
                  && (j + 2 < getBoardSize() && this.board[i][j + 2] == SlotState.Empty)) {
            return false;
          }
          if ((i - 1 >= 0 && this.board[i - 1][j] == SlotState.Marble)
                  && (i - 2 >= 0 && this.board[i - 2][j] == SlotState.Empty)) {
            return false;
          }
          if ((i + 1 < getBoardSize() && this.board[i + 1][j] == SlotState.Marble)
                  && (i + 2 < getBoardSize() && this.board[i + 2][j] == SlotState.Empty)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Sets up the board with proper SlotStates for the game.
   *
   * @return returns a setup board
   */
  protected SlotState[][] boardSetUp() {
    SlotState[][] ret = new SlotState[this.armThickness * 3 - 2][this.armThickness * 3 - 2];

    for (int x = 0; x < ((this.armThickness * 3) - 2); x++) {
      for (int y = 0; y < ((this.armThickness * 3) - 2); y++) {
        if ((x > ((this.armThickness * 2) - 2) || x <= (this.armThickness - 2))
                && (y > ((this.armThickness * 2) - 2) || y <= (this.armThickness - 2))) {
          ret[x][y] = SlotState.Invalid;
        } else {
          ret[x][y] = SlotState.Marble;
        }
      }
    }

    if (ret[sRow][sCol] != SlotState.Invalid) {
      ret[sRow][sCol] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Invalid Center Space.");
    }
    return ret;
  }
}
