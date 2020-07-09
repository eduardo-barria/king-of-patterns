package com.github.cc3002.yugi.model;

import com.github.cc3002.yugi.controller.handlers.IHandler;
import com.github.cc3002.yugi.model.cards.ICard;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Player {

  private final List<ICard> hand = new ArrayList<>();
  private final PropertyChangeSupport cardPlayedNotification = new PropertyChangeSupport(
      this);
  private ICard selectedCard = null;
  private int lifePoints = 8000;

  public void addCard(ICard card) {
    hand.add(card);
  }

  public void selectCard(int index) {
    selectedCard = hand.get(index);
  }

  public void playCard() {
    selectedCard.play();
    cardPlayedNotification.firePropertyChange("CARD_PLAYED", null, selectedCard);
  }

  public int getLifePoints() {
    return lifePoints;
  }

  public void setLifePoints(final int lifePoints) {
    this.lifePoints = lifePoints;
  }

  public void addCardPlayedListener(final IHandler cardPlayedHandler) {
    cardPlayedNotification.addPropertyChangeListener(cardPlayedHandler);
  }
}
