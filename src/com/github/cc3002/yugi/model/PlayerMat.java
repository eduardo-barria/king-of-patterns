package com.github.cc3002.yugi.model;

import com.github.cc3002.yugi.model.cards.FieldCard;
import com.github.cc3002.yugi.model.cards.ICard;
import com.github.cc3002.yugi.model.cards.IMagicCard;
import com.github.cc3002.yugi.model.cards.IMonsterCard;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the zone in which the player's cards are played.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @version 1.1-b.1
 * @since 1.1
 */
public class PlayerMat {

  private Player owner;
  private List<IMonsterCard> monsterZone = new ArrayList<>();
  private List<IMagicCard> magicZone = new ArrayList<>();
  private List<ICard> graveyard = new ArrayList<>();
  private FieldCard fieldCard;

  /**
   * Creates the player's mat.
   */
  public PlayerMat(Player owner) {
    this.owner = owner;
  }

  /**
   * Adds a card to the monster zone.
   * <p>
   * If the monster zone is full then the card isn't added.
   */
  public void addMonsterCard(IMonsterCard card) {
    if (monsterZone.size() < 6) {
      monsterZone.add(card);
    }
  }

  /**
   * Adds a card to the magic zone.
   * <p>
   * If the magic zone is full then the card isn't added.
   */
  public void addMagicCard(IMagicCard card) {
    if (magicZone.size() < 6) {
      magicZone.add(card);
    }
  }

  /**
   * Adds a card to the monster zone.
   * <p>
   * If the monster zone is full then the card isn't added.
   */
  public void sendMonsterToGraveyard(IMonsterCard card) {
    if (monsterZone.contains(card)) {
      monsterZone.remove(card);
      graveyard.add(card);
    }
  }

  /**
   * Adds a card to the magic zone.
   * <p>
   * If the magic zone is full then the card isn't added.
   */
  public void sendMagicCardToGraveyard(IMagicCard card) {
    if (magicZone.contains(card)) {
      magicZone.remove(card);
      graveyard.add(card);
    }
  }
}
