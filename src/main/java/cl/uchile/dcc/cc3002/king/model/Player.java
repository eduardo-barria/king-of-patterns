package cl.uchile.dcc.cc3002.king.model;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.controller.CardSelectionException;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;
import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;
import cl.uchile.dcc.cc3002.king.model.cards.monster.IMonsterCard;

import java.util.*;

public class Player {

  private final String name;
  private final Queue<ICard> deck;
  private final List<ICard> hand = new ArrayList<>();
  private final List<ICard> graveyard = new ArrayList<>();
  private final PlayerMat mat;
  private final List<IMonsterCard> selectedTributes = new ArrayList<>();
  private int lifePoints;


  public Player(final String name, final int lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
    this.deck = new ArrayDeque<>();
    for (int i = 0; i < 40; i++) {
      deck.add(new MagicCard("Dummy", this));
    }
    this.mat = new PlayerMat();
  }

  public void selectTribute(final int index) throws CardSelectionException {
    selectedTributes.add(mat.getMonsterCardAt(index));
  }

  // region : Card placement
  public void drawCard() {
    hand.add(deck.poll());
  }

  public void sendToGraveyard(final ICard card) throws CardPlacementException {
    card.removeFromMat();
    graveyard.add(card);
  }
  // endregion

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

  // region : Accessors
  public int getDeckSize() {
    return deck.size();
  }

  public int getHandSize() {
    return hand.size();
  }

  public List<IMonsterCard> getSelectedTributes() {
    return List.copyOf(selectedTributes);
  }

  public void increaseLifePoints(final int lifePoints) {
    this.lifePoints += lifePoints;
  }
  // endregion
}
