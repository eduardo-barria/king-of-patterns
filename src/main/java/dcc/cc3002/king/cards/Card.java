package dcc.cc3002.king.cards;

import dcc.cc3002.king.PlayerMat;
import java.util.Objects;

/**
 * Cards are the main element of the game.
 * <p>
 * A card can be magical or a monster.
 *
 * @author Ignacio Slater Muñoz
 */
public class Card {

  private final CardType type;

  public Card(final CardType type) {
    this.type = type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Card)) {
      return false;
    }
    final Card card = (Card) o;
    return type == card.type;
  }

  /**
   * Plays this card to it's corresponding zone on the player's mat.
   */
  public void playTo(final PlayerMat playerMat) {

  }
}
