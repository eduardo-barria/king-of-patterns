package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.effects.IEffect;

import java.util.Objects;

/**
 * Class that represents a magic card in the game.
 *
 * @author Ignacio Slater Muñoz
 */
public class MagicCard extends AbstractCard {

  public MagicCard(final String name, final Player owner, final IEffect effect) {
    super(name, owner, effect);
  }

  @Override
  public void playTo(final PlayerMat playerMat) throws CardPlacementException {
    playerMat.addMagicCard(this);
    mat = playerMat;
  }

  @Override
  public void removeFromMat() throws CardPlacementException {
    checkMat(CardType.MAGIC);
    mat.removeMagicCard(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), MagicCard.class);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MagicCard)) {
      return false;
    }
    final MagicCard magicCard = (MagicCard) o;
    return getName().equals(magicCard.getName());
  }
}
