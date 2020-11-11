package dcc.cc3002.king.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dcc.cc3002.king.PlayerMat;
import dcc.cc3002.king.cards.utils.ICardFactory;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * Class containing the common functionalities for all types of cards.
 *
 * @author Ignacio Slater M.
 */
abstract class AbstractCardTest {

  protected ICard testCard;
  protected PlayerMat testMat;
  protected long rngSeed;
  protected Random rng;
  /**
   * Creates the game mat and the basic elements to create cards.
   */
  protected void init() {
    rngSeed = new Random().nextLong();
    rng = new Random(rngSeed);
    testMat = new PlayerMat();
  }

  /**
   * Checks the basic functionalities of a card, like comparison and hashing.
   */
  @RepeatedTest(20)
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
  protected void checkPlayedCard(final Supplier<List<ICard>> expectedZoneGetter,
      final Supplier<List<ICard>> unexpectedZoneGetter) {
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
  protected void checkCardConstruction(ICardFactory expectedCardConstructor,
      ICardFactory unexpectedCardConstructor) {
    var expectedCard = expectedCardConstructor.make();
    var sameCard = testCard;
    assertEquals(sameCard, testCard);
    assertEquals(expectedCard, testCard);
    assertEquals(expectedCard.hashCode(), testCard.hashCode());
    assertNotEquals(testCard, unexpectedCardConstructor.make());
    assertNotEquals(testCard.hashCode(), unexpectedCardConstructor.hashCode());
  }

  protected ICard makeMagicCard() {
    return new MagicCard("Test magic card");
  }
}
