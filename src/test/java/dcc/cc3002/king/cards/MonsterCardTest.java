package dcc.cc3002.king.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dcc.cc3002.king.PlayerMat;
import dcc.cc3002.king.cards.utils.ICardFactory;
import dcc.cc3002.king.cards.utils.MagicCardFactory;
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
    testCard = new MonsterCard(random.nextInt(8000), random.nextInt(8000),
        CardPosition.ATTACK);
  }

  @Override
  @RepeatedTest(20)
  void basicTest() {
    int expectedAttack = rng.nextInt(8000);
    int expectedDefense = rng.nextInt(8000);
    ICardFactory magicFactory = new MagicCardFactory("Test card");
    checkCardConstruction(new MonsterCardFactory(expectedAttack, expectedDefense),
        magicFactory);

    // Check that monster cards with different attacks and defenses are not equals
    int unexpectedAttack;
    do {
      unexpectedAttack = rng.nextInt(8000);
    } while (unexpectedAttack == expectedAttack);
    assertNotEquals(testCard, new MonsterCard(unexpectedAttack, expectedDefense,
        CardPosition.ATTACK));

    int unexpectedDefense;
    do {
      unexpectedDefense = rng.nextInt(8000);
    } while (unexpectedDefense == expectedDefense);
    assertNotEquals(testCard, new MonsterCard(expectedAttack, unexpectedDefense,
        CardPosition.ATTACK));
  }

  @Override
  @Test
  void playCardTest() {
    checkPlayedCard(testMat::getMonsterZone, testMat::getMagicZone);
  }

  @Test
  void cardPositionTest() {
    var testMonsterCard = new MonsterCard(1000, 1500, CardPosition.ATTACK);
    assertEquals(CardPosition.ATTACK, testMonsterCard.getPosition());
    testMonsterCard.setPosition(CardPosition.DEFENSE);
    assertEquals(CardPosition.DEFENSE, testMonsterCard.getPosition());
  }

  @RepeatedTest(16)
  void attackToAttackModeCardTest() {
    checkAttack(CardPosition.ATTACK);
  }

  @RepeatedTest(16)
  void attackToDefenseModeCardTest() {
    checkAttack(CardPosition.DEFENSE);
  }

  void checkAttack(final CardPosition defenderPosition) {
    var attackerMat = new PlayerMat();
    var defenderMat = new PlayerMat();
    MonsterCard defender, attacker;
    if (defenderPosition == CardPosition.ATTACK) {
      defender = new MonsterCard(rng.nextInt(2000), Integer.MAX_VALUE,
          defenderPosition);
      attacker = new MonsterCard(rng.nextInt(2000) + 2000, Integer.MAX_VALUE,
          CardPosition.ATTACK);
    } else {
      defender = new MonsterCard(Integer.MAX_VALUE, rng.nextInt(2000),
          defenderPosition);
      attacker = new MonsterCard(Integer.MAX_VALUE, rng.nextInt(2000) + 2000,
          CardPosition.ATTACK);
    }
    attacker.playTo(attackerMat);
    defender.playTo(defenderMat);
    assertTrue(attackerMat.getMonsterZone().contains(attacker));
    assertTrue(defenderMat.getMonsterZone().contains(defender));

    attacker.attack(defender);
    assertTrue(attackerMat.getMonsterZone().contains(attacker));
    assertFalse(defenderMat.getMonsterZone().contains(defender));

    if (defenderPosition == CardPosition.ATTACK) {
      attacker = new MonsterCard(rng.nextInt(2000), Integer.MAX_VALUE,
          defenderPosition);
      defender = new MonsterCard(rng.nextInt(2000) + 2000, Integer.MAX_VALUE,
          CardPosition.ATTACK);
    } else {
      attacker = new MonsterCard(Integer.MAX_VALUE, rng.nextInt(2000),
          defenderPosition);
      defender = new MonsterCard(Integer.MAX_VALUE, rng.nextInt(2000) + 2000,
          CardPosition.ATTACK);
    }
    attacker.playTo(attackerMat);
    defender.playTo(defenderMat);

    attacker.attack(defender);
    assertTrue(attackerMat.getMonsterZone().contains(attacker));
    assertTrue(defenderMat.getMonsterZone().contains(defender));
  }
}