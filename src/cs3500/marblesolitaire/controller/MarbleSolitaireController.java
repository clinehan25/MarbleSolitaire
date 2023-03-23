package cs3500.marblesolitaire.controller;

/**
 * A controller of the game and board directed by human inputs.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire.
   *
   * @throws IllegalArgumentException if the input or output can't be read.
   */
  void playGame() throws IllegalArgumentException;
}
