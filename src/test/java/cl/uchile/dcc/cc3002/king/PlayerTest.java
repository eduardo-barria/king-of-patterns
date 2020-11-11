package cl.uchile.dcc.cc3002.king;

import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

class PlayerTest {

  private Player testPlayer;
  private Random randnGenerator;

  @BeforeEach
  void setUp() {
    long seed = new Random().nextLong();
    randnGenerator = new Random(seed);
    testPlayer = new Player("Player 1", 8000);
  }


}
