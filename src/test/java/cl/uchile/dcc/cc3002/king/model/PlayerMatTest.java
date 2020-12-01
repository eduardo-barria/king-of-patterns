package cl.uchile.dcc.cc3002.king.model;

import cl.uchile.dcc.cc3002.king.model.cards.CardPosition;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;
import cl.uchile.dcc.cc3002.king.model.cards.MagicCard;
import cl.uchile.dcc.cc3002.king.model.cards.monster.AbstractMonsterCard;
import cl.uchile.dcc.cc3002.king.model.cards.utils.ICardFactory;
import cl.uchile.dcc.cc3002.king.model.cards.utils.MagicCardFactory;
import cl.uchile.dcc.cc3002.king.model.cards.utils.MonsterCardFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

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
    final var sameMat = testMat;
    assertEquals(sameMat, testMat);
    final var expectedMat = new PlayerMat();
    assertNotEquals(testMat, new Object());
    assertEquals(expectedMat, testMat);
    assertEquals(expectedMat.hashCode(), testMat.hashCode());
    // This lines will assure the branch coverage
    testMat.addMagicCard(new MagicCard("Test card"));
    assertNotEquals(testMat, new PlayerMat());
    assertNotEquals(testMat.hashCode(), new PlayerMat().hashCode());
    testMat = new PlayerMat();
    testMat.addMonsterCard(new AbstractMonsterCard(1000, 1000, CardPosition.ATTACK));
    assertNotEquals(testMat, new PlayerMat());
    assertNotEquals(testMat.hashCode(), new PlayerMat().hashCode());
    testMat.addMagicCard(new MagicCard("Test card"));
  }

  /**
   * Checks that monster cards are added correctly to the mat.
   *
   * @see PlayerMat#getMonsterZone()
   * @see PlayerMat#addMonsterCard(AbstractMonsterCard)
   */
  @Test
  void monsterZoneTest() {
    // Using this notation we can pass method references to the test and reduce code
    // duplication.
    testCardZone(testMat::getMonsterZone, this::addMonsterCard,
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

  private void addMonsterCard(final ICard card) {
    testMat.addMonsterCard((AbstractMonsterCard) card);
  }

  /**
   * Checks that magic cards are added correctly to the mat.
   *
   * @see PlayerMat#getMagicZone()
   * @see PlayerMat#addMagicCard(MagicCard)
   */
  @Test
  void magicZoneTest() {
    final ICardFactory magicFactory = new MagicCardFactory("Test card");
    // Using this notation we can pass method references to the test and reduce code
    // duplication.
    testCardZone(testMat::getMagicZone, this::addMagicCard, magicFactory);
  }

  private void addMagicCard(final ICard card) {
    testMat.addMagicCard((MagicCard) card);
  }

  @Test
  void removeMagicCardTest() {
    checkCardRemoval(new MagicCard("Test card"), new MagicCard("Wrong card"),
                     testMat::getMagicZone, this::removeMagicCard, this::addMagicCard);
  }

  private void checkCardRemoval(final ICard expectedCard, final ICard unexpectedCard,
                                final Supplier<List<ICard>> zoneGetter,
                                final Consumer<ICard> cardRemover,
                                final Consumer<ICard> cardAdder) {
    assertTrue(zoneGetter.get().isEmpty());
    cardRemover.accept(expectedCard);
    assertTrue(zoneGetter.get().isEmpty());
    cardAdder.accept(expectedCard);
    assertEquals(1, zoneGetter.get().size());
    cardRemover.accept(unexpectedCard);
    assertEquals(1, zoneGetter.get().size());
    cardRemover.accept(expectedCard);
    assertTrue(zoneGetter.get().isEmpty());
  }

  private void removeMagicCard(final ICard magicCard) {
    testMat.removeMagicCard((MagicCard) magicCard);
  }

  @Test
  void removeMonsterCardTest() {
    checkCardRemoval(new AbstractMonsterCard(1000, 1000, CardPosition.ATTACK),
                     new AbstractMonsterCard(0, 0, CardPosition.DEFENSE),
                     testMat::getMonsterZone, this::removeMonsterCard, this::addMonsterCard);
  }

  private void removeMonsterCard(final ICard monsterCard) {
    testMat.removeMonsterCard((AbstractMonsterCard) monsterCard);
  }
}