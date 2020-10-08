package dcc.cc3002.king.cards;

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
    checkCardConstruction(MagicCard::new, MonsterCard::new);
  }

  @Override
  @Test
  void playCardTest() {
    checkPlayedCard(testMat::getMagicZone, testMat::getMonsterZone);
  }

}