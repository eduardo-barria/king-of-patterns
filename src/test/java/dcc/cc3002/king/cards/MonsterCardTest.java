package dcc.cc3002.king.cards;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import dcc.cc3002.king.cards.utils.MonsterCardFactory;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the monster cards.
 *
 * @author Ignacio Slater M.
 */
class MonsterCardTest extends AbstractCardTest {

  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    super.init();
    var random = new Random(rngSeed);
    testCard = new MonsterCard(random.nextInt(8000), random.nextInt(8000));
  }

  @Override
  @RepeatedTest(20)
  void basicTest() {
    int expectedAttack = rng.nextInt(8000);
    int expectedDefense = rng.nextInt(8000);
    checkCardConstruction(new MonsterCardFactory(expectedAttack, expectedDefense),
        MagicCard::new);

    // Check that monster cards with different attacks and defenses are not equals
    int unexpectedAttack;
    do {
      unexpectedAttack = rng.nextInt(8000);
    } while (unexpectedAttack == expectedAttack);
    assertNotEquals(testCard, new MonsterCard(unexpectedAttack, expectedDefense));

    int unexpectedDefense;
    do {
      unexpectedDefense = rng.nextInt(8000);
    } while (unexpectedDefense == expectedDefense);
    assertNotEquals(testCard, new MonsterCard(expectedAttack, unexpectedDefense));
  }

  @Override
  @Test
  void playCardTest() {
    checkPlayedCard(testMat::getMonsterZone, testMat::getMagicZone);
  }
}