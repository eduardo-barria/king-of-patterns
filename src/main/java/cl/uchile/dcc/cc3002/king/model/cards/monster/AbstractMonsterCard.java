package cl.uchile.dcc.cc3002.king.model.cards.monster;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.cards.AbstractCard;
import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;

import java.util.Objects;

public abstract class AbstractMonsterCard extends AbstractCard implements IMonsterCard {

  private final int attackPoints;
  private final int defensePoints;
  protected int level;
  private CardPosition position;
  private PlayerMat mat;

  protected AbstractMonsterCard(final String name, final Player owner, final int attackPoints,
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
    final var selectedTributes = owner.getSelectedTributes();
    if (hasEnoughTributes(selectedTributes.size())) {
      selectedTributes.forEach(owner::sendToGraveyard);
      playerMat.addMonsterCard(this);
      this.mat = playerMat;
    }
  }

  @Override
  public void removeFromMat() {

  }

  protected abstract boolean hasEnoughTributes(int tributes) throws CardPlacementException;

  public void attack(final AbstractMonsterCard opponent) {
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
