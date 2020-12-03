package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.model.Player;

public abstract class AbstractCard implements ICard {
  private final String name;
  protected Player owner;

  protected AbstractCard(final String name, final Player owner) {
    this.name = name;
    this.owner = owner;
  }

  @Override
  public void sendToGraveyard() {
    owner.sendToGraveyard(this);
  }
}
