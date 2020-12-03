package cl.uchile.dcc.cc3002.king.model.cards.utils;

import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;
import cl.uchile.dcc.cc3002.king.model.cards.monster.IMonsterCard;
import cl.uchile.dcc.cc3002.king.model.cards.monster.MonsterCard;

public class MonsterCardFactory implements ICardFactory {

  private final int attack;
  private final int defense;
  private String name;

  public MonsterCardFactory(final String name, final int attack, final int defense) {
    this.name = name;
    this.attack = attack;
    this.defense = defense;
  }

  @Override
  public IMonsterCard make() {
    return new MonsterCard(name, null, attack, defense, 0, null);
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }
}
