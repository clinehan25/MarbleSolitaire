package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * A solitaire model in triangle form.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel implements MarbleSolitaireModel {

  /**
   * Default constructor for TriangleSolitaireModel.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * Constructor for TriangleSolitaireModel with armThickness.
   */
  public TriangleSolitaireModel(int armThickness) {
    this(armThickness, 0, 0);
  }


  /**
   * Constructor for TriangleSolitaireModel with empty slot space.
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    this(5, sRow, sCol);
  }

  /**
   * Constructor for TriangleSolitaireModel with all parameters.
   *
   * @throws IllegalArgumentException if armThickness is less than 2
   */
  public TriangleSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * Sets up the board using the given Constructor inputs.
   *
   * @return the fully set up board
   * @throws IllegalArgumentException if empty slot is not valid
   */
  @Override
  protected SlotState[][] boardSetUp() throws IllegalArgumentException {
    if (this.armThickness < 1) {
      throw new IllegalArgumentException("Arm Thickness must be a positive number");
    }

    SlotState[][] ret = new SlotState[this.armThickness][this.armThickness];
    for (int i = 0; i < this.armThickness; i++) {
      for (int j = 0; j < this.armThickness; j++) {
        if (j <= i) {
          ret[i][j] = SlotState.Marble;
          //System.out.print("M");
        } else {
          ret[i][j] = SlotState.Invalid;
          //System.out.print("I");
        }
      }
      //System.out.println();
    }

    if (ret[sRow][sCol] == SlotState.Marble) {
      ret[sRow][sCol] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException("Invalid empty location");
    }
    return ret;
  }

  /**
   * Move method for the TriangleSolitaireModel.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if move slot from or to is invalid
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.checkValid(fromRow, fromCol) && checkValid(toRow, toCol)) {
      if (this.board[fromRow][fromCol] == SlotState.Marble
              && this.board[toRow][toCol] == SlotState.Empty) {
        if (((Math.abs(fromRow - toRow) == 2) && (fromCol == toCol))) {
          if (fromRow > toRow) {
            if (this.board[fromRow - 1][fromCol] == SlotState.Marble) {
              this.board[fromRow - 1][fromCol] = SlotState.Empty;
              this.board[fromRow][fromCol] = SlotState.Empty;
              this.board[toRow][toCol] = SlotState.Marble;
            } else {
              throw new IllegalArgumentException("invalid move");
            }
          } else if (fromRow < toRow) {
            if (this.board[fromRow + 1][fromCol] == SlotState.Marble) {
              this.board[fromRow + 1][fromCol] = SlotState.Empty;
              this.board[fromRow][fromCol] = SlotState.Empty;
              this.board[toRow][toCol] = SlotState.Marble;
            } else {
              throw new IllegalArgumentException("invalid move");
            }
          }
        } else if (((Math.abs(fromCol - toCol) == 2) && (fromRow == toRow))) {
          if (fromCol > toCol) {
            if (this.board[fromRow][fromCol - 1] == SlotState.Marble) {
              this.board[fromRow][fromCol - 1] = SlotState.Empty;
              this.board[fromRow][fromCol] = SlotState.Empty;
              this.board[toRow][toCol] = SlotState.Marble;
            } else {
              throw new IllegalArgumentException("invalid move");
            }
          } else if (fromCol < toCol) {
            if (this.board[fromRow][fromCol + 1] == SlotState.Marble) {
              this.board[fromRow][fromCol + 1] = SlotState.Empty;
              this.board[fromRow][fromCol] = SlotState.Empty;
              this.board[toRow][toCol] = SlotState.Marble;
            } else {
              throw new IllegalArgumentException("invalid move");
            }
          }
        } else if ((Math.abs(fromRow - toRow) == 2) && (Math.abs(fromCol - toCol) == 2)) {
          if ((fromRow > toRow) && (fromCol > toCol)) {
            if (this.board[fromRow - 1][fromCol - 1] == SlotState.Marble) {
              this.board[fromRow - 1][fromCol - 1] = SlotState.Empty;
              this.board[fromRow][fromCol] = SlotState.Empty;
              this.board[toRow][toCol] = SlotState.Marble;
            } else {
              throw new IllegalArgumentException("invalid move");
            }
          } else if ((fromRow < toRow) && (fromCol < toCol)) {
            if (this.board[fromRow + 1][fromCol + 1] == SlotState.Marble) {
              this.board[fromRow + 1][fromCol + 1] = SlotState.Empty;
              this.board[fromRow][fromCol] = SlotState.Empty;
              this.board[toRow][toCol] = SlotState.Marble;
            } else {
              throw new IllegalArgumentException("invalid move");
            }
          }
        } else {
          throw new IllegalArgumentException("invalid move1");
        }
      } else {
        throw new IllegalArgumentException("invalid move");
      }
    } else {
      throw new IllegalArgumentException("invalid move out of bounds");
    }
  }

  /**
   * Checks whether the game is over or not.
   *
   * @return whether the game has ended
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.armThickness; i++) {
      for (int j = 0; j < this.armThickness; j++) {
        if (this.board[i][j] == SlotState.Marble) {
          if (this.checkValid(i - 2, j)) {
            if ((this.board[i - 2][j] == SlotState.Empty)
                    && (this.board[i - 1][j] == SlotState.Marble)) {
              return false;
            }
          }
          if (this.checkValid(i + 2, j)) {
            if ((this.board[i + 2][j] == SlotState.Empty)
                    && (this.board[i + 1][j] == SlotState.Marble)) {
              return false;
            }
          }
          if (this.checkValid(i, j + 2)) {
            if ((this.board[i][j + 2] == SlotState.Empty)
                    && (this.board[i][j + 1] == SlotState.Marble)) {
              return false;
            }
          }
          if (this.checkValid(i, j - 2)) {
            if ((this.board[i][j - 2] == SlotState.Empty)
                    && (this.board[i][j - 1] == SlotState.Marble)) {
              return false;
            }
          }
          if (this.checkValid(i + 2, j + 2)) {
            if ((this.board[i + 2][j + 2] == SlotState.Empty)
                    && (this.board[i + 1][j + 1] == SlotState.Marble)) {
              return false;
            }
          }
          if (this.checkValid(i - 2, j - 2)) {
            if ((this.board[i - 2][j - 2] == SlotState.Empty)
                    && (this.board[i - 1][j - 1] == SlotState.Marble)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * Checks if inputted value is valid slot (different for triangle).
   *
   * @param sRow of the slot.
   * @param sCol of the slot.
   * @return Whether input is valid slot.
   */
  @Override
  protected boolean checkValid(int sRow, int sCol) {
    return (sRow >= 0 && sCol >= 0 && sRow < this.armThickness
            && sCol < this.armThickness);
  }
}