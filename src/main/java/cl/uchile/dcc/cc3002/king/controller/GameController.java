// "king-of-patterns" (c) by Ignacio Slater M.
// "king-of-patterns" is licensed under a
// Creative Commons Attribution 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
package cl.uchile.dcc.cc3002.king.controller;

import cl.uchile.dcc.cc3002.king.model.Player;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public class GameController {
  private Player playerA = new Player("A", 8000);
  private Player playerB = new Player("B", 8000);

  public static void main(String[] args) {
    var controller = new GameController();
    controller.printGameStatus();
  }

  public void printGameStatus() {
    playerA.print();
    System.out.println();
    playerB.print();
  }
}
