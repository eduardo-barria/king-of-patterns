package cl.uchile.dcc.cc3002.king.model;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;
import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;
import cl.uchile.dcc.cc3002.king.model.effects.HealEffect;

import java.util.*;

public class Player {

  private final String name;
  private final Queue<ICard> deck;
  private final List<ICard> hand = new ArrayList<>();
  private int lifePoints;


  public Player(final String name, final int lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
    this.deck = new ArrayDeque<>();
    for (int i = 0; i < 40; i++) {
      deck.add(new MagicCard("Dummy", this, new HealEffect(500)));
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    final Player player = (Player) o;
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
    hand.add(deck.poll());
  }

  public int getHandSize() {
    return hand.size();
  }

  public int getLifePoints() {
    return lifePoints;
  }

  public void increaseHP(final int amount) {
    this.lifePoints += amount;
  }
}
