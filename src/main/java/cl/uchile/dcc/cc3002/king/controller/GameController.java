package cl.uchile.dcc.cc3002.king.controller;

import cl.uchile.dcc.cc3002.king.model.Player;
import cl.uchile.dcc.cc3002.king.model.cards.ICard;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer {
  private final Player playerA;
  private final Player playerB;
  private final LinkedList<Player> players = new LinkedList<>();

  public GameController() {
    playerA = new Player("Player A", 8000);
    playerB = new Player("Player B", 8000);
    players.add(playerA);
    players.add(playerB);
    playerA.addObserver(this);
    playerB.addObserver(this);
  }

  public void endTurn() {
    var tmp = players.removeFirst();
    players.add(tmp);
  }

  @Override
  public void update(Observable o, Object arg) {
    if (arg instanceof ICard) {
      onCardPlayed((ICard) arg);
    }
  }

  private void onCardPlayed(ICard card) {
    System.out.println(card.getName() + " was played.");
  }
}
