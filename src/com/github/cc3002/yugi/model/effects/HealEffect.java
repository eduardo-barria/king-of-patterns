package com.github.cc3002.yugi.model.effects;

import com.github.cc3002.yugi.model.Player;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 */
public class HealEffect implements IEffect {
  private final int amount;

  public HealEffect(int amount) {
    this.amount = amount;
  }

  @Override
  public void activate(Player target) {
    target.setLifePoints(target.getLifePoints() + amount);
  }
}
