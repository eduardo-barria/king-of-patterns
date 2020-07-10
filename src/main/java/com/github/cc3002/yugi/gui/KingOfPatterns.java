package com.github.cc3002.yugi.gui;

import com.github.cc3002.yugi.controller.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * @author Ignacio Slater Muñoz.
 * @since
 */
public class KingOfPatterns extends Application {
  private final GameController controller = new GameController();
  private final Group root = new Group();
  private Label handLabel;
  private Label deckLabel;
  private Label phaseLabel;
  private Button drawButton;

  /**
   * Entry point of the application.
   *
   * @param primaryStage
   *     the primary stage for this application, onto which the application scene can be set.
   *     Applications may create other stages, if needed, but they will not be primary stages.
   */
  @Override
  public void start(final @NotNull Stage primaryStage) {
    primaryStage.setTitle("King of Patterns");
    primaryStage.setResizable(false);
    Scene scene = createScene();
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private @NotNull Scene createScene() {
    Scene scene = new Scene(root, 1280, 720);
    handLabel = createLabel(10, 10);
    deckLabel = createLabel(10, 30);
    phaseLabel = createLabel(200, 10);
    drawButton = new Button("Draw card");
    drawButton.setLayoutX(10);
    drawButton.setLayoutY(60);
    drawButton.setOnAction(event -> controller.tryToDrawCard());
    root.getChildren().add(drawButton);
    startAnimator();
    return scene;
  }

  private void startAnimator() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        int handCards = controller.playersHandSizes()[0];
        int deckCards = controller.playersDeckSizes()[0];
        handLabel.setText("Player's hand: " + handCards);
        deckLabel.setText("Player's deck: " + deckCards);
        phaseLabel.setText(controller.getCurrentPhase());
      }
    };
    timer.start();
  }

  private @NotNull Label createLabel(int xPos, int yPos) {
    Label label = new Label();
    label.setLayoutX(xPos);
    label.setLayoutY(yPos);
    root.getChildren().add(label);
    return label;
  }
}
