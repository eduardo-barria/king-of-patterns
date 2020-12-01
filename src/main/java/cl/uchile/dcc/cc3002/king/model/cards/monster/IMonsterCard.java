package cl.uchile.dcc.cc3002.king.model.cards.monster;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

public interface IMonsterCard extends ICard {
  void addTribute(IMonsterCard card);

  // region : Field accessors
  int getAttackPoints();

  int getDefensePoints();

  int getLevel();
  // endregion
}
