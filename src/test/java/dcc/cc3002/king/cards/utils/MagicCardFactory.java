package dcc.cc3002.king.cards.utils;

import dcc.cc3002.king.cards.MagicCard;

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
