package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.cards.monster.MonsterCard;
import cl.uchile.dcc.cc3002.king.model.cards.utils.MagicCardFactory;
import cl.uchile.dcc.cc3002.king.model.cards.utils.MonsterCardFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

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
    final var random = new Random(rngSeed);
    testCard = new MonsterCard(EXPECTED_NAME, null, random.nextInt(8000), random.nextInt(8000),
                               0, CardPosition.ATTACK);
  }

  @RepeatedTest(20)
  void constructorTest() {
    final var rng = new Random(rngSeed);
    final int expectedAttack = rng.nextInt(8000);
    final int expectedDefense = rng.nextInt(8000);

    final var monsterFactory =
        new MonsterCardFactory(EXPECTED_NAME, expectedAttack, expectedDefense);
    final var magicFactory = new MagicCardFactory(EXPECTED_NAME);
    checkCardConstruction(monsterFactory, magicFactory);

    final var differentAttackCard =
        new MonsterCard(EXPECTED_NAME, null, expectedAttack - 1, expectedDefense, 0,
                        CardPosition.ATTACK);
    assertNotEquals(differentAttackCard, testCard);

    final var differentDefenseCard =
        new MonsterCard(EXPECTED_NAME, null, expectedAttack, expectedDefense - 1, 0,
                        CardPosition.ATTACK);
    assertNotEquals(differentDefenseCard, testCard);
  }

  @Override
  @Test
  void playCardTest() throws CardPlacementException {
    checkPlayedCard(testMat::getMonsterZone, testMat::getMagicZone);
  }

  @Test
  void cardPositionTest() {
    final var testMonsterCard =
        new MonsterCard("", null, 1000, 1500, 0, CardPosition.ATTACK);
    assertEquals(CardPosition.ATTACK, testMonsterCard.getPosition());
    testMonsterCard.setPosition(CardPosition.DEFENSE);
    assertEquals(CardPosition.DEFENSE, testMonsterCard.getPosition());
  }

  @RepeatedTest(16)
  void attackToAttackModeCardTest() throws CardPlacementException {
    checkAttack(CardPosition.ATTACK);
  }

  @RepeatedTest(16)
  void attackToDefenseModeCardTest() throws CardPlacementException {
    checkAttack(CardPosition.DEFENSE);
  }

  void checkAttack(final CardPosition defenderPosition) throws CardPlacementException {
    final var attackerMat = new PlayerMat();
    final var defenderMat = new PlayerMat();
    MonsterCard defender, attacker;
    if (defenderPosition == CardPosition.ATTACK) {
      defender = new MonsterCard("", null, rng.nextInt(2000), Integer.MAX_VALUE,
                                 0, defenderPosition);
      attacker =
          new MonsterCard("", null, rng.nextInt(2000) + 2000, Integer.MAX_VALUE,
                          0, CardPosition.ATTACK);
    } else {
      defender = new MonsterCard("", null, Integer.MAX_VALUE, rng.nextInt(2000),
                                 0, defenderPosition);
      attacker =
          new MonsterCard("", null, Integer.MAX_VALUE, rng.nextInt(2000) + 2000,
                          0, CardPosition.ATTACK);
    }
    attacker.playTo(attackerMat);
    defender.playTo(defenderMat);
    assertTrue(attackerMat.getMonsterZone().contains(attacker));
    assertTrue(defenderMat.getMonsterZone().contains(defender));

    attacker.attack(defender);
    assertTrue(attackerMat.getMonsterZone().contains(attacker));
    assertFalse(defenderMat.getMonsterZone().contains(defender));

    if (defenderPosition == CardPosition.ATTACK) {
      attacker = new MonsterCard("", null, rng.nextInt(2000), Integer.MAX_VALUE,
                                 0, defenderPosition);
      defender = new MonsterCard("", null, rng.nextInt(2000) + 2000, Integer.MAX_VALUE, 0,
                                 CardPosition.ATTACK);
    } else {
      attacker = new MonsterCard("", null, Integer.MAX_VALUE, rng.nextInt(2000),
                                 0, defenderPosition);
      defender = new MonsterCard("", null, Integer.MAX_VALUE, rng.nextInt(2000) + 2000,
                                 0, CardPosition.ATTACK);
    }
    attacker.playTo(attackerMat);
    defender.playTo(defenderMat);

    attacker.attack(defender);
    assertTrue(attackerMat.getMonsterZone().contains(attacker));
    assertTrue(defenderMat.getMonsterZone().contains(defender));
  }
}