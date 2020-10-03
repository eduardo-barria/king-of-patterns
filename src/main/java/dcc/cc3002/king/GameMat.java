package dcc.cc3002.king;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameMat {

  private final List<Card> monsterZone = new ArrayList<>();

  /**
   * Adds a card to the monster zone.
   */
  public void addMonsterCard(Card card) {
    if (monsterZone.size() < 5) {
      monsterZone.add(card);
    }
  }

  public List<Card> getMonsterZone() {
    return List.copyOf(monsterZone);
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
