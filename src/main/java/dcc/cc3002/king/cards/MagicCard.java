package dcc.cc3002.king.cards;

import dcc.cc3002.king.PlayerMat;
import java.util.Objects;

/**
 * Class that represents a magic card in the game.
 *
 * @author Ignacio Slater Muñoz
 */
public class MagicCard implements ICard {

  public MagicCard(final String name) {

  }

  @Override
  public void playTo(final PlayerMat playerMat) {
    playerMat.addMagicCard(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(MagicCard.class);
  }

  @Override
  public boolean equals(final Object obj) {
    return obj instanceof MagicCard;
  }
}
