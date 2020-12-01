package cl.uchile.dcc.cc3002.king;

import java.util.Random;

public abstract class AbstractKoPTest {
  protected long seed;
  protected Random randnGenerator;

  protected void setUp() {
    seed = new Random().nextLong();
    randnGenerator = new Random(seed);
  }

  protected String failMessage() {
    return "Test failed with seed: " + seed;
  }
}
