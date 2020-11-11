package cl.uchile.dcc.cc3002.king.model;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;
import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;

import java.util.*;

public class Player {

  private final String name;
  private final Queue<ICard> deck;
  private final List<ICard> hand = new ArrayList<>();
  private final int lifePoints;
  private final PlayerMat playerMat;


  public Player(final String name, final int lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
    this.deck = new ArrayDeque<>();
    for (int i = 0; i < 40; i++) {
      deck.add(new MagicCard("Dummy"));
    }
    this.playerMat = new PlayerMat();
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
    hand.add(deck.poll());
  }

  public int getHandSize() {
    return hand.size();
  }
}
