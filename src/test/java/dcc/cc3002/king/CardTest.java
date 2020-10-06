package dcc.cc3002.king;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {

  private Card testCard;

  @BeforeEach
  void setUp() {
    testCard = new Card();
  }

  @Test
  void basicTest() {
    var expectedCard = new Card();
    assertEquals(expectedCard, testCard);
    assertEquals(expectedCard.hashCode(), testCard.hashCode());
  }
}
