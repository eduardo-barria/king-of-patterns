package cl.uchile.dcc.cc3002.king.model.cards.utils;

import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;
import cl.uchile.dcc.cc3002.king.model.cards.MonsterCard;

public class MonsterCardFactory implements ICardFactory {

  private final int attack;
  private final int defense;

  public MonsterCardFactory(int attack, int defense) {
    this.attack = attack;
    this.defense = defense;
  }

  @Override
  public MonsterCard make() {
    return new MonsterCard(attack, defense, CardPosition.ATTACK);
  }
}
