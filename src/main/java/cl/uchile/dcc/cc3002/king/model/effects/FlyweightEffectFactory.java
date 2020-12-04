/*
 * "King of Patterns" (c) 2020 by Ignacio Slater M.
 * "King of Patterns" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 *
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.cc3002.king.model.effects;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 */
public final class FlyweightEffectFactory {
  private static final Map<String, IEffect> effectsCache = new HashMap<>();

  private FlyweightEffectFactory() {
  }

  public static IEffect getEffect(final IEffect effect) {
    final String effectId = effect.getId();
    if (!effectsCache.containsKey(effectId)) {
      effectsCache.put(effectId, effect);
    }
    return effectsCache.get(effectId);
  }
}
