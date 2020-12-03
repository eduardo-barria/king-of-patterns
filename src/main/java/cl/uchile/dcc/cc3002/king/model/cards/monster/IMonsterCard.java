package cl.uchile.dcc.cc3002.king.model.cards.monster;

import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;

public interface IMonsterCard extends ICard {
  // region : Field accessors
  int getAttackPoints();

  int getDefensePoints();

  int getLevel();

  CardPosition getPosition();

  void setPosition(CardPosition position);
  // endregion
}
