package dcc.cc3002.king;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dcc.cc3002.king.cards.*;
import dcc.cc3002.king.cards.utils.ICardFactory;
import dcc.cc3002.king.cards.utils.MonsterCardFactory;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite for the game mat.
 *
 * @author Ignacio Slater M.
 */
class PlayerMatTest {

  private PlayerMat testMat;

  /**
   * Initializes a test game mat.
   */
  @BeforeEach
  void setUp() {
    testMat = new PlayerMat();
  }

  /**
   * Checks that the game mat is created correctly.
   * <p>
   * This tests the equals and hashCode methods.
   *
   * @see PlayerMat#equals(Object)
   * @see PlayerMat#hashCode()
   */
  @Test
  void basicTest() {
    var sameMat = testMat;
    assertEquals(sameMat, testMat);
    var expectedMat = new PlayerMat();
    assertNotEquals(testMat, new Object());
    assertEquals(expectedMat, testMat);
    assertEquals(expectedMat.hashCode(), testMat.hashCode());
    // This lines will assure the branch coverage
    testMat.addMagicCard(new MagicCard());
    assertNotEquals(testMat, new PlayerMat());
    assertNotEquals(testMat.hashCode(), new PlayerMat().hashCode());
    testMat = new PlayerMat();
    testMat.addMonsterCard(new MonsterCard(1000, 1000));
    assertNotEquals(testMat, new PlayerMat());
    assertNotEquals(testMat.hashCode(), new PlayerMat().hashCode());
    testMat.addMagicCard(new MagicCard());
  }

  /**
   * Checks that monster cards are added correctly to the mat.
   *
   * @see PlayerMat#getMonsterZone()
   * @see PlayerMat#addMonsterCard(ICard)
   */
  @Test
  void monsterZoneTest() {
    // Using this notation we can pass method references to the test and reduce code
    // duplication.
    testCardZone(testMat::getMonsterZone, testMat::addMonsterCard,
        new MonsterCardFactory(1000, 1000));
  }

  /**
   * Tests that a card is added correctly to the appropriate zone.
   *
   * @param zoneGetter
   *     a getter method.
   *     A supplier is a method that receives no parameters and returns an object.
   *     In this case, it returns an object of type {@code List<AbstractCard>}.
   * @param cardAdder
   *     an adder method.
   *     A consumer is a method that receives a parameter and returns nothing.
   *     In this case, it receives an object of type {@code AbstractCard}.
   * @param cardFactory
   *     the card type constructor.
   *     In this context a factory is a functional interface that creates elements of type
   *     {@code AbstractCard}.
   */
  private void testCardZone(final Supplier<List<ICard>> zoneGetter,
      final Consumer<ICard> cardAdder,
      final ICardFactory cardFactory) {
    assertTrue(zoneGetter.get().isEmpty());
    for (int i = 0; i < 5; i++) {
      cardAdder.accept(cardFactory.make());
      assertEquals(i + 1, zoneGetter.get().size());
    }
    cardAdder.accept(cardFactory.make());
    assertEquals(5, zoneGetter.get().size());
  }

  /**
   * Checks that magic cards are added correctly to the mat.
   *
   * @see PlayerMat#getMagicZone()
   * @see PlayerMat#addMagicCard(ICard)
   */
  @Test
  void magicZoneTest() {
    // Using this notation we can pass method references to the test and reduce code
    // duplication.
    testCardZone(testMat::getMagicZone, testMat::addMagicCard, MagicCard::new);
  }
}