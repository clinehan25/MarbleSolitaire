package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract of the model class.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected int sRow;
  protected int sCol;
  protected static SlotState[][] board;
  protected static int armThickness;

  /**
   * Constructor that takes in no parameters.
   */
  public AbstractSolitaireModel() {
    this.armThickness = 3;
    this.sRow = (3 * armThickness - 2) / 2;
    this.sCol = (3 * armThickness - 2) / 2;

    this.board = boardSetUp();
  }

  /**
   * Constructor that takes in a armThickness.
   *
   * @param armThickness The thickness of the arms of the board.
   * @throws IllegalArgumentException if invalid arm thickness
   */
  public AbstractSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness % 2 != 1 && armThickness < 2) {
      throw new IllegalArgumentException("Arm Thickness must be a positive odd number");
    }
    this.armThickness = armThickness;
    this.sRow = (3 * armThickness - 2) / 2;
    this.sCol = (3 * armThickness - 2) / 2;

    this.board = boardSetUp();
  }

  /**
   * Constructor that takes in an empty location.
   *
   * @param sRow row of empty slot
   * @param sCol column of empty slot
   * @throws IllegalArgumentException if invalid empty slot
   */
  public AbstractSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.armThickness = 3;
    this.sRow = sRow;
    this.sCol = sCol;

    this.board = boardSetUp();
  }

  /**
   * Constructor that takes in both empty slot and arm thickness.
   *
   * @param armThickness arm thickness of the board.
   * @param sRow row of empty slot.
   * @param sCol column of empty slot.
   * @throws IllegalArgumentException if an input is invalid.
   */
  public AbstractSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;

    this.board = boardSetUp();
  }

  /**
   * Abstract for the boardSetUp method.
   *
   * @return An array representative of the board.
   */
  protected abstract SlotState[][] boardSetUp();

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
  public abstract void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException;

  /**
   * Return true if the game has been won or lost.
   *
   * @return if the game has been won or lost.
   */
  @Override
  public abstract boolean isGameOver();

  /**
   * Returns the size of the board.
   *
   * @return the board size
   */
  @Override
  public int getBoardSize() {
    return this.board.length;
  }

  /**
   * Returns the slot state at a given row and col.
   *
   * @param sRow the row of the position sought, starting at 0
   * @param sCol the column of the position sought, starting at 0
   * @return the SlotState of the inputted slot
   */
  @Override
  public SlotState getSlotAt(int sRow, int sCol) throws IllegalArgumentException {
    try {
      return this.board[sRow][sCol];
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("Slot out of bounds." + sRow + sCol);
    }
  }

  /**
   * Gets the score of the game.
   *
   * @return the score of the game
   */
  @Override
  public int getScore() {
    int ret = 0;
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (this.board[i][j] == SlotState.Marble) {
          ret += 1;
        }
      }
    }
    return ret;
  }

  /**
   * Checks if inputted value is valid slot.
   *
   * @param sRow of the slot.
   * @param sCol of the slot.
   * @return Whether input is valid slot.
   */
  protected boolean checkValid(int sRow, int sCol) {
    return (sRow >= 0 && sCol >= 0 && sRow < (this.armThickness * 3 - 2)
            && sCol < (this.armThickness * 3 - 2));
  }
}
