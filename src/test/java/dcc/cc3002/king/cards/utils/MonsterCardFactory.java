package dcc.cc3002.king.cards.utils;

import dcc.cc3002.king.cards.CardPosition;
import dcc.cc3002.king.cards.MonsterCard;

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
