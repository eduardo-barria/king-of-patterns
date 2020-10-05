package dcc.cc3002.king;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The game's mat is where all the player's cards are played.
 *
 * @author Ignacio Slater M.
 */
public class PlayerMat {

  private final List<Card> monsterZone = new ArrayList<>();
  private final List<Card> magicZone = new ArrayList<>();

  /**
   * Adds a card to the monster zone.
   */
  public void addMonsterCard(Card card) {
    addCardTo(monsterZone, card);
  }

  /**
   * Adds a card to a zone in the game's mat.
   */
  private void addCardTo(final List<Card> zone, final Card card) {
    if (zone.size() < 5) {
      zone.add(card);
    }
  }

  /**
   * Adds a card to the magic zone.
   */
  public void addMagicCard(final Card card) {
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

  public List<Card> getMonsterZone() {
    return List.copyOf(monsterZone);
  }

  public List<Card> getMagicZone() {
    return List.copyOf(magicZone);
  }
}
