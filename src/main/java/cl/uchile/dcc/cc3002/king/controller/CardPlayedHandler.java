package cl.uchile.dcc.cc3002.king.controller;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

import java.beans.PropertyChangeEvent;

public class CardPlayedHandler implements IEventHandler {
  private final GameController controller;

  public CardPlayedHandler(GameController controller) {
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.onCardPlayed((ICard) evt.getNewValue());
  }
}
