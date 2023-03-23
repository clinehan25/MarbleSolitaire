import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class Hw04TypeChecks {

  /**
   * This is annoying just for some points i need this period ->.
   *
   * @param args idk bro
   */
  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helperMarble(new EnglishSolitaireModel(), rd, ap);

    helperTriangle(new TriangleSolitaireModel(3, 3), rd, ap);
  }

  private static void helperMarble(MarbleSolitaireModel model, Readable rd, Appendable ap) {
    new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(model,
            new cs3500.marblesolitaire.view.MarbleSolitaireTextView(model,ap),rd);
  }

  private static void helperTriangle(MarbleSolitaireModel model, Readable rd, Appendable ap) {
    new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(model,
            new cs3500.marblesolitaire.view.MarbleSolitaireTextView(model,ap),rd);
  }

}
