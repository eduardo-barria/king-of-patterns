package cl.uchile.dcc.cc3002.king.model.cards.monster;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.cards.AbstractCard;
import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;

import java.util.Objects;

public class MonsterCard extends AbstractCard implements IMonsterCard {

  private final int attackPoints;
  private final int defensePoints;
  protected int level;
  private CardPosition position;

  public MonsterCard(final String name, final Player owner, final int attackPoints,
                     final int defensePoints, final int level,
                     final CardPosition position) {
    super(name, owner);
    this.attackPoints = attackPoints;
    this.defensePoints = defensePoints;
    this.level = level;
    this.position = position;
  }

  @Override
  public void playTo(final PlayerMat playerMat) throws CardPlacementException {
    playerMat.addMonsterCard(this);
    this.mat = playerMat;
  }

  @Override
  public void removeFromMat() throws CardPlacementException {
    checkMat(CardType.MONSTER);
    mat.removeMonsterCard(this);
  }

  public void attack(final MonsterCard opponent) throws CardPlacementException {
    if (this.attackPoints > (opponent.position == CardPosition.ATTACK
                             ? opponent.attackPoints : opponent.defensePoints)) {
      opponent.sendToGraveyard();
    }
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
           getDefensePoints() == that.getDefensePoints() &&
           getName().equals(that.getName());
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

  @Override
  public CardPosition getPosition() {
    return position;
  }

  @Override
  public void setPosition(final CardPosition position) {
    this.position = position;
  }

  // endregion
}
