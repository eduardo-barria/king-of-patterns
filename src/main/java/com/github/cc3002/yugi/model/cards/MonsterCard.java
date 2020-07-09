package com.github.cc3002.yugi.model.cards;

import com.github.cc3002.yugi.model.Player;
import com.github.cc3002.yugi.model.effects.IEffect;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 */
public class MonsterCard implements IMonsterCard {

  private final String name;
  private final int attack;
  private final int defense;
  private final IEffect effect;
  private final Player owner;
  private final List<IMonsterCard> tributes = new ArrayList<>();

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

  @Override
  public void addTribute(final IMonsterCard card) {
    tributes.add(card);
  }
}
