package com.github.cc3002.yugi.controller.phases;

/**
 * @author Ignacio Slater Muñoz.
 * @since
 */
public class MainPhase1 extends Phase {

  public MainPhase1() {
    this.canDraw = false;
  }

  @Override
  public void drawCard() throws InvalidMovementException {
    super.drawCard();
    this.canDraw = false;
  }

  @Override
  public void endTurn() {
    controller.nextTurn();
    changePhase(new DrawPhase());
  }

  @Override
  public String toString() {
    return "Main Phase 1";
  }
}
