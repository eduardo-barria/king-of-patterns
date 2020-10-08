package dcc.cc3002.king.cards.utils;

import dcc.cc3002.king.cards.ICard;

/**
 * Interface used to create new cards.
 */
@FunctionalInterface
public interface ICardFactory {

  /**
   * Returns a new instance of the card.
   */
  ICard make();
}
