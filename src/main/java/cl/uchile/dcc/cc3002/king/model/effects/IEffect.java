// "king-of-patterns" (c) by Ignacio Slater M.
// "king-of-patterns" is licensed under a
// Creative Commons Attribution 4.0 International License.
//
// You should have received a copy of the license along with this
// work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
package cl.uchile.dcc.cc3002.king.model.effects;

import cl.uchile.dcc.cc3002.king.model.cards.ICard;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public interface IEffect {
  void activate(ICard card);
}
