package dcc.cc3002.king;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dcc.cc3002.king.cards.AbstractCard;
import dcc.cc3002.king.cards.MagicCard;
import dcc.cc3002.king.cards.MonsterCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class AbstractCardTest {

  private AbstractCard testMonsterCard;
  private AbstractCard testMagicCard;
  private PlayerMat testMat;

  @BeforeEach
  void setUp() {
    testMonsterCard = new MonsterCard();
    testMagicCard = new MagicCard();
    testMat = new PlayerMat();
  }

  @Test
  void basicTest() {
    var expectedMonsterCard = new MonsterCard();
    var sameMonsterCard = testMonsterCard;
    assertEquals(sameMonsterCard, testMonsterCard);
    assertEquals(expectedMonsterCard, testMonsterCard);
    assertEquals(expectedMonsterCard.hashCode(), testMonsterCard.hashCode());
    var expectedMagicCard = new MagicCard();
    var sameMagicCard = testMagicCard;
    assertEquals(sameMagicCard, testMagicCard);
    assertEquals(expectedMagicCard, testMagicCard);
    assertEquals(expectedMagicCard.hashCode(), testMagicCard.hashCode());
    assertNotEquals(testMonsterCard, testMagicCard);
    assertNotEquals(testMonsterCard, new Object());
  }

  @Test
  void playMonsterCardTest() {
    assertFalse(testMat.getMonsterZone().contains(testMonsterCard));
    assertFalse(testMat.getMagicZone().contains(testMonsterCard));
    testMonsterCard.playTo(testMat);
    assertTrue(testMat.getMonsterZone().contains(testMonsterCard));
    assertFalse(testMat.getMagicZone().contains(testMonsterCard));
  }

  @Test
  void playMagicCardTest() {
    assertFalse(testMat.getMonsterZone().contains(testMagicCard));
    assertFalse(testMat.getMagicZone().contains(testMagicCard));
    testMagicCard.playTo(testMat);
    assertFalse(testMat.getMonsterZone().contains(testMagicCard));
    assertTrue(testMat.getMagicZone().contains(testMagicCard));
  }
}
