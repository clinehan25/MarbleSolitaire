package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * A marble solitaire model made in a european formation.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel implements MarbleSolitaireModel {
  /**
   * Default constructor for EuropeanSolitaireModel.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructor for EuropeanSolitaireModel with armThickness.
   */
  public EuropeanSolitaireModel(int armThickness) {
    this(armThickness, (3 * armThickness - 2) / 2,(3 * armThickness - 2) / 2);
  }

  /**
   * Constructor for EuropeanSolitaireModel with sRow, sCol.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructor for EuropeanSolitaireModel with all parameters, armThickness, sRow, and sCol.
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol) {
    super(armThickness, sRow, sCol);
  }

  /**
   * Board set up for the European style Marble Solitaire.
   *
   * @return the set-up board
   */
  @Override
  protected SlotState[][] boardSetUp() {
    SlotState[][] ret = new SlotState[this.armThickness * 3 - 2][this.armThickness * 3 - 2];

    for (int i = 0; i < ((this.armThickness * 3) - 2); i++) {
      for (int j = 0; j < ((this.armThickness * 3) - 2); j++) {
        if ((i <= (this.armThickness - 2) || i > ((this.armThickness * 2) - 2))
                && (j <= (this.armThickness - 2) || j > ((this.armThickness * 2) - 2))) {
          ret[i][j] = SlotState.Invalid;
        } else {
          ret[i][j] = SlotState.Marble;
        }
      }
    }

    for (int i = 0; i < ((this.armThickness * 3) - 2); i++) {
      for (int j = this.armThickness - (((3 * this.armThickness - 2 - 1) / 2 - Math.abs(i
              - (3 * this.armThickness - 2 - 1) / 2)) + 1); j < this.armThickness * 2 - 2
              + (((3 * this.armThickness - 2 - 1) / 2 - Math.abs(i - (3 * this.armThickness
              - 2 - 1) / 2)) + 1); j++) {
        if (i >= this.armThickness && i <= this.armThickness * 2 - 2
                || j >= this.armThickness * 3 - 2) {
          continue;
        }

        ret[i][j] = SlotState.Marble;
      }
    }

    if (ret[sRow][sCol] == SlotState.Marble) {
      ret[sRow][sCol] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Invalid location");
    }
    return ret;
  }

  /**
   * Move method for the European Solitaire Model.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if move to or from slot is invalid
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.armThickness % 2 != 1 || this.armThickness < 2) {
      throw new IllegalArgumentException("Arm Thickness must be a positive odd number");
    }

    if (!this.checkValid(fromRow, fromCol) || !this.checkValid(toRow, toCol)) {
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
   * Checks if the game is over or not.
   *
   * @return whether the game is over
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
}