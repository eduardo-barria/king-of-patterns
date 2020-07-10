package com.github.cc3002.yugi.model;

import com.github.cc3002.yugi.controller.handlers.IHandler;
import com.github.cc3002.yugi.model.cards.ICard;
import com.github.cc3002.yugi.model.cards.MonsterCard;
import com.github.cc3002.yugi.model.effects.NullEffect;
import org.jetbrains.annotations.Unmodifiable;

import java.beans.PropertyChangeSupport;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Player {

  private final List<ICard> hand = new ArrayList<>();
  private final Queue<ICard> deck = new ArrayDeque<>();
  private final PropertyChangeSupport cardPlayedNotification = new PropertyChangeSupport(
      this);
  private ICard selectedCard = null;
  private int lifePoints = 8000;

  public Player(final int deckSize) {
    for (int i = 0; i < deckSize; i++) {
      deck.add(new MonsterCard("", 0, 0, new NullEffect(), this));
    }
  }

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

  public @Unmodifiable List<ICard> getHand() {
    return List.copyOf(hand);
  }

  public @Unmodifiable List<ICard> getDeck() {
    return List.copyOf(deck);
  }

  public void drawCard() {
    ICard card = deck.poll();
    hand.add(card);
  }
}
