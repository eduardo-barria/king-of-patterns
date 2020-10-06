package dcc.cc3002.king;

import dcc.cc3002.king.cards.AbstractCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The game's mat is where all the player's cards are played.
 *
 * @author Ignacio Slater M.
 */
public class PlayerMat {

  private final List<AbstractCard> monsterZone = new ArrayList<>();
  private final List<AbstractCard> magicZone = new ArrayList<>();

  /**
   * Adds a card to the monster zone.
   */
  public void addMonsterCard(AbstractCard card) {
    addCardTo(monsterZone, card);
  }

  /**
   * Adds a card to a zone in the game's mat.
   */
  private void addCardTo(final List<AbstractCard> zone, final AbstractCard card) {
    if (zone.size() < 5) {
      zone.add(card);
    }
  }

  /**
   * Adds a card to the magic zone.
   */
  public void addMagicCard(final AbstractCard card) {
    addCardTo(magicZone, card);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMonsterZone(), getMagicZone());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlayerMat)) {
      return false;
    }
    final PlayerMat playerMat = (PlayerMat) o;
    return getMonsterZone().equals(playerMat.getMonsterZone()) &&
        getMagicZone().equals(playerMat.getMagicZone());
  }

  public List<AbstractCard> getMonsterZone() {
    return List.copyOf(monsterZone);
  }

  public List<AbstractCard> getMagicZone() {
    return List.copyOf(magicZone);
  }
}
