package dcc.cc3002.king.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MagicCardTest extends AbstractCardTest {

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    testCard = new MagicCard();
  }

  @Override
  @Test
  void basicTest() {
    var expectedMagicCard = new MagicCard();
    var sameMagicCard = testCard;
    assertEquals(sameMagicCard, testCard);
    assertEquals(expectedMagicCard, testCard);
    assertEquals(expectedMagicCard.hashCode(), testCard.hashCode());
    assertNotEquals(testCard, new MonsterCard());
    assertNotEquals(testCard.hashCode(), new MonsterCard().hashCode());
  }

  @Override
  @Test
  void playCardTest() {
    checkPlayedCard(testMat::getMagicZone, testMat::getMonsterZone);
  }

}