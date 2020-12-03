// "king-of-patterns" (c) by Ignacio Slater M.
// "king-of-patterns" is licensed under a
// Creative Commons Attribution 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
package cl.uchile.dcc.cc3002.king.model.cards.monster;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public class Rank2Monster extends AbstractMonsterCard {
  public Rank2Monster(final String name, final Player owner, final int attackPoints,
                      final int defensePoints, final int level, final CardPosition position) {
    super(name, owner, attackPoints, defensePoints, level, position);
  }

  @Override
  protected boolean hasEnoughTributes(final int tributes) throws CardPlacementException {
    if (tributes == 1) {
      return true;
    }
    throw new CardPlacementException(
        "A rank 2 monster requires 1 tribute but " + tributes + " were given.");
  }
}
