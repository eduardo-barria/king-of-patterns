package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.model.PlayerMat;

import java.util.Objects;

public class MonsterCard extends AbstractCard {

  private final int attackPoints;
  private final int defensePoints;
  private CardPosition position;
  private PlayerMat mat;

  public MonsterCard(final int attackPoints, final int defensePoints,
                     final CardPosition cardPosition) {
    this.attackPoints = attackPoints;
    this.defensePoints = defensePoints;
    this.position = cardPosition;
  }

  @Override
  public void playTo(final PlayerMat playerMat) {
    playerMat.addMonsterCard(this);
    this.mat = playerMat;
  }

  public void attack(final MonsterCard opponent) {
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
    if (!(o instanceof MonsterCard)) {
      return false;
    }
    final MonsterCard that = (MonsterCard) o;
    return getAttackPoints() == that.getAttackPoints() &&
        getDefensePoints() == that.getDefensePoints();
  }
  // endregion

  // region : Field accessors
  public int getAttackPoints() {
    return attackPoints;
  }

  public int getDefensePoints() {
    return defensePoints;
  }

  public CardPosition getPosition() {
    return position;
  }

  public void setPosition(final CardPosition position) {
    this.position = position;
  }
  // endregion
}
