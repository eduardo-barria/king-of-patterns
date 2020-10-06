package dcc.cc3002.king;

import java.util.Objects;

/**
 * Cards are the main element of the game.
 * <p>
 * A card can be magical or a monster.
 *
 * @author Ignacio Slater Muñoz
 */
public class Card {

  @Override
  public int hashCode() {
    return Objects.hash(Card.class);
  }

  @Override
  public boolean equals(final Object obj) {
    return obj instanceof Card;
  }
}
