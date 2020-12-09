package cl.uchile.dcc.cc3002.king.model;

import cl.uchile.dcc.cc3002.king.controller.IEventHandler;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;
import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;

/* Un Bean es un componente software que tiene la particularidad de ser reutilizable y así evitar la tediosa tarea de programar los distintos componentes uno a uno.
https://programacion.net/articulo/beans_basico_110/10
https://kodejava.org/how-do-i-listen-for-beans-property-change-event/
PropertyChangeSupport importa PropertyChangeListener y PropertyChangeEvent.
*/
import java.beans.PropertyChangeSupport; 
import java.util.*;

public class Player {

  private final PropertyChangeSupport cardPlayedEvent = new PropertyChangeSupport(this);

  private final String name;
  private final Queue<ICard> deck; // deck: baraja; Queue: Cola
  private final List<ICard> hand = new ArrayList<>();
  private final int lifePoints;
  private final PlayerMat playerMat;
  private ICard selectedCard;

  // final: The Object itself is immutable, but the reference to it might be mutable. Making it final makes the reference immutable as well.
  public Player(final String name, final int lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
    this.deck = new ArrayDeque<>();
    for (int i = 0; i < 40; i++) {
      deck.add(new MagicCard("Dummy"));
    }
    this.playerMat = new PlayerMat();
  }

  public void selectCard(int index) {
    selectedCard = hand.get(index);
  }

  public void playCard() {
    selectedCard.playTo(playerMat);
    cardPlayedEvent.firePropertyChange("Card played by " + name, null, selectedCard);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    Player player = (Player) o;
    return name.equals(player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public int getDeckSize() {
    return deck.size();
  }

  public void drawCard() {
    // Q.poll(): The poll() method of Queue Interface returns and removes the element at the front the container. It returns null when the Queue is empty.
    hand.add(deck.poll());
  }

  public int getHandSize() {
    return hand.size();
  }

  public void addListener(IEventHandler handler) {
    /*
    Añade un objeto que estará atento a cuando se ejecute cardPlayedEvent.firePropertyChange en player y reaccionará con su método propertychange.
    En este caso se ejecuta cardPlayedEvent.firePropertyChange en playCard().
    */
    cardPlayedEvent.addPropertyChangeListener(handler);
  }
}
