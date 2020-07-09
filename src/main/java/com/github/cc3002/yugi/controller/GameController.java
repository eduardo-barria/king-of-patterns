package com.github.cc3002.yugi.controller;

import com.github.cc3002.yugi.controller.handlers.CardPlayedHandler;
import com.github.cc3002.yugi.controller.handlers.IHandler;
import com.github.cc3002.yugi.model.Player;
import com.github.cc3002.yugi.model.cards.ICard;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeSupport;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 */
public class GameController {

  private final Player player = new Player();
  private final IHandler cardPlayedHandler = new CardPlayedHandler(this);
  private final PropertyChangeSupport onCardPlayedNotification = new PropertyChangeSupport(
      this);

  public GameController() {
    player.addCardPlayedListener(cardPlayedHandler);
  }

  public void onCardPlayed(@NotNull ICard playedCard) {
    onCardPlayedNotification.firePropertyChange("CARD_PLAYED", null, playedCard);
  }
}
