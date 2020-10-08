package dcc.cc3002.king.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dcc.cc3002.king.ICardFactory;
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

  protected void checkPlayedCard(final Supplier<List<AbstractCard>> expectedZoneGetter,
      final Supplier<List<AbstractCard>> unexpectedZoneGetter) {
    assertFalse(unexpectedZoneGetter.get().contains(testCard));
    assertFalse(expectedZoneGetter.get().contains(testCard));
    testCard.playTo(testMat);
    assertFalse(unexpectedZoneGetter.get().contains(testCard));
    assertTrue(expectedZoneGetter.get().contains(testCard));
  }

  protected void checkCardConstruction(ICardFactory<AbstractCard> expectedCardConstructor,
      ICardFactory<AbstractCard> unexpectedCardConstructor) {
    var expectedCard = expectedCardConstructor.make();
    var sameCard = testCard;
    assertEquals(sameCard, testCard);
    assertEquals(expectedCard, testCard);
    assertEquals(expectedCard.hashCode(), testCard.hashCode());
    assertNotEquals(testCard, unexpectedCardConstructor.make());
    assertNotEquals(testCard.hashCode(), unexpectedCardConstructor.hashCode());
  }
}
