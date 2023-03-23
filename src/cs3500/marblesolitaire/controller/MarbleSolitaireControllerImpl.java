package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Implements the Marble Solitaire Controller and its methods.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  MarbleSolitaireModel model;
  MarbleSolitaireView view;
  Readable input;

  /**
   * Constructor for the Marble Solitaire Controller consisting of a model, view, and inputs.
   *
   * @param model the model of the game
   * @param view  the view of the game
   * @param input the inputs of the game
   * @throws IllegalArgumentException if any given is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable input) throws IllegalArgumentException {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("Null error");
    }

    this.model = model;
    this.view = view;
    this.input = input;
  }

  /**
   * Plays a new game of Marble Solitaire.
   *
   * @throws IllegalArgumentException if it can't read input or output
   */
  @Override
  public void playGame() throws IllegalArgumentException {
    Scanner s = new Scanner(this.input);
    int[] moveValues = new int[4];
    String temp = "";

    while (!this.model.isGameOver()) {

      try {
        this.view.renderBoard();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      try {
        this.view.renderMessage("Score: " + this.model.getScore() + "\n");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      for (int i = 0; i < moveValues.length; i++) {
        if (s.hasNext()) {
          temp = s.next();
          try {
            moveValues[i] = Integer.parseInt(temp);
            System.out.println(moveValues[i]);
          } catch (NumberFormatException e) {
            if (temp.equals("q") || temp.equals("Q")) {
              try {
                this.view.renderMessage("Game quit!\nState of game when quit:\n");
              } catch (IOException e1) {
                throw new RuntimeException(e1);
              }
              try {
                this.view.renderBoard();
              } catch (IOException e1) {
                throw new RuntimeException(e1);
              }
              try {
                this.view.renderMessage("Score: " + this.model.getScore() + "\n");
              } catch (IOException e1) {
                throw new RuntimeException(e1);
              }
              return;
            }
          }
        } else {
          return;
        }
      }

      int fRow = moveValues[0] - 1;
      int fCol = moveValues[1] - 1;
      int tRow = moveValues[2] - 1;
      int tCol = moveValues[3] - 1;

      try {
        this.model.move(fRow, fCol, tRow, tCol);
      } catch (IllegalArgumentException e) {
        try {
          this.view.renderMessage("Invalid move. Play again.\n");
          throw new IllegalArgumentException(e);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }

      if (this.model.isGameOver()) {
        try {
          this.view.renderMessage("Game Over!\nLast board:\n");
        } catch (IOException e1) {
          throw new RuntimeException(e1);
        }

        try {
          this.view.renderBoard();
        } catch (IOException e1) {
          throw new RuntimeException(e1);
        }

        try {
          this.view.renderMessage("Score: " + this.model.getScore() + "\n");
        } catch (IOException e1) {
          throw new RuntimeException(e1);
        }
        return;
      }
    }
  }
}
