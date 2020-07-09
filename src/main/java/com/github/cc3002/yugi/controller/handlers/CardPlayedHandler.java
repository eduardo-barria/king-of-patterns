package com.github.cc3002.yugi.controller.handlers;

import com.github.cc3002.yugi.controller.GameController;
import com.github.cc3002.yugi.model.cards.ICard;
import java.beans.PropertyChangeEvent;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 */
public class CardPlayedHandler implements IHandler {
  private final GameController controller;

  public CardPlayedHandler(final GameController controller) {
    this.controller = controller;
  }

  /**
   * This method gets called when a bound property is changed.
   *
   * @param evt
   *     A PropertyChangeEvent object describing the event source
   *     and the property that has changed.
   */
  @Override
  public void propertyChange(final PropertyChangeEvent evt) {
    controller.onCardPlayed((ICard) evt.getNewValue());
  }
}
