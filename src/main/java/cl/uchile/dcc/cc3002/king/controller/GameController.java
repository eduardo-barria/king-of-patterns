package cl.uchile.dcc.cc3002.king.controller;

import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;

import java.util.LinkedList;

public class GameController {
  private final Player playerA;
  private final Player playerB;
  private final LinkedList<Player> players = new LinkedList<>();
  private final IEventHandler cardPlayedHandler = new CardPlayedHandler(this);

  public GameController() {
    playerA = new Player("Player A", 8000);
    playerB = new Player("Player B", 8000);
    players.add(playerA);
    players.add(playerB);
    playerA.addListener(cardPlayedHandler);
    playerB.addListener(cardPlayedHandler);
  }

  public void endTurn() {
    var tmp = players.removeFirst();
    players.add(tmp);
  }

  public void onCardPlayed(ICard card) {
    System.out.println(card.getName() + " was played.");
  }
}
