package cl.uchile.dcc.cc3002.king.cards;

import cl.uchile.dcc.cc3002.king.cards.utils.ICardFactory;
import cl.uchile.dcc.cc3002.king.cards.utils.MonsterCardFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
    testCard = new MagicCard("Test magic card");
  }

  @Override
  @RepeatedTest(20)
  void basicTest() {
    ICardFactory monsterFactory = new MonsterCardFactory(rng.nextInt(8000),
        rng.nextInt(8000));
    checkCardConstruction(this::makeMagicCard, monsterFactory);
  }

  @Override
  @Test
  void playCardTest() {
    checkPlayedCard(testMat::getMagicZone, testMat::getMonsterZone);
  }
}