package com.github.cc3002.yugi.controller.phases;

/**
 * @author Ignacio Slater Muñoz.
 * @since
 */
public class DrawPhase extends Phase {

  public DrawPhase() {
    this.canDraw = true;
  }

  @Override
  public void toMainPhase1() {
    changePhase(new MainPhase1());
  }

  @Override
  public void drawCard() throws InvalidMovementException {
    super.drawCard();
    toMainPhase1();
  }

  @Override
  public String toString() {
    return "Draw Phase";
  }
}
