package dcc.cc3002.king.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dcc.cc3002.king.ICardFactory;
import dcc.cc3002.king.PlayerMat;
import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common functionalities for all types of cards.
 *
 * @author Ignacio Slater M.
 */
abstract class AbstractCardTest {

  protected AbstractCard testCard;
  protected PlayerMat testMat;

  /**
   * Creates the game mat.
   */
  protected void initMat() {
    testMat = new PlayerMat();
  }

  /**
   * Checks the basic functionalities of a card, like comparison and hashing.
   */
  @Test
  abstract void basicTest();

  /**
   * Checks that a card is played to the right zone of the mat.
   */
  @Test
  abstract void playCardTest();

  /**
   * Checks that the cards are played to the right zone of the mat.
   *
   * @param expectedZoneGetter
   *     a reference to the getter of the zone the card should be added.
   * @param unexpectedZoneGetter
   *     a reference to the getter of the zone where the card shouldn't be added.
   */
  protected void checkPlayedCard(final Supplier<List<AbstractCard>> expectedZoneGetter,
      final Supplier<List<AbstractCard>> unexpectedZoneGetter) {
    // Initial check; neither zone should have cards
    assertFalse(unexpectedZoneGetter.get().contains(testCard));
    assertFalse(expectedZoneGetter.get().contains(testCard));
    // Plays the card and checks it's added correctly
    testCard.playTo(testMat);
    assertFalse(unexpectedZoneGetter.get().contains(testCard));
    assertTrue(expectedZoneGetter.get().contains(testCard));
  }

  /**
   * Checks that the cards are created correctly.
   *
   * @param expectedCardConstructor
   *     a reference to the constructor of the expected card.
   * @param unexpectedCardConstructor
   *     a reference to the constructor of another type of card.
   */
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
