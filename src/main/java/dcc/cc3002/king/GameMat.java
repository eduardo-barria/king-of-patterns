package dcc.cc3002.king;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameMat {

  private final List<Card> monsterZone = new ArrayList<>();
  private final List<Card> magicZone = new ArrayList<>();

  /**
   * Adds a card to the monster zone.
   */
  public void addMonsterCard(Card card) {
    addCardTo(monsterZone, card);
  }

  private void addCardTo(final List<Card> zone, final Card card) {
    if (zone.size() < 5) {
      zone.add(card);
    }
  }

  public void addMagicCard(final Card card) {
    addCardTo(magicZone, card);
  }

  public List<Card> getMonsterZone() {
    return List.copyOf(monsterZone);
  }

  public List<Card> getMagicZone() {
    return List.copyOf(magicZone);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(GameMat.class);
  }

  @Override
  public boolean equals(final Object obj) {
    return obj instanceof GameMat;
  }
}
