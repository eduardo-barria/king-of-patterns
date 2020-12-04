/*
 * "King of Patterns" (c) 2020 by Ignacio Slater M.
 * "King of Patterns" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 *
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.effects.IEffect;

public abstract class AbstractCard implements ICard {
  protected final String name;
  protected Player owner;
  protected PlayerMat mat;

  protected AbstractCard(final String name, final Player owner) {
    this.name = name;
    this.owner = owner;
  }

  @Override
  public void sendToGraveyard() throws CardPlacementException {
    owner.sendToGraveyard(this);
  }

  protected void checkMat(final CardType cardType) throws CardPlacementException {
    if (mat == null) {
      throw new CardPlacementException(
          "A " + cardType.toString()
          + " card that hasn't been played is trying to be removed from the mat.");
    }
  }

  // region : Accessor methods
  @Override
  public String getName() {
    return name;
  }

  @Override
  public Player getOwner() {
    return owner;
  }
  // endregion

  protected enum CardType {
    MAGIC,
    MONSTER
  }
}
