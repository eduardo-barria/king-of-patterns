package dcc.cc3002.king.cards;

import dcc.cc3002.king.PlayerMat;
import java.util.Objects;

public class MonsterCard implements ICard {

  private final int attackPoints;
  private final int defensePoints;

  public MonsterCard(final int attackPoints, final int defensePoints) {
    this.attackPoints = attackPoints;
    this.defensePoints = defensePoints;
  }

  @Override
  public void playTo(final PlayerMat playerMat) {
    playerMat.addMonsterCard(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAttackPoints(), getDefensePoints());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MonsterCard)) {
      return false;
    }
    final MonsterCard that = (MonsterCard) o;
    return getAttackPoints() == that.getAttackPoints() &&
        getDefensePoints() == that.getDefensePoints();
  }

  public int getAttackPoints() {
    return attackPoints;
  }

  public int getDefensePoints() {
    return defensePoints;
  }
}
