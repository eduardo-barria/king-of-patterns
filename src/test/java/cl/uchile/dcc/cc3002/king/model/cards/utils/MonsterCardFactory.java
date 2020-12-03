package cl.uchile.dcc.cc3002.king.model.cards.utils;

import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;
import cl.uchile.dcc.cc3002.king.model.cards.monster.IMonsterCard;

public class MonsterCardFactory implements ICardFactory {

  private final int attack;
  private final int defense;

  public MonsterCardFactory(final int attack, final int defense) {
    this.attack = attack;
    this.defense = defense;
  }

  @Override
  public IMonsterCard make() {
    return new Rank1Monster("", new Player("", 0), attack, defense, 0, CardPosition.ATTACK);
  }
}
