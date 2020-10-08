package dcc.cc3002.king.cards;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dcc.cc3002.king.PlayerMat;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class AbstractCardTest {

  protected AbstractCard testCard;
  protected PlayerMat testMat;

  @BeforeEach
  void setUp() {
    testMat = new PlayerMat();
  }

  @Test
  abstract void basicTest();

  @Test
  abstract void playCardTest();

  protected void checkPlayedCard(final Supplier<List<AbstractCard>> expectedGetter,
      final Supplier<List<AbstractCard>> unexpectedGetter) {
    assertFalse(unexpectedGetter.get().contains(testCard));
    assertFalse(expectedGetter.get().contains(testCard));
    testCard.playTo(testMat);
    assertFalse(unexpectedGetter.get().contains(testCard));
    assertTrue(expectedGetter.get().contains(testCard));
  }
}
