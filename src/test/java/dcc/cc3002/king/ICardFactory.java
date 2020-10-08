package dcc.cc3002.king;

import dcc.cc3002.king.cards.AbstractCard;

/**
 * Interface used to create new cards.
 *
 * @param <T>
 *     the concrete type of the card.
 */
@FunctionalInterface
public interface ICardFactory<T extends AbstractCard> {

  /**
   * Returns a new instance of the card.
   */
  T make();
}
