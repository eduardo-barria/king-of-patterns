package dcc.cc3002.king;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameMat {

  private final List<Card> monsterZone = new ArrayList<>();

  @Override
  public int hashCode() {
    return Objects.hashCode(GameMat.class);
  }

  @Override
  public boolean equals(final Object obj) {
    return obj instanceof GameMat;
  }

  public List<Card> getMonsterZone() {
    return monsterZone;
  }
}
