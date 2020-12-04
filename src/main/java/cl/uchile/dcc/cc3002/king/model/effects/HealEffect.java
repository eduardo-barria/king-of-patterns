package cl.uchile.dcc.cc3002.king.model.effects;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

public class HealEffect extends AbstractEffect {
  private final int healAmount;

  public HealEffect(final int healAmount) {
    super(Effects.HEAL.toString() + "healAmount");
    this.healAmount = healAmount;
  }

  @Override
  public void activate(final ICard card) {
    card.getOwner().increaseHP(healAmount);
  }
}
