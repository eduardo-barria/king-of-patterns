package com.github.cc3002.yugi.model.effects;

import com.github.cc3002.yugi.model.Player;

/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 */
public interface IEffect {
  void activate(final Player owner);
}
