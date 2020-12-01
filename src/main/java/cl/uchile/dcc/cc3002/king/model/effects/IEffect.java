package cl.uchile.dcc.cc3002.king.model.effects;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

/**
 * All cards in the game can have an effect.
 * <p>
 * An effect is an action that's applied to a given element of the game, e.g. a card.
 *
 * @author Ignacio Slater
 */
public interface IEffect {
  /**
   * Applies this effect to a card.
   */
  void activate(ICard card);
}
