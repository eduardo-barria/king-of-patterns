package cl.uchile.dcc.cc3002.king.model.cards.utils;

import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;

public class MagicCardFactory implements ICardFactory {

  private String name;

  public MagicCardFactory(final String name) {
    this.name = name;
  }

  @Override
  public MagicCard make() {
    return new MagicCard(name, null);
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }
}
