package cl.uchile.dcc.cc3002.king.model;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.controller.CardSelectionException;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;
import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;
import cl.uchile.dcc.cc3002.king.model.cards.monster.MonsterCard;
import cl.uchile.dcc.cc3002.king.model.cards.monster.IMonsterCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The game's mat is where all the player's cards are played.
 *
 * @author Ignacio Slater M.
 */
public class PlayerMat {

  private final List<IMonsterCard> monsterZone = new ArrayList<>();
  private final List<MagicCard> magicZone = new ArrayList<>();

  /**
   * Adds a card to the monster zone.
   */
  public void addMonsterCard(final IMonsterCard card) throws CardPlacementException {
    if (monsterZone.size() < 5) {
      monsterZone.add(card);
    }
    throw new CardPlacementException("Can't add a monster card if the monster zone is full.");
  }

  /**
   * Adds a card to the magic zone.
   */
  public void addMagicCard(final MagicCard card) throws CardPlacementException {
    if (magicZone.size() < 5) {
      magicZone.add(card);
    }
    throw new CardPlacementException("Can't add a magic card if the magic zone is full.");
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

  public void sendToGraveyard(final ICard card) {

  }

  public IMonsterCard getMonsterCardAt(final int index) throws CardSelectionException {
    if (index < monsterZone.size()) {
      return monsterZone.get(index);
    }
    throw new CardSelectionException(
        "Tried to select monster card at position " + index + ", but the monster zone has only "
        + monsterZone.size() + " cards.");
  }
}
