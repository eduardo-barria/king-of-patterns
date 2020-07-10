package com.github.cc3002.yugi.controller.phases;

import com.github.cc3002.yugi.controller.GameController;
import org.jetbrains.annotations.NotNull;

/**
 * @author Ignacio Slater Muñoz.
 * @since
 */
public class Phase {
  protected GameController controller;
  protected boolean canDraw = false;

  public void setController(final @NotNull GameController controller) {
    this.controller = controller;
  }

  protected void changePhase(Phase phase) {
    controller.setPhase(phase);
  }

  public void endTurn() throws InvalidMovementException {
    throw new InvalidMovementException("Can't end turn on " + this.toString() + ".");
  }

  public void toMainPhase1() throws InvalidTransitionException {
    throw new InvalidTransitionException(
        "Can't change from " + this.toString() + " to Main phase 1");
  }

  public void drawCard() throws InvalidMovementException {
    if (!canDraw) {
      throw new InvalidMovementException("You can't draw a card now.");
    }
    controller.drawCard();
  }
}

