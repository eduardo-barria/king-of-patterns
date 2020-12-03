package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;

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

  @Override
  public String getName() {
    return name;
  }

  protected enum CardType {
    MAGIC,
    MONSTER
  }
}
