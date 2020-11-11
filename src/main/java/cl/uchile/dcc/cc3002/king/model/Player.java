package cl.uchile.dcc.cc3002.king.model;

import java.util.Objects;

public class Player {

  private final String name;
  private int lifePoints;

  public Player(final String name, final int lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    Player player = (Player) o;
    return name.equals(player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
