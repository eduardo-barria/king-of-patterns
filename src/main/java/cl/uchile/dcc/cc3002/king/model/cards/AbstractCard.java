package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.model.PlayerMat;

public abstract class AbstractCard implements ICard {
  @Override
  public void sendToGraveyard(final PlayerMat mat) {
    mat.sendToGraveyard(this);
  }
}
