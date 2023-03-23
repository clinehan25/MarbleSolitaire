import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class Hw02TypeChecks {

  /**
   * A sample main method.
   *
   * @param args the program arguments
   */
  public static void main(String[] args) {
    //helper(new EnglishSolitaireModel());
    //helper(new EnglishSolitaireModel(2, 2));
    helper(new EnglishSolitaireModel(5));
    //helper(new EnglishSolitaireModel(3, 0, 4));

    MarbleSolitaireView view = new MarbleSolitaireTextView(new EnglishSolitaireModel(5));
    view.toString();
    // System.out.println(new EnglishSolitaireModel());
  }

  private static void helper(MarbleSolitaireModel model) {
    // model.move(1, 3, 3, 3);
  }

}
