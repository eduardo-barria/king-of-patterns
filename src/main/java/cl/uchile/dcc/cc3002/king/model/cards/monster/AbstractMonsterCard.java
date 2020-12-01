package cl.uchile.dcc.cc3002.king.model.cards.monster;

import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;

import java.util.Objects;

public abstract class AbstractMonsterCard implements IMonsterCard {

  private final int attackPoints;
  private final int defensePoints;
  protected int level;
  private CardPosition position;
  private PlayerMat mat;

  protected AbstractMonsterCard(final int attackPoints, final int defensePoints,
                                final int level) {
    this.attackPoints = attackPoints;
    this.defensePoints = defensePoints;
    this.level = level;
  }

  @Override
  public void playTo(final PlayerMat playerMat) {
    playerMat.addMonsterCard(this);
    this.mat = playerMat;
  }

  public void attack(final AbstractMonsterCard opponent) {
    if (this.attackPoints > (opponent.position == CardPosition.ATTACK
                             ? opponent.attackPoints : opponent.defensePoints)) {
      opponent.removeFromMat();
    }
  }

  private void removeFromMat() {
    mat.removeMonsterCard(this);
  }

  // region : Utility
  @Override
  public int hashCode() {
    return Objects.hash(getAttackPoints(), getDefensePoints());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractMonsterCard)) {
      return false;
    }
    final AbstractMonsterCard that = (AbstractMonsterCard) o;
    return getAttackPoints() == that.getAttackPoints() &&
           getDefensePoints() == that.getDefensePoints();
  }
  // endregion

  // region : Field accessors
  @Override
  public int getAttackPoints() {
    return attackPoints;
  }

  @Override
  public int getDefensePoints() {
    return defensePoints;
  }

  @Override
  public int getLevel() {
    return level;
  }
  // endregion
}
