package cl.uchile.dcc.cc3002.king.controller;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

import java.beans.PropertyChangeEvent;

public class CardPlayedHandler implements IEventHandler {
  private final GameController controller;

  public CardPlayedHandler(GameController controller) {
    /*
    Setea el controlador con controller
    */
    this.controller = controller;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    /*
    Sobreescritura de la función propertyChange, necesaria para hacer uso de PropertyChangeSupport y sus funcionalidades.
    Imprime para el usuario la carta que se acaba de jugar.
    */
    controller.onCardPlayed((ICard) evt.getNewValue());
  }
}
