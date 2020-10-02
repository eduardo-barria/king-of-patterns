package dcc.cc3002.king;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameMatTest {

  private GameMat testMat;

  @BeforeEach
  void setUp() {
    testMat = new GameMat();
  }

  @Test
  void basicTest() {
    var expectedMat = new GameMat();
    assertEquals(expectedMat, testMat);
    assertEquals(expectedMat.hashCode(), testMat.hashCode());
  }

  @Test
  void monsterZoneTest() {
    assertTrue(testMat.getMonsterZone().isEmpty());
    for (int i = 0; i < 5; i++) {
      testMat.getMonsterZone().add(new Card());
      assertEquals(i + 1, testMat.getMonsterZone().size());
    }
  }
}