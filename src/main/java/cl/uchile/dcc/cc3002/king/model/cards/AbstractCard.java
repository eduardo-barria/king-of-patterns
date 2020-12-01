package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.effects.IEffect;

public abstract class AbstractCard implements ICard {
  private final IEffect effect;
  private final Player owner;
  protected String name;

  protected AbstractCard(final String name, final Player owner, final IEffect effect) {
    this.name = name;
    this.effect = effect;
    this.owner = owner;
  }

  @Override
  public void useEffect() {
    effect.activate(this);
  }

  @Override
  public Player getOwner() {
    return owner;
  }
}
