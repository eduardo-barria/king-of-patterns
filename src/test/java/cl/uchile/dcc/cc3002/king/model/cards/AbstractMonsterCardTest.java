package cl.uchile.dcc.cc3002.king.model.cards;

import cl.uchile.dcc.cc3002.king.controller.CardPlacementException;
import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.PlayerMat;
import cl.uchile.dcc.cc3002.king.model.cards.monster.AbstractMonsterCard;
import cl.uchile.dcc.cc3002.king.model.cards.monster.Rank1Monster;
import cl.uchile.dcc.cc3002.king.model.cards.utils.ICardFactory;
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
class AbstractMonsterCardTest extends AbstractCardTest {

  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    super.init();
    final var random = new Random(rngSeed);
    testCard = new Rank1Monster("", new Player("", 0), random.nextInt(8000), random.nextInt(8000),
                                0, CardPosition.ATTACK);
  }

  @Override
  @RepeatedTest(20)
  void basicTest() {
    final int expectedAttack = rng.nextInt(8000);
    final int expectedDefense = rng.nextInt(8000);
    final ICardFactory magicFactory = new MagicCardFactory("Test card");
    checkCardConstruction(new MonsterCardFactory(expectedAttack, expectedDefense),
                          magicFactory);

    // Check that monster cards with different attacks and defenses are not equals
    int unexpectedAttack;
    do {
      unexpectedAttack = rng.nextInt(8000);
    } while (unexpectedAttack == expectedAttack);
    assertNotEquals(testCard,
                    new Rank1Monster("", new Player("", 0), unexpectedAttack, expectedDefense,
                                     0, CardPosition.ATTACK));

    int unexpectedDefense;
    do {
      unexpectedDefense = rng.nextInt(8000);
    } while (unexpectedDefense == expectedDefense);
    assertNotEquals(testCard,
                    new Rank1Monster("", new Player("", 0), expectedAttack, unexpectedDefense,
                                     0, CardPosition.ATTACK));
  }

  @Override
  @Test
  void playCardTest() {
    checkPlayedCard(testMat::getMonsterZone, testMat::getMagicZone);
  }

  @Test
  void cardPositionTest() {
    final var testMonsterCard =
        new Rank1Monster("", new Player("", 0), 1000, 1500, 0, CardPosition.ATTACK);
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
    AbstractMonsterCard defender, attacker;
    if (defenderPosition == CardPosition.ATTACK) {
      defender = new Rank1Monster("", new Player("", 0), rng.nextInt(2000), Integer.MAX_VALUE,
                                  0, defenderPosition);
      attacker =
          new Rank1Monster("", new Player("", 0), rng.nextInt(2000) + 2000, Integer.MAX_VALUE,
                           0, CardPosition.ATTACK);
    } else {
      defender = new Rank1Monster("", new Player("", 0), Integer.MAX_VALUE, rng.nextInt(2000),
                                  0, defenderPosition);
      attacker =
          new Rank1Monster("", new Player("", 0), Integer.MAX_VALUE, rng.nextInt(2000) + 2000,
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
      attacker = new Rank1Monster("", new Player("", 0), rng.nextInt(2000), Integer.MAX_VALUE,
                                  0, defenderPosition);
      defender =
          new Rank1Monster("", new Player("", 0), rng.nextInt(2000) + 2000, Integer.MAX_VALUE,
                           0, CardPosition.ATTACK);
    } else {
      attacker = new Rank1Monster("", new Player("", 0), Integer.MAX_VALUE, rng.nextInt(2000),
                                  0, defenderPosition);
      defender =
          new Rank1Monster("", new Player("", 0), Integer.MAX_VALUE, rng.nextInt(2000) + 2000,
                           0, CardPosition.ATTACK);
    }
    attacker.playTo(attackerMat);
    defender.playTo(defenderMat);

    attacker.attack(defender);
    assertTrue(attackerMat.getMonsterZone().contains(attacker));
    assertTrue(defenderMat.getMonsterZone().contains(defender));
  }
}