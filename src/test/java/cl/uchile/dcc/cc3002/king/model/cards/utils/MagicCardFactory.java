package cl.uchile.dcc.cc3002.king.model.cards.utils;

import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;

public class MagicCardFactory implements ICardFactory {

  private final String name;

  public MagicCardFactory(String name) {
    this.name = name;
  }

  @Override
  public MagicCard make() {
    return new MagicCard(name);
  }
}
