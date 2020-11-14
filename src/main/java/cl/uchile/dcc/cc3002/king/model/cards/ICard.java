package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.model.PlayerMat;

/**
 * Cards are the main element of the game.
 * <p>
 * A card can be magical or a monster.
 *
 * @author Ignacio Slater Muñoz
 */
public interface ICard {

  /**
   * Plays this card to it's corresponding zone on the player's mat.
   */
  void playTo(final PlayerMat playerMat);

  String getName();
}
