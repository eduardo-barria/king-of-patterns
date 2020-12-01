package cl.uchile.dcc.cc3002.king.model;

import cl.uchile.dcc.cc3002.king.AbstractKoPTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PlayerTest extends AbstractKoPTest {
  private static final String NAME_YUGI = "Yugi";
  private static final String NAME_SETO = "Seto";
  private static final int DECK_SIZE = 40;
  private Player yugi;

  @BeforeEach
  public void setUp() {
    super.setUp();
    yugi = new Player(NAME_YUGI, randnGenerator.nextInt(8000));
  }

  @RepeatedTest(8)
  void basicTest() {
    var yami = yugi;
    assertEquals(yami, yugi, failMessage());
    assertEquals(yami.hashCode(), yugi.hashCode(), failMessage());
    var yugiClone = new Player(NAME_YUGI, randnGenerator.nextInt(8000));
    assertEquals(yugiClone, yugi, failMessage());
    assertEquals(yugiClone.hashCode(), yugi.hashCode(), failMessage());
    var seto = new Player(NAME_SETO, randnGenerator.nextInt(8000));
    assertNotEquals(yugi, seto, failMessage());
  }

  @Test
  void cardsTest() {
    int currentDeckSize = DECK_SIZE;
    int currentHandSize = 0;
    for (int i = 0; i < DECK_SIZE; i++) {
      assertEquals(currentDeckSize--, yugi.getDeckSize());
      assertEquals(currentHandSize++, yugi.getHandSize());
      yugi.drawCard();
    }
    assertEquals(0, yugi.getDeckSize());
    assertEquals(DECK_SIZE, yugi.getHandSize());
  }
}
