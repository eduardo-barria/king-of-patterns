package dcc.cc3002.king.cards;

import org.junit.jupiter.api.BeforeEach;
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
    super.initMat();
    testCard = new MonsterCard();
  }

  @Override
  @Test
  void basicTest() {
    checkCardConstruction(MonsterCard::new, MagicCard::new);
  }

  @Override
  @Test
  void playCardTest() {
    checkPlayedCard(testMat::getMonsterZone, testMat::getMagicZone);
  }
}