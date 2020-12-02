// "king-of-patterns" (c) by Ignacio Slater M.
// "king-of-patterns" is licensed under a
// Creative Commons Attribution 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
package cl.uchile.dcc.cc3002.king.model.effects;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

/**
 * Empty effect to represent cards that have no ability.
 *
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public class NullEffect implements IEffect {
  private static NullEffect nullEffectInstance;

  private NullEffect() {
  }

  /**
   * Gets an instance of the null effect if it has already been created or a new one if not.
   */
  public static NullEffect getInstance() {
    return nullEffectInstance == null ? new NullEffect() : nullEffectInstance;
  }

  @Override
  public void activate(final ICard card) {
    // A null effect does nothing on activation.
  }
}
