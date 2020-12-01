package cl.uchile.dcc.cc3002.king.model.cards.utils;

import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;
import cl.uchile.dcc.cc3002.king.model.cards.monster.AbstractMonsterCard;

public class MonsterCardFactory implements ICardFactory {

  private final int attack;
  private final int defense;

  public MonsterCardFactory(final int attack, final int defense) {
    this.attack = attack;
    this.defense = defense;
  }

  @Override
  public AbstractMonsterCard make() {
    return new AbstractMonsterCard(attack, defense, CardPosition.ATTACK);
  }
}
