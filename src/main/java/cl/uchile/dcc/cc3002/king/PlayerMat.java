package cl.uchile.dcc.cc3002.king;

import cl.uchile.dcc.cc3002.king.cards.ICard;
import cl.uchile.dcc.cc3002.king.cards.MagicCard;
import cl.uchile.dcc.cc3002.king.cards.MonsterCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The game's mat is where all the player's cards are played.
 *
 * @author Ignacio Slater M.
 */
public class PlayerMat {

  private final List<ICard> monsterZone = new ArrayList<>();
  private final List<ICard> magicZone = new ArrayList<>();

  /**
   * Adds a card to the monster zone.
   */
  public void addMonsterCard(MonsterCard card) {
    addCardTo(monsterZone, card);
  }

  /**
   * Adds a card to the magic zone.
   */
  public void addMagicCard(final MagicCard card) {
    addCardTo(magicZone, card);
  }

  /**
   * Adds a card to a zone in the game's mat.
   */
  private void addCardTo(final List<ICard> zone, final ICard card) {
    if (zone.size() < 5) {
      zone.add(card);
    }
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

  public List<ICard> getMonsterZone() {
    return List.copyOf(monsterZone);
  }

  public List<ICard> getMagicZone() {
    return List.copyOf(magicZone);
  }

  public void removeMagicCard(final MagicCard magicCard) {
    magicZone.remove(magicCard);
  }

  public void removeMonsterCard(final MonsterCard monsterCard) {
    monsterZone.remove(monsterCard);
  }
}
