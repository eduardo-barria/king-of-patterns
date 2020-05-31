package com.github.cc3002.yugi.model.cards;

import com.github.cc3002.yugi.model.Player;
import com.github.cc3002.yugi.model.effects.IEffect;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 */
public class MonsterCard implements ICard {
  private String name;
  private int attack;
  private int defense;
  private IEffect effect;
  private Player owner;

  public MonsterCard(String name, int attack, int defense, IEffect effect, Player owner) {
    this.name = name;
    this.attack = attack;
    this.defense = defense;
    this.effect = effect;
    this.owner = owner;
  }

  @Override
  public void play() {
    //
  }

  public void useEffect() {
    effect.activate(owner);
  }
}
