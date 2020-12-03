package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.cards.monster.MonsterCard;
import cl.uchile.dcc.cc3002.king.model.cards.utils.ICardFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class containing the common functionalities for all types of cards.
 *
 * @author Ignacio Slater M.
 */
abstract class AbstractCardTest {

  protected static final String EXPECTED_NAME = "Expected";
  protected static final String UNEXPECTED_NAME = "Unexpected";
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
   * Checks that a card is played to the right zone of the mat.
   */
  @Test
  abstract void playCardTest() throws CardPlacementException;

  /**
   * Checks that the cards are played to the right zone of the mat.
   *
   * @param expectedZoneGetter   a reference to the getter of the zone the card should be added.
   * @param unexpectedZoneGetter a reference to the getter of the zone where the card shouldn't be added.
   */
  protected void checkPlayedCard(final Supplier<List<ICard>> expectedZoneGetter,
                                 final Supplier<List<ICard>> unexpectedZoneGetter)
      throws CardPlacementException {
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
   * @param expectedTypeFactory   a reference to the constructor of the expected card.
   * @param unexpectedTypeFactory a reference to the constructor of another type of card.
   */
  protected void checkCardConstruction(final ICardFactory expectedTypeFactory,
                                       final ICardFactory unexpectedTypeFactory) {
    final var expectedCard = expectedTypeFactory.make();
    final var sameCard = testCard;
    assertEquals(sameCard, testCard);
    assertEquals(expectedCard, testCard);
    assertEquals(expectedCard.hashCode(), testCard.hashCode(), "Hashes doesn't match");

    final var differentTypeCard = unexpectedTypeFactory.make();
    assertNotEquals(testCard, differentTypeCard);

    expectedTypeFactory.setName(UNEXPECTED_NAME);
    final var differentNameCard = expectedTypeFactory.make();
    assertNotEquals(differentNameCard, testCard);
  }
}
