package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.cards.monster.MonsterCard;
import cl.uchile.dcc.cc3002.king.model.cards.utils.ICardFactory;
import cl.uchile.dcc.cc3002.king.model.cards.utils.MagicCardFactory;
import cl.uchile.dcc.cc3002.king.model.cards.utils.MonsterCardFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test suite for the magic cards.
 *
 * @author Ignacio Slater M.
 */
class MagicCardTest extends AbstractCardTest {

  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    super.init();
    testCard = new MagicCard(EXPECTED_NAME, null);
  }

  @RepeatedTest(20)
  void constructorTest() {
    final var rng = new Random(rngSeed);

    final var expectedCard = new MagicCard(EXPECTED_NAME, null);
    final var sameCard = testCard;
    assertEquals(sameCard, testCard);
    assertEquals(expectedCard, testCard);
    assertEquals(expectedCard.hashCode(), testCard.hashCode(), "Hashes doesn't match");

    final var differentTypeCard = new MonsterCard(EXPECTED_NAME, null, rng.nextInt(8000), rng.nextInt(8000), 0, null);
    assertNotEquals(testCard, differentTypeCard);

    final var differentNameCard = new MagicCard(UNEXPECTED_NAME, null);
    assertNotEquals(differentNameCard, testCard);
  }

  @Override
  @Test
  void playCardTest() throws CardPlacementException {
    checkPlayedCard(testMat::getMagicZone, testMat::getMonsterZone);
  }
}