package dcc.cc3002.king;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  }
}