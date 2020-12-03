package cl.uchile.dcc.cc3002.king.model.cards.utils;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

/**
 * Interface used to create new cards.
 */
public interface ICardFactory {

  /**
   * Returns a new instance of the card.
   */
  ICard make();

  void setName(String name);
}
