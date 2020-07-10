package com.github.cc3002.yugi.controller;

import com.github.cc3002.yugi.controller.handlers.CardPlayedHandler;
import com.github.cc3002.yugi.controller.handlers.IHandler;
import com.github.cc3002.yugi.controller.phases.DrawPhase;
import com.github.cc3002.yugi.controller.phases.InvalidMovementException;
import com.github.cc3002.yugi.controller.phases.Phase;
import com.github.cc3002.yugi.model.Player;
import com.github.cc3002.yugi.model.cards.ICard;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeSupport;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 */
public class GameController {
  private final Player[] players = {new Player(60), new Player(60)};
  private final IHandler cardPlayedHandler = new CardPlayedHandler(this);
  private final PropertyChangeSupport onCardPlayedNotification = new PropertyChangeSupport(
      this);
  private int turn = 0;
  private Phase phase;

  public GameController() {
    for (Player player :
        players) {
      player.addCardPlayedListener(cardPlayedHandler);
    }
    this.setPhase(new DrawPhase());
  }

  public void onCardPlayed(@NotNull ICard playedCard) {
    onCardPlayedNotification.firePropertyChange("CARD_PLAYED", null, playedCard);
  }

  public int[] playersHandSizes() {
    return new int[]{players[0].getHand().size(), players[1].getHand().size()};
  }

  public int[] playersDeckSizes() {
    return new int[]{players[0].getDeck().size(), players[1].getDeck().size()};
  }

  public void drawCard() {
    players[turn % 2].drawCard();
  }

  public void setPhase(final @NotNull Phase phase) {
    this.phase = phase;
    phase.setController(this);
  }

  public String getCurrentPhase() {
    return phase.toString();
  }

  public void tryToDrawCard() {
    try {
      phase.drawCard();
    } catch (InvalidMovementException e) {
      e.printStackTrace();
    }
  }

  public void nextTurn() {
    turn++;
  }
}
